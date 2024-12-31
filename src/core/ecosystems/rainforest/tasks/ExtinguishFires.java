package core.ecosystems.rainforest.tasks;

import core.ecosystems.Grid;
import core.ecosystems.arctic.buildings.OilDrill;
import core.ecosystems.general.Building;
import core.ecosystems.rainforest.buildings.Fire;
import core.ecosystems.tasks.Task;

public class ExtinguishFires extends Task {
    final private int TOTAL_FIRES = 3;
    private int fires;
    public ExtinguishFires(String name, Grid grid) {
        super(name, grid);
        fires = TOTAL_FIRES;
    }

    @Override
    public int getPercentDone() {
        return (int) (((TOTAL_FIRES - fires)/(float)TOTAL_FIRES) * 100);
    }

    @Override
    public void update() {
       int count = 0;
        for (int i = 0; i < grid.getCells().length; i++) {
            for (int j = 0; j < grid.getCells()[0].length; j++) {
                if (grid.getCells()[i][j].getBuilding() instanceof Fire) {
                    count++;
                }
            }
        }
        fires = count;
    }
}
