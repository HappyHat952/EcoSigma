package core.ecosystems.Arctic.tasks;

import core.ecosystems.Arctic.Arctic;
import core.ecosystems.Arctic.buildings.CO2Sucker;
import core.ecosystems.Arctic.buildings.IcePump;
import core.ecosystems.Building;
import core.ecosystems.Cell;
import core.ecosystems.Game;
import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;
import org.newdawn.slick.Color;

public class CreatedIce extends Task {

    private int iceCreated;
    private int totalIce;
    public CreatedIce(String name, Grid grid) {
        super(name, grid);
        iceCreated = 0;
        totalIce = 30;
    }



    @Override
    public int getPercentDone() {
        if (iceCreated <= 30) {
            return (int) ((iceCreated / (float) totalIce) * 100);
        } else {
            return 100;
        }
    }

    public void update() {
                    // LOOP HERE
                    int count = 0;
                    Cell[][] cells = grid.getCells();
                    for (int r = 0; r < cells.length; r++) {
                        for (int c = 0; c < cells[r].length; c++) {
                            if (cells[r][c].getColor().equals(Color.white)) {
                                count++;
                            }
                        }
                    }
                    iceCreated = count;
    }

}
