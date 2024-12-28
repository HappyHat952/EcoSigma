package core.ecosystems.rainforest.tasks;

import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;

public class EnrichSoil extends Task {
    public EnrichSoil(String name, Grid grid) {
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
