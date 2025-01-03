package core;

import core.setup.Images;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static core.Main.INTRO_ID;
import static core.Main.MAP_ID;

public class Intro extends BasicGameState {

    private int id;
    StateBasedGame sbg;
    private Image currentSlide;
    private int slideNumber;

    public Intro(int id) {
        this.id = id;
    }
    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        sbg = stateBasedGame;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(currentSlide, 0, 0);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        // This code happens when you enter a gameState.
        slideNumber = 2;
        currentSlide = (Images.introScreenSheet.getSprite(0, slideNumber)).getScaledCopy(Main.getScreenWidth(),
                Main.getScreenHeight());
    }

    public void leave(GameContainer gc, StateBasedGame sbg)
    {
        // This code happens when you leave a gameState.
    }

    public void keyPressed(int key, char c)
    {
        // This code happens every time the user presses a key
        if (key == Input.KEY_SPACE)
        {
            if (slideNumber < Images.introScreenSheet.getVerticalCount()-1) {
                slideNumber++;
                currentSlide = (Images.introScreenSheet.getSprite(0, slideNumber)).getScaledCopy(Main.getScreenWidth(),
                        Main.getScreenHeight());
            }
            else {
                sbg.enterState(MAP_ID);
            }
        }

    }

    public void mousePressed(int button, int x, int y)
    {
        // This code happens every time the user presses the mouse
    }
}
