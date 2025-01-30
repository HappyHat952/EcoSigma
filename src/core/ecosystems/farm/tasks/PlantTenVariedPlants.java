package core.ecosystems.farm.tasks;

import core.ecosystems.Grid;
import core.ecosystems.farm.FarmGrid;
import core.ecosystems.farm.animals.PluroCultureCrop;
import core.ecosystems.general.Plant;
import core.ecosystems.tasks.Task;

public class PlantTenVariedPlants extends Task {

    boolean DONE;
    public PlantTenVariedPlants(String name, Grid grid) {
        super(name, grid);
        moneyValue = 350;
    }

    @Override
    public int getPercentDone() {
        int num = 0;
        FarmGrid fgrid = (FarmGrid)grid;
        for (Plant p: fgrid.getPlants())
        {
            if (p instanceof PluroCultureCrop)
            {
                num++;
            }
        }
        if (num ==60)
        {
            DONE = true;
        }

        if (num<= 60 && !DONE)
        {
            return (int)((float)num/60* 100);
        }
        else if (DONE)
        {
            return 100;
        }
        else {
            return 100;
        }

    }

    @Override
    public void update() {

    }
}
