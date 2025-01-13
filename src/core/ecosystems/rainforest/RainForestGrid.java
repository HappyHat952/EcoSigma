package core.ecosystems.rainforest;

import core.Main;
import core.ecosystems.Grid;
import core.ecosystems.arctic.buildings.OilDrill;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.coralreef.buildings.BioRock;
import core.ecosystems.coralreef.buildings.Coral;
import core.ecosystems.general.Cell;
import core.ecosystems.rainforest.buildings.Fire;
import core.ecosystems.rainforest.buildings.FireDrone;
import core.ecosystems.rainforest.buildings.SoilEnrichmentMachine;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;

import java.util.ArrayList;

import static core.ecosystems.coralreef.buildings.BioRock.MAX_CORAL_CREATED;

public class RainForestGrid extends Grid {
    public RainForestGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new RainForestCell(j, i);
            }
        }
        Fire fire1 = new Fire();
        fire1.assignCell(cells[5][5], this);
        addBuilding(fire1);
        Fire fire2 = new Fire();
        fire2.assignCell(cells[7][7], this);
        addBuilding(fire2);
        Fire fire3 = new Fire();
        fire3.assignCell(cells[2][2], this);
        addBuilding(fire3);
    }
    //hi

    @Override
    public void update() {
        super.update();
    }

}
