package core.ecosystems.rainforest;

import core.ecosystems.Grid;
import core.ecosystems.arctic.buildings.OilDrill;
import core.ecosystems.rainforest.buildings.Fire;
import org.newdawn.slick.GameContainer;

public class RainForestGrid extends Grid {
    public RainForestGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new RainForestCell(i, j);
            }
        }
        Fire fire1 = new Fire();
        fire1.assignCell(cells[5][5], this);
        addBuilding(fire1);
        Fire fire2 = new Fire();
        fire2.assignCell(cells[8][7], this);
        addBuilding(fire2);
        Fire fire3 = new Fire();
        fire3.assignCell(cells[2][2], this);
        addBuilding(fire3);
    }
}
