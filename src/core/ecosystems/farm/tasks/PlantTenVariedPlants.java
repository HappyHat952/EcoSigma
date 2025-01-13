package core.ecosystems.farm.tasks;

import core.ecosystems.Grid;
import core.ecosystems.farm.FarmGrid;
import core.ecosystems.tasks.Task;

public class PlantTenVariedPlants extends Task {
    public PlantTenVariedPlants(String name, Grid grid) {
        super(name, grid);
        moneyValue = 300;
    }

    @Override
    public int getPercentDone() {
        int num = ((FarmGrid)(grid)).getNumAllTimePluro();
        if (num<= 10)
        {
            return (int)(num*1f/10* 100);
        }
        else {
            return 100;
        }
    }

    @Override
    public void update() {

    }
}
