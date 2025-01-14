package core.ecosystems.rainforest.tasks;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.arctic.buildings.OilDrill;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.general.Building;
import core.ecosystems.rainforest.buildings.Fire;
import core.ecosystems.rainforest.buildings.FireDrone;
import core.ecosystems.tasks.Task;

import static core.ecosystems.Grid.GRID_SIZE;

public class ExtinguishFires extends Task {
    final private int TOTAL_FIRES = 2;
    private int fires;
    public ExtinguishFires(String name, Grid grid) {
        super(name, grid);
        fires = TOTAL_FIRES;
        moneyValue = 80;
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

        for (int i = 0; i < GRID_SIZE; i++)
        {
            for (int j = 0; j < GRID_SIZE; j++)
            {
                Building b = Game.getCurrentLevel().getGrid().getCells()[i][j].getBuilding();
                if (b instanceof FireDrone) {
                        for (int a = 0; a < grid.getBuildings().size(); a++) {
                            if (grid.getBuildings().get(a).equals(((FireDrone) b).getFire())){
                                Fire fire = ((FireDrone) b).getFire();
                                grid.getCells()[fire.getMyCol()][fire.getMyRow()].removeBuilding();
                                grid.getBuildings().remove(a);
                                return;
                            }
                        }

                }
            }
        }
    }
    }
