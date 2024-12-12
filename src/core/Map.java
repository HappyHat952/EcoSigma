package core;

import core.buttons.Button;
import core.buttons.MapButton;
import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

import static core.Main.GAME_ID;
import static core.Main.INTRO_ID;

public class Map extends BasicGameState {

    private int id;
    StateBasedGame sbg;
    // BUTTONS
    private ArrayList<Button> mapScreenButtons;
    private final int buttonW = 1;
    private final int buttonH = 1;

    public Map(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        sbg = stateBasedGame;
        mapScreenButtons = new ArrayList<>();
        mapScreenButtons.add(new MapButton((int) (Main.getScreenWidth()*.5f), (int) (Main.getScreenHeight()*.5f), 50, 50, Color.white, 0));
        mapScreenButtons.add(new MapButton((int) (Main.getScreenWidth()*.6f), (int) (Main.getScreenHeight()*.4f), 50, 50, Color.green, 1));
        mapScreenButtons.add(new MapButton((int) (Main.getScreenWidth()*.4f), (int) (Main.getScreenHeight()*.3f), 50, 50, Color.pink, 2));
        mapScreenButtons.add(new MapButton((int) (Main.getScreenWidth()*.5f), (int) (Main.getScreenHeight()*.2f), 50, 50, Color.orange, 3));
        mapScreenButtons.add(new MapButton((int) (Main.getScreenWidth()*.5f), (int) (Main.getScreenHeight()*.6f), 50, 50, Color.blue, 4));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(Images.mapScreen, 0, 0);
        for (Button b: mapScreenButtons) {
            b.render(graphics);
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
//        sbg.enterState(GAME_ID);
    }

    public void mousePressed(int button, int x, int y)
    {
        // This code happens every time the user presses the mouse
        for (Button b: mapScreenButtons) {
            if (b.isMouseOver(x, y) && b instanceof MapButton) {
                ((MapButton) b).action(sbg);
                break;
            }
            // ADD FOR OTHER BUTTONS IN MAP
        }
    }
}
