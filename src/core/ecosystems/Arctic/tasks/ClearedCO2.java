package core.ecosystems.Arctic.tasks;

import core.ecosystems.Arctic.Arctic;
import core.ecosystems.Arctic.ArcticGrid;
import core.ecosystems.Arctic.Cloud;
import core.ecosystems.Building;
import core.ecosystems.tasks.Task;

import java.util.ArrayList;


public class ClearedCO2 extends Task {

    private static int totalClouds;
    private int cloudsDone;

    public ClearedCO2(String name) {
        super(name);
//        totalClouds = Arctic.getClouds().size();
        totalClouds = 10;
        cloudsDone = 0;
    }

    @Override
    public boolean isComplete() {
        if (cloudsDone == totalClouds) {
            return true;
        }
        return false;
    }

    @Override
    public int getPercentDone() {
        return (int) ((cloudsDone/(float) totalClouds) * 100);
    }

    public void update() {

        int count = 0;
//        for (Cloud c: Arctic.getClouds()) {
//            if (c.isDeleted()) {
//                count++;
//            }
//
//        }
//        cloudsDone = count;

        for (Building b: ArcticGrid.getBuildings()) {
            if (b.isCompleted()) {
                count++;
                b.setCompleted(false);
            }
        }
        cloudsDone += count;
    }

    public static int getTotalClouds() {
        return totalClouds;
    }

}
