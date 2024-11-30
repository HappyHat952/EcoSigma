package core.ecosystems;

import core.Main;
import core.ecosystems.Arctic.Arctic;
import core.setup.PopupLoader;
import core.ui.PopupManager;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static core.Main.LAB_ID;

public class Game extends BasicGameState
{
	private int id;
	private StateBasedGame sbg;
	private GameContainer gc;
	public static int levelID;
	private static Ecosystem[] ecosystems;
	private final static int NUM_ECOSYSTEMS = 2;
	private static boolean pause;
	private static PopupManager popupManager;
	int numPopupsShown;


	public Game(int id)
	{

		this.id = id;
	}

	public static boolean getPause() { return pause;
	}

	public int getID()
	{
		return id;
	}

	public void init(GameContainer gc, StateBasedGame sbg ) throws SlickException
	{
		// This code happens when you enter a game state for the *first time.*
		this.sbg = sbg;
		this.gc = gc;
		gc.setShowFPS(true);
		pause = false;
		ecosystems = new Ecosystem[NUM_ECOSYSTEMS];
		popupManager = new PopupManager();
		ecosystems[0] = new Arctic( gc, sbg, popupManager);
		ecosystems[1] = new Arctic( gc, sbg, popupManager);

		//popupManager.activate(0);




	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		// This updates your game's logic every frame.  NO DRAWING.

		if (!pause)
		{
			ecosystems[levelID].update();
		}

		popupManager.update();

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		// This code renders shapes and images every frame.
		g.setColor(Color.white);
		g.setBackground(Color.darkGray);
		// REPLACE THIS
		g.drawString(String.valueOf(levelID), Main.getScreenWidth() * .5f, Main.getScreenHeight() * .5f);
		ecosystems[levelID].render(g);
		popupManager.render(g);
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
			sbg.enterState(Main.MAP_ID);
		}
	}

	public void mousePressed(int button, int x, int y)
	{
		// This code happens every time the user presses the mouse
		if (!pause) {
			ecosystems[levelID].mousePressed(x, y);
		}
		popupManager.mousePressed(button, x, y);
	}

	public void mouseMoved(int oldx, int oldy, int newx, int newy) {

	}

	public static Ecosystem getCurrentLevel() {
		return ecosystems[levelID];
	}

	public static void pause()
	{
		pause = true;
	}
	public static void   unpause()
	{
		pause = false;
	}


}