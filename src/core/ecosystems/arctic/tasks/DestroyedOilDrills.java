package core.ecosystems.arctic.tasks;

import core.Game;
import core.ecosystems.arctic.ArcticCell;
import core.ecosystems.arctic.buildings.OilDrill;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.general.Building;
import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;

public class DestroyedOilDrills extends Task {

    final private int totalOilDrills = 2;

    public DestroyedOilDrills(String name, Grid grid) {
        super(name, grid);
        moneyValue = 130;
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
        // hello
        for (int j = 0; j< grid.getBuildings().size(); j++) {
            Building b = grid.getBuildings().get(j);
            if (b instanceof Protesters) {
                if (((Protesters) b).isCompleted()) {
                    for (int i = 0; i < grid.getBuildings().size(); i++) {
                        if (grid.getBuildings().get(i).equals(((Protesters) b).getOilDrill())){
                            OilDrill oilDrill = ((Protesters) b).getOilDrill();
                            grid.getCells()[oilDrill.getMyRow()][oilDrill.getMyCol()].removeBuilding();
                            grid.getBuildings().remove(oilDrill);
                            i--;
                        }
                    }
                    ((Protesters) b).setCompleted(false);
                }
            }
        }
//        for (int i = 0; i < grid.getCells().length; i++) {
//            for (int j = 0; j < grid.getCells()[0].length; j++) {
//                Building b = grid.getCells()[i][j].getBuilding();
//                if (b instanceof Protesters) {
//                    if (((Protesters) b).isCompleted()) {
//                        for (int k = 0; k < grid.getCells().length; k++) {
//                            for (int l = 0; l < grid.getCells()[0].length; l++) {
//                                Building c = grid.getCells()[k][l].getBuilding();
//
//                                if (c != null) {
//                                    if (c.equals(((Protesters) b).getOilDrill())) {
//                                        OilDrill oilDrill = ((Protesters) b).getOilDrill();
//                                        grid.getCells()[oilDrill.getMyRow()][oilDrill.getMyCol()].removeBuilding();
//                                        grid.getCells()[c.getMyRow()][c.getMyCol()].removeBuilding();
//                                    }
//                                }
//                            }
//                        }
//                        ((Protesters) b).setCompleted(false);
//                    }
//                }
//            }
//        }

    }
}
