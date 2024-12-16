package core.ecosystems.lab;

import core.Main;
import core.ecosystems.arctic.animals.Lemming;
import core.ecosystems.arctic.animals.PolarBear;
import core.ecosystems.arctic.animals.Walrus;
import core.Game;
import core.ecosystems.general.Plant;
import core.ui.PopupManager;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Lab extends BasicGameState {

    private int id;
    private StateBasedGame sbg;
    private GameContainer gc;

    private UpgradeLab upgrade;

    private ArrayList<OrganismCreator> animalMachines;

    private ArrayList<OrganismCreator> availableAnimals;

    private LabScreen[] machines;
    private GenomeMaker genomeMaker;
    private PetriDish petriDish;

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

        upgrade = new UpgradeLab();

        availableAnimals = new ArrayList<>();

        animalMachines = new ArrayList<>();

        genomeMaker = new GenomeMaker();
        petriDish = new PetriDish();

        machines = new LabScreen[2];
        machines[0] = genomeMaker;
        machines[1] = petriDish;

        //makes new animal buttons
        availableAnimals.add( new OrganismCreator(0,500, PolarBear.class, "polar bear"));
        availableAnimals.add(new OrganismCreator(500, 500, Walrus.class, "walrus"));
        availableAnimals.add(new OrganismCreator(1000, 500, Lemming.class, "lemming"));

        //makes new plant button
        availableAnimals.add(new OrganismCreator(1500,500, Plant.class, "plant"));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setBackground(Color.green);
        for (OrganismCreator m: animalMachines)
        {
            m.render(graphics);
        }

        for (LabScreen l: machines)
        {
            l.render(graphics);
        }

        if (upgrade != null)
        {
            upgrade.render(graphics);
            upgrade.reset();
        }
        PopupManager.render(graphics);


        graphics.drawString("animal: "+availableAnimals.size(), 0, 300);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
       if (!Game.getPause())
       {
           if (upgrade != null)
           {
               upgrade.update();
           }

           if (upgrade != null && upgrade.isComplete())
           {
               if (!availableAnimals.isEmpty())
               {
                   animalMachines.add(availableAnimals.getFirst());
                   availableAnimals.removeFirst();
               }

               else {
                   upgrade = null;
               }
           }

           for (LabScreen l: machines)
           {
               l.update();
           }
       }
        PopupManager.update();

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
//            for (OrganismCreator m: animalMachines)
//            {
//                if (m.isMouseOver(x,y))
//                {
//                    Game.getCurrentLevel().addAnimal(m.getOrganism());
//                }
//            }
            for (OrganismCreator m: animalMachines)
            {
                if (m.isMouseOver(x,y))
                {
                    Game.getCurrentLevel().addOrganism(m.getOrganism());
                }
            }


            if (upgrade != null && upgrade.isMouseOver(x,y))
            {
                upgrade.action();
            }

            for (LabScreen l: machines)
            {
                l.mouseClicked(button,x,y);
            }
        }

        PopupManager.mousePressed(button,x,y);



    }
}