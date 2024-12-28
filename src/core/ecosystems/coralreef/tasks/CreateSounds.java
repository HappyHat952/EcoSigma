package core.ecosystems.coralreef.tasks;

import core.ecosystems.Grid;
import core.ecosystems.arctic.Arctic;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.coralreef.buildings.SoundMaker;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.ecosystems.tasks.Task;

public class CreateSounds extends Task {

    private int soundMakers;
    final private int totalSoundMakers = 3;

    public CreateSounds(String name, Grid grid) {
        super(name, grid);
        soundMakers = 0;
    }

    public int getPercentDone() {
        int percent = (int) ((soundMakers/(float) totalSoundMakers) * 100);
        if (soundMakers >= totalSoundMakers) {
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

                if (cell.hasBuilding() && cell.getBuilding() instanceof SoundMaker) {
                    count++;
                }
            }
        }
        soundMakers = count;
    }



}
