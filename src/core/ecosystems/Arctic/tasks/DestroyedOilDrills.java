package core.ecosystems.Arctic.tasks;

import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;

public class DestroyedOilDrills extends Task {


    public DestroyedOilDrills(String name, Grid grid) {
        super(name, grid);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public int getPercentDone() {
        return 0;
    }

    @Override
    public void update() {

    }
}
