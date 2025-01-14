package core.ecosystems.rainforest.tasks;

import core.ecosystems.Grid;
import core.ecosystems.coralreef.buildings.SoundMaker;
import core.ecosystems.general.Cell;
import core.ecosystems.rainforest.RainForestCell;
import core.ecosystems.tasks.Task;

public class EnrichSoil extends Task {
    private int healthySoil;
    private final int TOTAL_HEALTHY_SOIL = 27;
    public EnrichSoil(String name, Grid grid) {
        super(name, grid);
        moneyValue = 140;
    }

    @Override
    public int getPercentDone() {
        int percent = (int) ((healthySoil/(float) TOTAL_HEALTHY_SOIL) * 100);
        if (percent > 100) {
            return 100;
        } else {
            return percent;
        }
    }

    @Override
    public void update() {
        int count = 0;
        for (int r = 0; r < grid.getCells().length; r++) {
            for (int c = 0; c < grid.getCells()[r].length; c++) {
                Cell cell = grid.getCells()[r][c];
                if (((RainForestCell) cell).isHealthy()) {
                    count++;
                }
            }
        }
        healthySoil = count;
    }
}
