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
    final private int MAX_CORAL_CREATED = 2;
    public BioRock(){
        myImage = Images.bioRock;
        name = "Biorock";
        info = "help please";
        resizeImage();
        time = 0;
        isDone = false;
    }

    public void update() {
        super.update();
        grid = Game.getCurrentLevel().getGrid();
        time++;
        if (time > 5 * 60 && !isDone) {
            ArrayList<Cell> cells = getSurroundingCells();

            for (int i = 0; i < MAX_CORAL_CREATED; i++) {
                if (!cells.isEmpty()) {
                    int random = (int) (Math.random() * cells.size());
                    Coral c = new Coral(true);
                    c.assignCell(cells.get(random), grid);
                    cells.remove(random);
                }
            }
            isDone = true;
        }
    }


    public ArrayList<Cell> getSurroundingCells() {
        ArrayList<Cell> addedCells = new ArrayList<>();
        checkIfPossible(addedCells, myRow - 1, myCol);
        checkIfPossible(addedCells, myRow + 1, myCol);
        checkIfPossible(addedCells, myRow, myCol - 1);
        checkIfPossible(addedCells, myRow, myCol + 1);
        checkIfPossible(addedCells, myRow - 1, myCol - 1);
        checkIfPossible(addedCells, myRow - 1, myCol + 1);
        checkIfPossible(addedCells, myRow + 1, myCol - 1);
        checkIfPossible(addedCells, myRow + 1, myCol + 1);
        return addedCells;
    }

    public void checkIfPossible(ArrayList<Cell> addedCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize() && !grid.getCells()[r][c].hasBuilding()) {
            Cell cell = grid.getCells()[r][c];
            addedCells.add(cell);
        }
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
