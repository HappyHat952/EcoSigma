package core.ecosystems.farm.tasks;

import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;

public class WaterAllPlants extends Task {
    public WaterAllPlants(String name, Grid grid) {
        super(name, grid);
    }

    @Override
    public int getPercentDone() {
        return 0;
    }

    @Override
    public void update() {

    }
}
