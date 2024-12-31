package core.ecosystems.farm.tasks;

import core.ecosystems.Grid;
import core.ecosystems.farm.FarmGrid;
import core.ecosystems.tasks.Task;

public class RemoveMonocultures extends Task {
    public RemoveMonocultures(String name, Grid grid) {
        super(name, grid);
    }

    @Override
    public int getPercentDone() {

        if (((FarmGrid)grid).getNumRemovedMono()<=20)
        {
            return (int)((float)( ((FarmGrid)grid) .getNumRemovedMono() )/20 * 100);
        }
        else {
            return 100;
        }
    }

    @Override
    public void update() {

    }
}
