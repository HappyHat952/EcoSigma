package core.ecosystems.Arctic.tasks;

import core.ecosystems.Arctic.Arctic;
import core.ecosystems.Arctic.buildings.CO2Sucker;
import core.ecosystems.Arctic.buildings.OilDrill;
import core.ecosystems.Arctic.buildings.Protesters;
import core.ecosystems.Building;
import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;

public class DestroyedOilDrills extends Task {

    private int totalOilDrills = 3;

    public DestroyedOilDrills(String name, Grid grid) {
        super(name, grid);
    }


    @Override
    public int getPercentDone() {
        int count = 0;
        for (Building b: grid.getBuildings()) {
            if (b instanceof OilDrill) {
                count++;
            }
        }
        System.out.println("Oil Drills: " + count + "/" + totalOilDrills);
        System.out.println((int) (((totalOilDrills-count)/(float)totalOilDrills) * 100));
        return (int) (((totalOilDrills-count)/(float)totalOilDrills) * 100);
    }

    @Override
    public void update() {
        for (Building b: grid.getBuildings()) {
            if (b instanceof Protesters) {
                if (((Protesters) b).isCompleted()) {
                    for (int i = 0; i < grid.getBuildings().size(); i++) {
                        if (grid.getBuildings().get(i).equals(((Protesters) b).getOilDrill())){
                            OilDrill oilDrill = ((Protesters) b).getOilDrill();
                            grid.getCells()[oilDrill.getMyRow()][oilDrill.getMyCol()].removeBuilding();
                            grid.getBuildings().remove(i);
                            return;
                        }
                    }
                    ((Protesters) b).setCompleted(false);
                }
            }
        }
    }
}
