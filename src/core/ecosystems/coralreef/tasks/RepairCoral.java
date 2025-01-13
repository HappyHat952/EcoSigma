package core.ecosystems.coralreef.tasks;

import core.Main;
import core.ecosystems.Grid;
import core.ecosystems.arctic.Arctic;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.coralreef.buildings.CoralRobot;
import core.ecosystems.coralreef.buildings.SoundMaker;
import core.ecosystems.general.Building;
import core.ecosystems.rainforest.buildings.Ranger;
import core.ecosystems.tasks.Task;
import org.lwjgl.input.Mouse;


public class RepairCoral extends Task {

    private int coralRepaired;
    final private int TOTAL_CORAL_REPAIRED = 8;

    public RepairCoral(String name, Grid grid) {
        super(name, grid);
        coralRepaired = 0;
    }

    public int getPercentDone() {
        int percent = (int) ((coralRepaired/(float)TOTAL_CORAL_REPAIRED) * 100);
        if (percent > 100) {
            return 100;
        } else {
            return percent;
        }
    }

    public void update() {
        int count = 0;
        for (int i = 0; i < Grid.getGridSize(); i++)
        {
            for (int j = 0; j < Grid.getGridSize(); j++)
            {
                if (grid.getCells()[i][j].getBuilding() instanceof CoralRobot) {
                    count += ((CoralRobot) grid.getCells()[i][j].getBuilding()).getCoralRepaired();
                }
            }
        }
        coralRepaired = count;
    }



}
