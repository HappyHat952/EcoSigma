package core.ecosystems.coralreef.tasks;

import core.ecosystems.Grid;
import core.ecosystems.arctic.Arctic;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.coralreef.buildings.Coral;
import core.ecosystems.coralreef.buildings.SoundMaker;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.ecosystems.tasks.Task;

public class CreateCoral extends Task {

    final private int totalCoral = 15;
    private int healthyCoral = 0;
    public CreateCoral(String name, Grid grid) {
        super(name, grid);
    }

    public int getPercentDone() {
        int percent = (int) ((healthyCoral/(float) totalCoral) * 100);
        if (healthyCoral >= totalCoral) {
            return 100;
        } else {
            return percent;
        }
    }

    public void update() {
        int count = 0;
        for (int r = 0; r < grid.getCells().length; r++) {
            for (int c = 0; c < grid.getCells()[r].length; c++) {
                Cell cell = grid.getCells()[r][c];

                if (cell.hasBuilding() && cell.getBuilding() instanceof Coral && ((Coral) cell.getBuilding()).isHealthy()) {
                    count++;
                }
            }
        }
        healthyCoral = count;
    }



}
