package core.lab;

import core.Main;
import core.ecosystems.arctic.animals.Lemming;
import core.ecosystems.arctic.animals.PolarBear;
import core.ecosystems.arctic.animals.Walrus;
import core.Game;
import core.ecosystems.coralreef.animals.Clownfish;
import core.ecosystems.farm.animals.PluroCultureCrop;
import core.ecosystems.coralreef.animals.JellyFish;
import core.ecosystems.coralreef.animals.Seaweed;
import core.ecosystems.coralreef.animals.Stingray;
import core.ecosystems.general.Cell;
import core.ecosystems.general.Organism;
import core.ecosystems.general.Plant;
import core.ecosystems.rainforest.animals.Frog;
import core.lab.organismMaker.OrganismMaker;
import core.lab.petriDish.PetriDish;
import core.setup.Images;
import core.setup.PopupLoader;
import core.ui.PopupManager;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Lab extends BasicGameState {

    private int id;
    private static StateBasedGame sbg;
    private static GameContainer gc;

    private static ArrayList<Class<? extends Organism>> availableOrganisms;

    private static LabScreen[] machines;
    private static GenomeMaker genomeMaker;
    private static PetriDish petriDish;
    private static OrganismMaker organismMaker;

    private static ArrayList<Genome> genomes ;

    private static boolean freezeScreen; // doesn't allow clicking outside when "in" a machine.

    public Lab(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        gc = gameContainer;
        sbg = stateBasedGame;

        availableOrganisms = new ArrayList();


        genomes = new ArrayList<>();

        genomeMaker = new GenomeMaker();
        petriDish = new PetriDish();
        organismMaker = new OrganismMaker();

        machines = new LabScreen[3];
        machines[0] = genomeMaker;
        machines[1] = petriDish;
        machines[2] = organismMaker;
//
//        PopupLoader.loadPopups(-1);
//        PopupManager.activate(0);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        g.drawImage(Images.labBackground,0,0);

        LabScreen openLab = null;
        for (LabScreen l: machines)
        {
            if (l.getIsOpen())
            {
                openLab = l;
            }
            l.render(g);
        }//prints the open lab1 in the front
        if (openLab != null) {  openLab.render(g);}

        PopupManager.render(g);

        int index =0;
        for(Genome gen: genomes)
        {
            g.setColor(Color.black);
            if(gen.isEgged()){ g.setColor(Color.red);}
            else{ g.setColor(Color.blue);}

            g.drawString(""+getOrganismName(gen.getOrganism()),Main.getScreenWidth()*.5f, Main.getScreenHeight()*index*.02f);
            index ++;
        }


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
       if (!Game.getPause())
       {
           for (LabScreen l: machines)
           {
               l.update();
           }
       }
        PopupManager.update();
       for (int j = 0; j< genomes.size(); j++)
       {
           if (genomes.get(j).isUsed())
           {
               genomes.remove(j);
               j --;
           }
       }
        petriDish.setDishes(genomes);

    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        // This code happens when you enter a gameState.

    }

    public void leave(GameContainer gc, StateBasedGame sbg)
    {
        // This code happens when you leave a gameState.
    }

    public void keyPressed(int key, char c)
    {
        // This code happens every time the user presses a key
        if (!Game.getPause())
        {
            if (key == Input.KEY_E)
            {
                sbg.enterState(Main.GAME_ID);
            }
            for (LabScreen l: machines)
            {
                l.keyPressed(key,c);
            }
        }



    }

    public void mousePressed(int button, int x, int y)
    {
        // This code happens every time the user presses the mouse
        if (!Game.getPause())
        {

            if (!freezeScreen)
            {

            }


            //only allows clicking on the one that is " open"
            for (LabScreen l: machines)
            {
                if (!freezeScreen || l.getIsOpen())
                {
                    l.mouseClicked(button,x,y);
                }

            }
        }

        PopupManager.mousePressed(button,x,y);



    }

    public static void freeze()
    {
        freezeScreen = true;
    }
    public static void unfreeze()
    {
        freezeScreen = false;
    }

    public static void addGenome( Genome genome){ genomes.add(genome);
    petriDish.setDishes(genomes);}
    public static ArrayList<Genome> getGenomes(){ return genomes;}

    public static void addOrganismToGame(Class<? extends Organism> o ){ Game.getCurrentLevel().addOrganism(o);}

    public static String getOrganismName(Class<? extends Organism> o)
    {
        try {
            Constructor constructor = o.getDeclaredConstructor(Cell.class);
            Organism organism = o.getDeclaredConstructor(Cell.class).newInstance(new Cell(0,0));
            return organism.toString();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

    public static GenomeMaker getGenomeMaker(){ return genomeMaker;}
    public static PetriDish getPetriDish(){ return petriDish;}
    public static OrganismMaker getOrganismMaker(){ return organismMaker;}


    public static ArrayList<Class<? extends Organism>> getAvailableOrganisms(){ return availableOrganisms;}

    //use this to change the available Organisms.
    public static void setAvailableAnimals(int biome)
    {
        availableOrganisms = new ArrayList<>();
        if (biome == 0) {

            //makes new animal buttons
            availableOrganisms.add(PolarBear.class);
            availableOrganisms.add(Walrus.class);
            availableOrganisms.add(Lemming.class);

            //makes new plant button
            availableOrganisms.add(Plant.class);
        }
        else if (biome == 1)
        {
                availableOrganisms.add(Clownfish.class);
            availableOrganisms.add(Stingray.class);
            availableOrganisms.add(JellyFish.class);

            availableOrganisms.add(Seaweed.class);
        }
        else if (biome == 3 )
        {
            availableOrganisms.add(PluroCultureCrop.class);
        }
        else if (biome == 4)
        {
            //availableOrganisms.add(Frog.class);
        }
        else
        {
            availableOrganisms.add(Plant.class);
        }
        genomeMaker.setButtons();



    }
}