package core.ecosystems.rainforest.tasks;

import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;

public class HireRangers extends Task {
    public HireRangers(String name, Grid grid) {
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
