package core.ecosystems.arctic.tasks;

import core.ecosystems.arctic.ArcticCell;
import core.ecosystems.arctic.buildings.OilDrill;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.general.Building;
import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;

public class DestroyedOilDrills extends Task {

    final private int totalOilDrills = 3;

    public DestroyedOilDrills(String name, Grid grid) {
        super(name, grid);
    }


    @Override
    public int getPercentDone() {
        int count = 0;
        for (int i = 0; i < grid.getCells().length; i++) {
            for (int j = 0; j < grid.getCells()[0].length; j++) {
                if (grid.getCells()[i][j].getBuilding() instanceof OilDrill) {
                    count++;
                }
            }
        }
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
