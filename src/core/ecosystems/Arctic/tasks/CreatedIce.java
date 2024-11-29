package core.ecosystems.Arctic.tasks;

import core.ecosystems.Arctic.Arctic;
import core.ecosystems.Arctic.buildings.CO2Sucker;
import core.ecosystems.Arctic.buildings.IcePump;
import core.ecosystems.Building;
import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;

public class CreatedIce extends Task {

    private int iceCreated;
    private int totalIce;
    public CreatedIce(String name, Grid grid) {
        super(name, grid);
        iceCreated = 0;
        totalIce = 30;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }


    @Override
    public int getPercentDone() {
        return (int) ((iceCreated/(float) totalIce) * 100);
    }

    public void update() {
        for (Building b: grid.getBuildings()) {
            if (b instanceof IcePump) {
                if (((IcePump) b).isCompleted()) {
                    iceCreated += ((IcePump) b).getIceCreated();
                    ((IcePump) b).setCompleted(false);
                }
            }
        }

    }

}
