package core.ecosystems;

import core.Main;

import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.general.*;
import core.ecosystems.rainforest.buildings.Ranger;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Grid {
    protected final static int GRID_SIZE = 10; // number of squares in horizontal and vertical
    protected static int gridWidth; //size of the grid relative to 1920 x 1080
    protected Cell[][] cells;

    protected Building mouseBuilding;//a building that is purchased (only one)
    protected Organism mouseOrganism; // an organism stored on the mouse;

    protected ArrayList<Building> buildings;
    protected ArrayList<Animal> animals;
    protected ArrayList<Plant> plants;
    protected GameContainer gc;
    protected StateBasedGame sbg;
    protected Shop shop;

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
        plants = new ArrayList<>();

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
        for (Plant p: plants)
        {
            p.render(g);
        }
        for (Building b: buildings)
        {
            if (b.getCells() != null)
            {
                b.render(g);
            }

        }
    }

    public void update()
    {
        for (int i = 0; i < GRID_SIZE; i++)
        {
            for (int j = 0; j < GRID_SIZE; j++)
            {
                cells[i][j].update(Mouse.getX(), Main.getScreenHeight() - Mouse.getY());
                if (cells[i][j].hasBuilding() && !(cells[i][j].getBuilding() instanceof Ranger)){
                    cells[i][j].getBuilding().update();
                }
            }
        }
        for (Building b: buildings) {
            if (b instanceof Ranger) {
                b.update();
            }

        }
        for (Animal a: animals)
        {
            a.update(this);
//            if (True)
//            {
//                addAnimal(a.getClass());
//            }
        }
        for (Plant p: plants)
        {
            p.update(this);

        }
        if (!animals.isEmpty()&& Math.random()<.0001)
        {
            addAnimal(animals.get((int)(animals.size()*Math.random())).getClass());
        }
        if (!plants.isEmpty()&& Math.random()<.0001)
        {
            addPlant(plants.get((int)(plants.size()*Math.random())).getClass());
        }
    }

    //ACCESSOR

    public Cell[][] getCells() {
        return cells;
    }
    public ArrayList<Animal> getAnimals(){ return animals;}
    public ArrayList<Plant> getPlants(){ return plants;}
    public static int getGridWidth(){ return gridWidth;}
    public boolean mouseHasBuilding(){ return !(mouseBuilding == null);}
    public boolean mouseHasOrganism(){ return !(mouseOrganism == null);}
    public ArrayList<Cell> getOpenAdjacentCells(int r, int c)
    {
        //adds all available cells (checking boundaries)
        ArrayList<Cell> cellList = new ArrayList<>();
        if (r>0){           cellList.add(cells[r-1][c]);}
        if (c>0){           cellList.add(cells[r][c-1]);}
        if (r<GRID_SIZE-1){ cellList.add(cells[r+1][c]);}
        if (c<GRID_SIZE-1){ cellList.add(cells[r][c+1]);}

        //removes any cells that have a building on it
        for (int i= 0; i< cellList.size(); i++)
        {
            if(!isAvailable(cellList.get(i)))
            {
                cellList.remove(i);
                i--;
            }
        }

        return cellList;
    }

    public ArrayList<Cell> getAllOpenCells()
    {
        ArrayList<Cell> cellList = new ArrayList<>();

        //adds all cells in cells to cellList
        for (int i=0; i<cells.length; i++)
        {
            for (int j=0; j<cells[0].length; j++)
            {
                if (isAvailable(cells[i][j]))
                {
                    cellList.add(cells[i][j]);
                }
            }
        }
        return cellList;
    }

    public boolean isAvailable(Cell cell)
    {
        return (!cell.hasBuilding() && !cell.hasAnimal() && !cell.hasPlant());
    }

    //MUTATOR
    public static void setGridWidth()
    {
        gridWidth = (int) (Main.getScreenWidth() * (float)1080/1920) ;
    }
//    public void addMouseBuilding(Building b){
//        //only adds a new building if the current one is placed;
//        if (!mouseHasBuilding())
//        {
//            mouseBuilding = b;
//        }
//        }
    public void mousePressed(int x, int y, int button)
    {
        if (mouseBuilding != null)
        {
            for (int i = 0; i < GRID_SIZE; i++)
            {
                for (int j = 0; j < GRID_SIZE; j++)
                {
                    if (cells[i][j].mouseOver(x,y) && !cells[i][j].hasBuilding())
                    {
                        mouseBuilding.assignCell(cells[i][j], this);
                        addBuilding(mouseBuilding);
                        mouseBuilding = null;
                        gc.setDefaultMouseCursor();

                    }
                }
            }
        } else {
            mousePressedNoBuilding( x,  y, button);
            //Does this ONLY if there is no building
        }
    }

    public void mousePressedNoBuilding(int x, int y, int button)
    {
        for(Building b: buildings)
        {
            b.click(x,y,button);
        }

    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public static int getGridSize() {
        return GRID_SIZE;
    }

    public void addShop(Shop shop)
    {
        this.shop = shop;
    }

    public void addOrganism(Class<? extends Organism> clazz) {
        if (!getAllOpenCells().isEmpty())
        {
            ArrayList<Cell> cellList = getAllOpenCells();
            Cell cell = cellList.get((int)(Math.random()*cellList.size()));
            try {
                Constructor constructor = clazz.getDeclaredConstructor(Cell.class);
                Organism organism = clazz.getDeclaredConstructor(Cell.class).newInstance(cell);
                if (organism instanceof Animal)
                {
                    animals.add((Animal) organism);
                }
                if (organism instanceof Plant)
                {
                    plants.add((Plant) organism);
                }


            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }


        //animals.add(new Animal(cell));
    }

    public void addAnimal(Class<? extends Animal> animal) {
        if (!getAllOpenCells().isEmpty())
        {
            ArrayList<Cell> cellList = getAllOpenCells();
            Cell cell = cellList.get((int)(Math.random()*cellList.size()));
            try {
                Constructor constructor = animal.getDeclaredConstructor(Cell.class);
                animals.add(animal.getDeclaredConstructor(Cell.class).newInstance(cell));
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }


        //animals.add(new Animal(cell));
    }

    public void addAnimal(Class<? extends Animal> animal, Cell cell) {
        if (!getAllOpenCells().isEmpty())
        {
            ArrayList<Cell> cellList = getAllOpenCells();
            try {
                Constructor constructor = animal.getDeclaredConstructor(Cell.class);
                animals.add(animal.getDeclaredConstructor(Cell.class).newInstance(cell));
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }


        //animals.add(new Animal(cell));
    }

    public void addPlant(Class<? extends Plant> plant) {
        if (!getAllOpenCells().isEmpty()) {
            ArrayList<Cell> cellList = getAllOpenCells();
            Cell cell = cellList.get((int) (Math.random() * cellList.size()));
            try {
                Constructor constructor = plant.getDeclaredConstructor(Cell.class);
                plants.add(plant.getDeclaredConstructor(Cell.class).newInstance(cell));
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        //animals.add(new Animal(cell));
    }
    public void addPlant(Class<? extends Plant> plant, Cell cell) {
        if (!getAllOpenCells().isEmpty()) {
            try {
                Constructor constructor = plant.getDeclaredConstructor(Cell.class);
                plants.add(plant.getDeclaredConstructor(Cell.class).newInstance(cell));
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        //animals.add(new Animal(cell));
    }

    //add building using this
    public void addBuilding(Building building)
    {
        int row = building.getMyRow();

        if (buildings.isEmpty())
        {
            buildings.add(building);
        }
        else {
            int i = 0;
            while (i<=buildings.size() && !buildings.contains(building))
            {
                if (i == buildings.size())
                {
                    buildings.add(building);
                }
                if (row <= buildings.get(i).getMyRow())
                {
                    buildings.add(i, building);
                }
               // System.out.println(""+row+"<=" +buildings.get(i).getMyRow()+": "+(row <= buildings.get(i).getMyRow()));
                i++;
            }

        }
//        for (Building b: buildings)
//        {
//            System.out.print(b.getMyRow() +", ");
//        }

    }

    public void addMouseBuilding(Class<? extends Building> building) {
        ArrayList<Cell> cellList = getAllOpenCells();
        Cell cell = cellList.get((int)(Math.random()*cellList.size()));
        try {
            Constructor constructor = building.getDeclaredConstructor();
            Building newBuilding = building.getDeclaredConstructor().newInstance();
            //buildings.add(newBuilding);

            if (!mouseHasBuilding() && !mouseHasOrganism())
            {
                mouseBuilding = newBuilding;
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        //animals.add(new Animal(cell));
    }
    public void addMouseOrganism(Class<? extends Organism> organism) {
        ArrayList<Cell> cellList = getAllOpenCells();
        Cell cell = cellList.get((int)(Math.random()*cellList.size()));
        try {
            Constructor constructor = organism.getDeclaredConstructor();
            Organism newOrganism = organism.getDeclaredConstructor(Cell.class).newInstance();
            //buildings.add(newBuilding);

            if (!mouseHasBuilding() && !mouseHasOrganism() )
            {
                mouseOrganism = newOrganism;
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        //animals.add(new Animal(cell));
    }
}
