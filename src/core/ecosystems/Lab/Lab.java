package core.ecosystems.Lab;

import core.Main;
import core.ecosystems.Animal;
import core.ecosystems.Arctic.animals.Lemming;
import core.ecosystems.Arctic.animals.PolarBear;
import core.ecosystems.Arctic.animals.Walrus;
import core.ecosystems.Game;
import core.ecosystems.Plant;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Lab extends BasicGameState {

    private int id;
    private StateBasedGame sbg;
    private GameContainer gc;

    private UpgradeLab upgrade;

    private ArrayList<AnimalButton> animalMachines;
    private ArrayList<PlantButton> plantMachines;

    private ArrayList<AnimalButton> availableAnimals;
    private ArrayList<PlantButton> availablePlants;

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

        availablePlants = new ArrayList<>();
        availableAnimals = new ArrayList<>();

        animalMachines = new ArrayList<>();
        plantMachines = new ArrayList<>();

        //makes new animal buttons
        availableAnimals.add( new AnimalButton(0,500, PolarBear.class, "polar bear"));
        availableAnimals.add(new AnimalButton(500, 500, Walrus.class, "walrus"));
        availableAnimals.add(new AnimalButton(1000, 500, Lemming.class, "lemming"));

        //makes new plant button
        availablePlants.add(new PlantButton(1500,500, Plant.class, "plant"));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setBackground(Color.green);
        for (AnimalButton m: animalMachines)
        {
            m.render(graphics);
        }

        for (PlantButton p: plantMachines)
        {
            p.render(graphics);
        }
        if (upgrade != null)
        {
            upgrade.render(graphics);
            upgrade.reset();
        }


        graphics.drawString("animal: "+availableAnimals.size() + "\nplant: "+availablePlants.size(), 0, 300);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
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
            else if (!availablePlants.isEmpty())
            {
                plantMachines.add(availablePlants.getFirst());
                availablePlants.removeFirst();
            }
            if (availableAnimals.isEmpty() && availablePlants.isEmpty()) {
                upgrade = null;
            }
        }
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
        if (key == Input.KEY_E)
        {
            sbg.enterState(Main.GAME_ID);
        }


    }

    public void mousePressed(int button, int x, int y)
    {
        // This code happens every time the user presses the mouse
        for (AnimalButton m: animalMachines)
        {
            if (m.isMouseOver(x,y))
            {
                Game.getCurrentLevel().addAnimal(m.getAnimal());
            }
        }

        for (PlantButton m: plantMachines)
        {
            if (m.isMouseOver(x,y))
            {
                Game.getCurrentLevel().addPlant(m.getPlant());
            }
        }

        if (upgrade != null && upgrade.isMouseOver(x,y))
        {
            upgrade.action();
        }



    }
}