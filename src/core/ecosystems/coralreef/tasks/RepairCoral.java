package core.ecosystems.coralreef.tasks;

import core.ecosystems.Grid;
import core.ecosystems.arctic.Arctic;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.coralreef.buildings.SoundMaker;
import core.ecosystems.general.Building;
import core.ecosystems.tasks.Task;

public class RepairCoral extends Task {


    public RepairCoral(String name, Grid grid) {
        super(name, grid);
    }

    public int getPercentDone() {
        return 0;
    }

    public void update() {

    }



}
