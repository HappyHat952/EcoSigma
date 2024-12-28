package core.ecosystems.rainforest.tasks;

import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;

public class ExtinguishFires extends Task {
    public ExtinguishFires(String name, Grid grid) {
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
