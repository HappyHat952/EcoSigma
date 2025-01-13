package core.ecosystems.rainforest.tasks;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.coralreef.buildings.Coral;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.ecosystems.rainforest.RainForest;
import core.ecosystems.rainforest.buildings.Ranger;
import core.ecosystems.tasks.Task;

public class HireRangers extends Task {

    private final int TOTAL_RANGERS = 3;
    private int rangers;
    public HireRangers(String name, Grid grid) {
        super(name, grid);
    }

    @Override
    public int getPercentDone() {
        int percent = (int) ((rangers/(float) TOTAL_RANGERS) * 100);
        if (rangers >= TOTAL_RANGERS) {
            return 100;
        } else {
            return percent;
        }

    }

    @Override
    public void update() {
        int count = 0;
        for (Building b: grid.getBuildings()) {
            if (b instanceof Ranger) {
                count++;
            }
        }
        if (count != rangers) {
            rangers = count;
            String danger = ((RainForest) Game.getCurrentLevel()).getDanger();
            if (danger.equals("High")){
                ((RainForest) Game.getCurrentLevel()).setDanger("Medium");
            } else if (danger.equals("Medium")) {
                ((RainForest) Game.getCurrentLevel()).setDanger("Low");
            } else if (danger.equals("Low")) {
                ((RainForest) Game.getCurrentLevel()).setDanger("None");
            }
        }

    }
}
