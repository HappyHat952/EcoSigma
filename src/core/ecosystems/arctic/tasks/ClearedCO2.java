package core.ecosystems.arctic.tasks;

import core.ecosystems.arctic.Arctic;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.general.Building;
import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;


public class ClearedCO2 extends Task {

    private static int totalClouds;
    private int cloudsDone;

    public ClearedCO2(String name, Grid grid) {
        super(name, grid);
//        totalClouds = arctic.getClouds().size();
        totalClouds = 10;
        cloudsDone = 0;
    }


    @Override
    public int getPercentDone() {
        return (int) ((cloudsDone/(float) totalClouds) * 100);
    }

    public void update() {

        int count = 0;
        for (Building b: grid.getBuildings()) {
            if (b instanceof CO2Sucker) {
                if (((CO2Sucker) b).isCompleted()) {
                    count++;
                    ((CO2Sucker) b).setCompleted(false);
                    if (!Arctic.getClouds().isEmpty()) {
                        Arctic.getClouds().removeLast();
                    }
                }
            }
        }
        if (cloudsDone + count <= 10) {
            cloudsDone += count;
        }
    }

    public static int getTotalClouds() {
        return totalClouds;
    }

}
