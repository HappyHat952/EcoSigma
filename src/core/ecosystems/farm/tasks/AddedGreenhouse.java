package core.ecosystems.farm.tasks;

import core.ecosystems.Grid;
import core.ecosystems.farm.FarmGrid;
import core.ecosystems.tasks.Task;

public class AddedGreenhouse extends Task {
    public AddedGreenhouse(String name, Grid grid) {
        super(name, grid);
    }

    @Override
    public int getPercentDone() {
        return (int) ( (float)((((FarmGrid)grid).getNumGreenHouses())) /(4f) * 100) ;
    }

    @Override
    public void update() {

    }
}
