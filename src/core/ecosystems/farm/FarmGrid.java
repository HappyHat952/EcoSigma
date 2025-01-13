package core.ecosystems.farm;

import core.ecosystems.Grid;
import core.ecosystems.farm.animals.Crop;
import core.ecosystems.farm.animals.MonoCultureCrop;
import core.ecosystems.farm.animals.PluroCultureCrop;
import core.ecosystems.farm.buildings.GreenHouse;
import core.ecosystems.farm.buildings.WaterTank;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.ecosystems.general.Organism;
import core.ecosystems.general.Plant;
import core.setup.Images;
import org.newdawn.slick.GameContainer;

import java.util.ArrayList;

public class FarmGrid extends Grid {

    public ArrayList<GreenHouse> greenHouses;
    public ArrayList<MonoCultureCrop> removedCrops;
    public ArrayList<PluroCultureCrop> allTimePluroCrop;

    public FarmGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new FarmCell(j, i);
            }
        }
        greenHouses = new ArrayList<>();
        removedCrops = new ArrayList<>();
        allTimePluroCrop = new ArrayList<>();
        WaterTank w = (new WaterTank());
                w.assignCell(cells[2][2], this);
                addBuilding(w);


        for (int i = 0; i< cells.length; i++)
        {
            for (int j = 0; j< cells[0].length; j ++)
            {
                if (i==9||i==5||i==4||i==0 || j==9||j==5||j==4||j==0)
                {
                    addPlant(MonoCultureCrop.class, cells[i][j]);
                }

            }
        }


    }

    public void updateGreenHousePlants()
    {
        for (Plant p: plants)
        {
            for (GreenHouse g: greenHouses)
            {

                if (g.isOver(p.getCell()))
                {

                    if (p instanceof MonoCultureCrop)
                    {
                        Crop c = (Crop)p ;
                        c.setGrowTime(5);

                    }
                    if (p instanceof PluroCultureCrop)
                    {
                        Crop c = (Crop)p ;
                        c.setGrowTime(2);
                    }
                }
            }

        }
    }

    @Override
    public void mousePressed(int x, int y, int button ) {
        super.mousePressed(x, y, button);
        if (!buildings.isEmpty() &&buildings.getLast() instanceof GreenHouse)
        {
            updateGreenHousePlants();
        }


    }

    @Override
    public void addBuilding(Building building) {
        super.addBuilding(building);
        //assigns correct cells for greenhouses
        if (building instanceof GreenHouse)
        {

            buildings.remove(building);
            building.getCell().removeBuilding();

            int r;
            int c;
            if (building.getMyRow()<5) {
                r = 0;
            }
            else {
                r = 5;
            }
            if (building.getMyCol()<5) {
                c = 0;
            }
            else {
                c = 5;
            }
            Cell[] GHcells = new Cell[25];
            int k = 0;

            for(int i = 4 + c; i>=c; i--)
            {
                for (int j = r; j<=4+r; j++)
                {
                    GHcells[k] = cells[j][i];
                    k++;
                }
            }

            GHcells[0] = cells[r+4][c];

            //check if there is a greenhouse in a specific part of the cell
            boolean available = true;
            for (GreenHouse g: greenHouses)
            {
                if (g.getCells()[0] == GHcells[0])
                {
                    available = false;
                }
            }

            if (available)
            {
                building.assignCell(GHcells, this, 5,5,true);
                greenHouses.add((GreenHouse)building);
                buildings.add(building);
            }
            else {
                addMouseBuilding( GreenHouse.class);

            }

        }
    }

    public void mousePressedNoBuilding(int x, int y, int button)
    {
        super.mousePressedNoBuilding(x,y,button);
        for (int i = 0; i< plants.size(); i++)
        {
            Plant p = plants.get(i);
            p.click(x,y, button);
            if (p.mouseOver(x,y) && p.isMature())
            {
                Crop c = (Crop) p;
                shop.addMoney(c.getPrice());
                plants.remove(p);
                if (c instanceof MonoCultureCrop)
                {
                    removedCrops.add((MonoCultureCrop) c);
                    if (Math.random()<.3)
                    {
                        shop.addOrganism(MonoCultureCrop.class);
                    }
                }
                if (c instanceof PluroCultureCrop)
                {
                    for (int j = 1 + (int)(Math.random()*2); j>0; j--)
                    {
                        shop.addOrganism(PluroCultureCrop.class);
                    }
                }
                i--;

            }
        }
        updateGreenHousePlants();
    }

    public int getNumGreenHouses()
    {
        return greenHouses.size();
    }
    public int getNumWateredCells()
    {
        int count =0;
        for (Cell[] cs: cells)
        {
            for (Cell c: cs)
            {
                if ( ((FarmCell)c).isWatered())
                {
                    count ++;
                }
            }
        }
        return count;
    }
    public int getNumRemovedMono()
    {
        return removedCrops.size();
    }
    public int getNumAllTimePluro()
    {
        return allTimePluroCrop.size();
    }

    public void addOrganism(Class<? extends Organism> clazz)
    {
        super.addOrganism(clazz);
        if (clazz == PluroCultureCrop.class)
        {
            allTimePluroCrop.add((PluroCultureCrop) plants.getLast());
        }
    }
}
