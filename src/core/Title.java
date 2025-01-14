package core;

import core.setup.Fonts;
import core.setup.Images;
import core.setup.PopupLoader;
import core.setup.Sounds;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static core.Main.INTRO_ID;

public class Title extends BasicGameState {

    private int id;
    StateBasedGame sbg;
    private int frame;

    private int frameCount;

    public Title(int id) {

        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        Images.loadImages();
        Sounds.loadSounds();
        PopupLoader.loadPopups(0);
        sbg = stateBasedGame;
        Fonts.loadFonts();
        frame = 0;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(Images.introScreenSheet.getSubImage(0,frame), 0, 0);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        frameCount ++;
        if (frameCount % 60 ==0)
        {
            if(frame == 0){ frame = 1;}
            else { frame = 0;}
            frameCount = 0;
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
        sbg.enterState(INTRO_ID);
    }

    public void mousePressed(int button, int x, int y)
    {
        // This code happens every time the user presses the mouse
    }
}
