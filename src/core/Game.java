package core;

import core.ecosystems.Ecosystem;
import core.ecosystems.Shop;
import core.ecosystems.arctic.Arctic;
import core.ecosystems.coralreef.CoralReef;
import core.ecosystems.farm.Farm;
import core.ecosystems.rainforest.RainForest;
import core.lab.Lab;
import core.setup.FileIO;
import core.setup.Sounds;
import core.ui.PopupManager;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Game extends BasicGameState
{
	private int id;
	private static StateBasedGame sbg;
	private static  GameContainer gc;
	public static int levelID;
	private static Ecosystem[] ecosystems;
	private final static int NUM_ECOSYSTEMS = 4;
	private static boolean pause;
	private static PopupManager popupManager;
	private static FileIO fileIO;
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
		// This code happens when you enter a game state for the *first time.* heelp
		this.sbg = sbg;
		this.gc = gc;
		gc.setShowFPS(true);
		pause = false;
		ecosystems = new Ecosystem[NUM_ECOSYSTEMS];
		popupManager = new PopupManager();
		fileIO = new FileIO();
		fileIO.readFile();

		ecosystems[0] = new Arctic(gc, sbg, popupManager, 0);
		ecosystems[1] = new CoralReef(gc, sbg, popupManager, 1);
		ecosystems[2] = new RainForest(gc, sbg, popupManager, 2);
		ecosystems[3] = new Farm(gc, sbg, popupManager, 3);

		for (int i = 0; i < NUM_ECOSYSTEMS; i++) {
			ecosystems[i].setCompleted(fileIO.isLevelCompleted(i + 1));
			ecosystems[i].setOrganismItems(Lab.getOrganismForBiome(i));
		}
	}

	public static void reset(int i)
	{
		if (i == 0)
		{
			ecosystems[0] = new Arctic(gc, sbg, popupManager, 0);
		}
		if (i == 1)
		{
			ecosystems[1] = new CoralReef(gc, sbg, popupManager, 1);
		}
		if (i == 2)
		{
			ecosystems[2] = new RainForest(gc, sbg, popupManager, 2);
		}
		if (i == 3)
		{
			ecosystems[3] = new Farm(gc, sbg, popupManager, 3);
		}
		for (int j = 0; j < NUM_ECOSYSTEMS; j++) {
			ecosystems[j].setCompleted(fileIO.isLevelCompleted(j + 1));
			ecosystems[j].setOrganismItems(Lab.getOrganismForBiome(i));
		}
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		// This updates your game's logic every frame.  NO DRAWING.

		if (!pause)
		{
			ecosystems[levelID].update();
			if (ecosystems[levelID].isCompleted() && !fileIO.isLevelCompleted(levelID + 1)) {
				fileIO.updateFile(levelID + 1);
			}
		}
		popupManager.update();


	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		// This code renders shapes and images every frame.
		g.setColor(Color.white);
		if (levelID == 0) {
			g.setBackground(new Color(130, 132, 133));
		} else if (levelID == 1) {
			g.setBackground(new Color(130, 132, 133));
		} else if (levelID == 2) {
			g.setBackground(new Color(130, 132, 133));
		} else {
			g.setBackground(new Color(130, 132, 133));
		}

		// REPLACE THIS
		g.drawString(String.valueOf(levelID), Main.getScreenWidth() * .5f, Main.getScreenHeight() * .5f);
		ecosystems[levelID].render(g);
		popupManager.render(g);
	}

	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		// This code happens when you enter a gameState.
		gc.setDefaultMouseCursor();
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
			Sounds.coralReef.stop();
			((CoralReef) ecosystems[1]).setSoundOn(false);
		}
	}

	public void mousePressed(int button, int x, int y)
	{
		// This code happens every time the user presses the mouse
		if (!pause) {
			ecosystems[levelID].mousePressed(x, y, button);
		}
		popupManager.mousePressed(button, x, y);
	}

	public void mouseMoved(int oldx, int oldy, int newx, int newy) {

	}

	public static Ecosystem getCurrentLevel() {
		return ecosystems[levelID];
	}

	public static Shop getCurrentShop(){ return getCurrentLevel().getShop();}

	public static void pause()
	{
		pause = true;
	}


	public static void unpause()
	{
		pause = false;
	}

	public static int getLevelID() {
		return levelID;
	}

	public static Ecosystem[] getEcosystems(){
		return ecosystems;
	}

	public static PopupManager getPopupManager(){ return popupManager;}

}