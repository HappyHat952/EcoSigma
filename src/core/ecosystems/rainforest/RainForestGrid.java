package core.ecosystems.rainforest;

import core.ecosystems.Grid;
import core.ecosystems.arctic.buildings.Fire;
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
        fire1.assignCell(cells[5][5]);
        Fire fire2 = new Fire();
        fire2.assignCell(cells[2][1]);
        Fire fire3 = new Fire();
        fire3.assignCell(cells[8][7]);
        buildings.add(fire1);
        buildings.add(fire2);
        buildings.add(fire3);

    }
}
