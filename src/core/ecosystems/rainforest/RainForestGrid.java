package core.ecosystems.rainforest;

import core.ecosystems.Grid;
import core.ecosystems.coralreef.CoralReefCell;
import core.ecosystems.coralreef.buildings.Coral;
import org.newdawn.slick.GameContainer;

public class RainForestGrid extends Grid {
    public RainForestGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new RainForestCell(i, j);
            }
        }

    }
}
