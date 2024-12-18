package core.ecosystems.farm;

import core.ecosystems.Grid;
import core.ecosystems.arctic.ArcticCell;
import org.newdawn.slick.GameContainer;

public class FarmGrid extends Grid {
    public FarmGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new FarmCell(i, j);
            }
        }
    }
}
