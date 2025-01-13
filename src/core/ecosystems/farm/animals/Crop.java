package core.ecosystems.farm.animals;

import core.ecosystems.Grid;
import core.ecosystems.farm.FarmCell;
import core.ecosystems.general.Cell;
import core.ecosystems.general.Plant;

public class Crop extends Plant {
    int price;
    boolean hasBeenWatered;
    public Crop(Cell cell) {
        super(cell);
        price = 10;
    }

    public void setGrowTime(int newGrowTime)
    {
        growTime = newGrowTime;
    }

    public void update(Grid grid)
    {
        super.update( grid);
        FarmCell fcell = (FarmCell)cell;
        if (fcell.isWatered() && !hasBeenWatered)
        {
            //growTime = (int)( (float)growTime * .5f);
            growTime = 1;
            hasBeenWatered = true;
        }
    }


    public void click(int x, int y, int button)
    {
        if (mouseOver(x, y) && isMature())
        {
            cell.removePlant();

        }
    }

    public int getPrice(){ return price;}
}
