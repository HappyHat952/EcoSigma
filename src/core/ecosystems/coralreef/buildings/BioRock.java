package core.ecosystems.coralreef.buildings;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;

import java.util.ArrayList;

public class BioRock extends Building {

    private Grid grid;
    private boolean isDone;
    private int time;
    final public static int MAX_CORAL_CREATED = 2;
    private boolean isCoralCreated;

    public BioRock(){
        myImage = Images.bioRock;
        name = "Biorock";
        info = "help please";
        resizeImage();
        time = 0;
        isCompleted = false;
        isCoralCreated = false;

    }

    public void update() {
        super.update();
        grid = Game.getCurrentLevel().getGrid();
        time++;
        if (time > 5 * 60 && !isCompleted) {
//            ArrayList<Cell> cells = getSurroundingCells();
//
//            for (int i = 0; i < MAX_CORAL_CREATED; i++) {
//                if (!cells.isEmpty()) {
//                    int random = (int) (Math.random() * cells.size());
//                    Coral c = new Coral(true);
//                    c.assignCell(cells.get(random), grid);
//                    cells.remove(random);
//                }
//            }
            isCompleted = true;
        }
    }



    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setCoralCreated(boolean coralCreated) {
        isCoralCreated = coralCreated;
    }

    public boolean isCoralCreated() {
        return isCoralCreated;
    }

    public int getMAX_CORAL_CREATED() {
        return MAX_CORAL_CREATED;
    }
}
