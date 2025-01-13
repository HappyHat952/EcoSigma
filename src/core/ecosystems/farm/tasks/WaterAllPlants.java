package core.ecosystems.farm.tasks;

import core.ecosystems.Grid;
import core.ecosystems.farm.FarmCell;
import core.ecosystems.farm.FarmGrid;
import core.ecosystems.general.Cell;
import core.ecosystems.tasks.Task;

public class WaterAllPlants extends Task {
    public WaterAllPlants(String name, Grid grid) {
        super(name, grid);
        moneyValue = 200;
    }

    @Override
    public int getPercentDone() {
        int waterCount = 0;
        for (Cell[] cells: ((FarmGrid)grid).getCells())
        {
            for (Cell c: cells)
            {
                if (((FarmCell)c).isWatered())
                {
                    waterCount++;
                }
            }
        }
        return waterCount;
    }

    @Override
    public void update() {

    }
}
