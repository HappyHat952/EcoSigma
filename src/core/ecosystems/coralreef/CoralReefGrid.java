package core.ecosystems.coralreef;

import core.ecosystems.Grid;
import core.ecosystems.arctic.ArcticCell;
import org.newdawn.slick.GameContainer;

public class CoralReefGrid extends Grid {
    public CoralReefGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new CoralReefCell(i, j);
            }
        }
    }

}
