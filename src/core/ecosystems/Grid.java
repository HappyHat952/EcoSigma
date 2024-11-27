package core.ecosystems;

import core.Main;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Grid {
    protected final static int GRID_SIZE = 10; // number of squares in horizontal and vertical
    protected static int gridWidth; //size of the grid relative to 1920 x 1080
    protected Cell[][] cells;
    protected Building mouseBuilding;//a building that is purchased (only one)
    protected ArrayList<Building> buildings;
    protected ArrayList<Animal> animals;
    protected GameContainer gc;
    protected StateBasedGame sbg;

    public Grid(GameContainer gc)
    {
        setGridWidth();
        Cell.setWidth(gridWidth/GRID_SIZE);
        Cell.setHeight(Main.getScreenHeight()/GRID_SIZE);

        cells = new Cell[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++)
        {
            for (int j = 0; j < GRID_SIZE; j++)
            {
                cells[i][j] = new Cell(i,j);
            }
        }
        buildings = new ArrayList<>();
        animals = new ArrayList<>();

        animals.add(new Animal(cells[2][3]));

        this.gc = gc;
    }

    public void render(Graphics g)
    {
        for (int i = 0; i < GRID_SIZE; i++)
        {
            for (int j = 0; j < GRID_SIZE; j++)
            {
                cells[i][j].render(g);
            }
        }
        for (Animal a: animals)
        {
            a.render(g);
        }
    }

    public void update()
    {
        for (int i = 0; i < GRID_SIZE; i++)
        {
            for (int j = 0; j < GRID_SIZE; j++)
            {
                cells[i][j].update(Mouse.getX(), Main.getScreenHeight() - Mouse.getY());
            }
        }
        for (Building b: buildings) {
            b.update();
        }
        for (Animal a: animals)
        {
            a.update();
        }
    }

    //ACCESSOR
    public static int getGridWidth(){ return gridWidth;}
    public boolean mouseHasBuilding(){ return !(mouseBuilding == null);}

    //MUTATOR
    public static void setGridWidth()
    {
        gridWidth = (int) (Main.getScreenWidth() * (float)1080/1920) ;
    }
    public void addBuilding(Building b){
        //only adds a new building if the current one is placed;
        if (!mouseHasBuilding())
        {
            buildings.add(b);
            mouseBuilding = b;
        }
        }
    public void mousePressed(int x, int y)
    {
        if (mouseBuilding != null)
        {
            for (int i = 0; i < GRID_SIZE; i++)
            {
                for (int j = 0; j < GRID_SIZE; j++)
                {
                    if (cells[i][j].mouseOver(x,y) && !cells[i][j].hasBuilding())
                    {
                        mouseBuilding.assignCell(cells[i][j]);
                        mouseBuilding = null;
                        gc.setDefaultMouseCursor();

                    }
                }
            }
        }
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }
}
