package core.ecosystems.Lab;

import core.AnimalTest;
import core.Main;
import core.ecosystems.Arctic.animals.Lemming;
import core.ecosystems.Arctic.animals.PolarBear;
import core.ecosystems.Arctic.animals.Walrus;
import core.ecosystems.Game;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import core.ecosystems.Animal;

import java.util.ArrayList;

public class Lab extends BasicGameState {

    private int id;
    private StateBasedGame sbg;
    private GameContainer gc;
    private ArrayList<ResearchButton> machines;

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
        machines = new ArrayList<>();
        machines.add( new ResearchButton(0,500, PolarBear.class, "polar bear"));
        machines.add(new ResearchButton(500, 500, Walrus.class, "walrus"));
        machines.add(new ResearchButton(1000, 500, Lemming.class, "lemming"));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setBackground(Color.green);
        for (ResearchButton m: machines)
        {
            m.render(graphics);
        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
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
        for (ResearchButton m: machines)
        {
            if (m.isMouseOver(x,y))
            {
                Game.getCurrentLevel().addAnimal(m.getAnimal());
            }
        }



    }
}