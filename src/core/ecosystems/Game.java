package core.ecosystems;

import core.Main;
import core.ecosystems.Arctic.Arctic;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static core.Main.LAB_ID;

public class Game extends BasicGameState
{
	private int id;
	private StateBasedGame sbg;
	public static int levelID;
	private Ecosystem[] ecosystems;
	private final static int NUM_ECOSYSTEMS = 1;


	public Game(int id)
	{
		this.id = id;
	}

	public int getID()
	{
		return id;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		// This code happens when you enter a game state for the *first time.*
		this.sbg = sbg;
		gc.setShowFPS(true);
		ecosystems = new Ecosystem[NUM_ECOSYSTEMS];
		ecosystems[0] = new Arctic();

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		// This updates your game's logic every frame.  NO DRAWING.
		ecosystems[levelID].update();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		// This code renders shapes and images every frame.
		g.setColor(Color.white);
		// REPLACE THIS
		g.drawString(String.valueOf(levelID), Main.getScreenWidth() * .5f, Main.getScreenHeight() * .5f);
		ecosystems[levelID].render(g);
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
		sbg.enterState(LAB_ID);
	}

	public void mousePressed(int button, int x, int y)
	{
		// This code happens every time the user presses the mouse
		ecosystems[levelID].mousePressed(x,y);
	}

	public void mouseMoved(int oldx, int oldy, int newx, int newy) {

	}



}