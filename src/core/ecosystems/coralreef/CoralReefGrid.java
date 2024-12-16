package core.ecosystems.coralreef;

import core.ecosystems.Grid;
import core.ecosystems.arctic.ArcticCell;
import core.ecosystems.coralreef.buildings.Coral;
import org.newdawn.slick.GameContainer;

public class CoralReefGrid extends Grid {
    public CoralReefGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new CoralReefCell(i, j);
            }
        }
        Coral coral1 = new Coral();
        coral1.assignCell(cells[3][3]);
        Coral coral2 = new Coral();
        coral2.assignCell(cells[5][5]);
        Coral coral3 = new Coral();
        coral3.assignCell(cells[8][7]);
        buildings.add(coral1);
        buildings.add(coral2);
        buildings.add(coral3);
    }

}
