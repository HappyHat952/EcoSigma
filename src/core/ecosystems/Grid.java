package core.ecosystems;

import core.Main;

import core.ecosystems.general.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Grid {
    public final static int GRID_SIZE = 10; // number of squares in horizontal and vertical
    protected static int gridWidth; //size of the grid relative to 1920 x 1080
    protected Cell[][] cells;

    protected Building mouseBuilding;//a building that is purchased (only one)
    protected Organism mouseOrganism; // an organism stored on the mouse;
    protected OrganismItem mouseOrganismItem;

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
                cells[i][j].renderBuildingOrPlant(g);
            }
        }
        for (Animal a: animals)
        {
            a.render(g);
        }
//        for (Plant p: plants)
//        {
//            p.render(g);
//        }
        for (Building b: buildings)
        {
            if (b.getCells() != null && b.isMoving())
            {
                b.render(g);
            }

        }
    }

    public void update()
    {
        for (Building b: buildings) {
                b.update();
        }
        for (Animal a: animals)
        {
            a.update(this);
        }
        for (Plant p: plants)
        {
            p.update(this);

        }

        //will randomly add a new animal to the scene
//        if (!animals.isEmpty()&& Math.random()<.0001)
//        {
//            addAnimal(animals.get((int)(animals.size()*Math.random())).getClass());
//        }
//        if (!plants.isEmpty()&& Math.random()<.0001)
//        {
//            addPlant(plants.get((int)(plants.size()*Math.random())).getClass());
//        }
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
    public boolean  mouseHasOrganismItem(){ return !(mouseOrganismItem == null);}

    public boolean isMouseOrganismItem(OrganismItem oi){ return oi == mouseOrganismItem;}
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

    public void mousePressed(int x, int y, int button) {

        //adds a building if the mouse has a building;
        if (mouseHasBuilding()) {
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (cells[i][j].mouseOver(x, y) && !cells[i][j].hasBuilding() && !cells[i][j].hasAnimal() && !cells[i][j].hasPlant()) {
                        mouseBuilding.assignCell(cells[i][j], this);
                        addBuilding(mouseBuilding);
                        mouseBuilding = null;
                        gc.setDefaultMouseCursor();

                    }
                }
            }
        }

        //adds an organism if the mouse contains an organism
        else if (mouseHasOrganism()) {
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (cells[i][j].mouseOver(x, y) && !cells[i][j].hasBuilding() && !cells[i][j].hasAnimal() && !cells[i][j].hasPlant()) {
                        addOrganism(mouseOrganism.getClass(), cells[i][j]);
                        mouseOrganism = null;
                        gc.setDefaultMouseCursor();
                        //adds the new organism to the list so that it will be rendered
                        if (mouseOrganism instanceof Animal) {
                            animals.add((Animal) mouseOrganism);
                        }
                        if (mouseOrganism instanceof Plant) {
                            plants.add((Plant) mouseOrganism);
                        }

                    }
                }
            }
        } else if (mouseHasOrganismItem())
        {
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (cells[i][j].mouseOver(x, y) && !cells[i][j].hasBuilding() && !cells[i][j].hasAnimal() && !cells[i][j].hasPlant()) {
                        if (mouseOrganismItem.hasOrganisms())
                        {
                            Organism organism = addOrganism(mouseOrganismItem.getOrganismClass(), cells[i][j]);
                            //adds the new organism to the list so that it will be rendered
                            if (organism != null && organism instanceof Animal) {
                                animals.add((Animal) organism);
                            }
                            if (organism != null && organism instanceof Plant) {
                                plants.add((Plant) organism);
                            }
                            mouseOrganismItem.removeOneOrganism();
                        }
                        else {
                            removeMouseOrganismItem();
                        }


                    }
                }
            }
        }
        else {
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
                if (organism instanceof Plant )
                {
                    plants.add((Plant) organism);
                }

            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        //animals.add(new Animal(cell));
    }

    public Organism addOrganism(Class<? extends Organism> clazz, Cell cell) {
        if (!getAllOpenCells().isEmpty())
        {
            try {
                Constructor constructor = clazz.getDeclaredConstructor(Cell.class);
                Organism organism = clazz.getDeclaredConstructor(Cell.class).newInstance(cell);
                if (organism instanceof Animal)
                {
                    animals.add((Animal) organism);
                }
                if (organism instanceof Plant && ((Plant)organism). isValid(cell))
                {
                    for (int i = 0; i<plants.size(); i ++)
                    {
                        if (cell.getY()<= plants.get(i).getCell().getY())
                        {
                            plants.add(i, (Plant) organism);
                            i = plants.size();
                        }
                    }
                    //plants.add((Plant) organism);
                }
                else {
                    cell.removePlant();
                }
                return organism;


            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }
        //animals.add(new Animal(cell));
        return null;
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

            if (!mouseHasBuilding() && !mouseHasOrganism()  && !mouseHasOrganismItem())
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
        //Cell cell = cellList.get((int)(Math.random()*cellList.size()));
        Cell cell = new Cell(40,50);
        try {
            Organism newOrganism = organism.getDeclaredConstructor(Cell.class).newInstance(cell);

            if (!mouseHasBuilding() && !mouseHasOrganism()  && !mouseHasOrganismItem())
            {
                mouseOrganism = newOrganism;
                gc.setMouseCursor(newOrganism.getImage().getScaledCopy(50,50),25,25 );
            }
        } catch (SlickException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        //animals.add(new Animal(cell));
    }
    public void addMouseOrganismItem(OrganismItem oi) {
        ArrayList<Cell> cellList = getAllOpenCells();
        //Cell cell = cellList.get((int)(Math.random()*cellList.size()));
        Cell cell = new Cell(40,50);
        mouseOrganismItem = oi;
        try {

            Organism newOrganism = oi.getOrganismClass().getDeclaredConstructor(Cell.class).newInstance(cell);

            if (!mouseHasBuilding() && !mouseHasOrganism() )
            {
                gc.setMouseCursor(newOrganism.getImage().getScaledCopy(50,50),25,25 );
            }
        } catch (SlickException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        //animals.add(new Animal(cell));
    }
    public void removeMouseOrganismItem() {
      mouseOrganismItem = null;
      gc.setDefaultMouseCursor();

    }
}
