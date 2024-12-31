package core.ecosystems.farm.animals;

import core.ecosystems.general.Cell;
import core.ecosystems.general.Plant;

public class Crop extends Plant {
    int price;
    public Crop(Cell cell) {
        super(cell);
        price = 10;
    }

    public void setGrowTime(int newGrowTime)
    {
        growTime = newGrowTime;
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
