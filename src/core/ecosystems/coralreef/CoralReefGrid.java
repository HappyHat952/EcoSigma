package core.ecosystems.coralreef;

import core.ecosystems.Grid;
import core.ecosystems.arctic.ArcticCell;
import core.ecosystems.coralreef.buildings.BioRock;
import core.ecosystems.coralreef.buildings.Coral;
import core.ecosystems.general.Building;
import org.newdawn.slick.GameContainer;

import java.util.ArrayList;

public class CoralReefGrid extends Grid {
    public CoralReefGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new CoralReefCell(i, j);
            }
        }
        Coral coral1 = new Coral(false);
        coral1.assignCell(cells[3][3]);
        Coral coral2 = new Coral(false);
        coral2.assignCell(cells[5][5]);
        Coral coral3 = new Coral(false);
        coral3.assignCell(cells[8][7]);
        buildings.add(coral1);
        buildings.add(coral2);
        buildings.add(coral3);
    }

    @Override
    public void update() {
        super.update();
    }

}
