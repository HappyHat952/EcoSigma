package core.ecosystems.arctic.buildings;

import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.Game;
import core.ecosystems.Grid;
import core.setup.Images;

import java.util.ArrayList;

public class Protesters extends Building {

    private int time;
    public Protesters() {
        time = 0;
        myImage = Images.protesters;
        name = "Protesters";
        info = "help please";
        resizeImage();
    }
    public void update() {
        time++;
        if (time >= (10 * 60)){
            isCompleted = true;
        }
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean b) {
       isCompleted = b;
    }

    public Fire getOilDrill() {
        ArrayList<Cell> cells = new ArrayList<>();
        int r = myRow;
        int c = myCol;
        checkIfPossible(cells, r-1, c-1);
        checkIfPossible(cells, r-1, c);
        checkIfPossible(cells, r-1, c+1);
        checkIfPossible(cells, r, c-1);
        checkIfPossible(cells, r, c+1);
        checkIfPossible(cells, r+1, c-1);
        checkIfPossible(cells, r+1, c);
        checkIfPossible(cells, r+1, c+1);

        for (Cell cell: cells) {
            if (cell.getBuilding() instanceof Fire) {
                return (Fire) cell.getBuilding();
            }
        }
        return null;
    }

    public void checkIfPossible(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize()) {
            Cell cell = Game.getCurrentLevel().getGrid().getCells()[r][c];
            validCells.add(cell);
        }
    }

}
