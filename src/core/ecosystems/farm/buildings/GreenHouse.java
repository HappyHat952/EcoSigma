package core.ecosystems.farm.buildings;

import core.ecosystems.Grid;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class GreenHouse extends Building {
    public GreenHouse()
    {
        super();
        myImage = Images.greenHouse;
        cost = 75;
    }

    public boolean isOver(Cell c)
    {
        if (cells != null)
        {
            for (Cell c1: cells)
            {
                if (c1 == c)
                {
                    return true;
                }
            }
        }

        return false;
    }
}