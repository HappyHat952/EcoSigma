package core.ecosystems.Arctic.buildings;

import core.ecosystems.Building;
import core.ecosystems.Cell;
import core.ecosystems.Game;
import core.ecosystems.Grid;
import core.setup.Images;
import org.newdawn.slick.Color;

import java.util.ArrayList;

public class IcePump extends Building {
    private int time;
    private int stage;
    private boolean isCompleted;
    private int iceCreated;
    private int lastReportedIce;
    private Grid grid;

    public IcePump() {
        myImage = Images.pump;
        name = "Ice Pump";
        info = "help";
        time = 0;
        stage = 0;
        isCompleted = false;
        iceCreated = 0;
        lastReportedIce = 0;
        resizeImage();
    }

    public void update() {
        grid = Game.getCurrentLevel().getGrid();
        if (stage < 2 && !isCompleted) {

            time++;
            if (time >= 5 * 60) {
                time = 0;
                ArrayList<Cell> cells = getSurroundingCells(stage);
                for (Cell cell : cells) {
                    cell.setColor(Color.white);
                }
                iceCreated += cells.size();
                stage++;
                isCompleted = true;
            }
        }
    }

    private ArrayList<Cell> getSurroundingCells(int stage) {
        ArrayList<Cell> addedCells = new ArrayList<>();
        if (stage == 0) {
            checkIfPossible(addedCells, myRow - 1, myCol);
            checkIfPossible(addedCells, myRow + 1, myCol);
            checkIfPossible(addedCells, myRow, myCol - 1);
            checkIfPossible(addedCells, myRow, myCol + 1);
        } else if (stage == 1) {
            checkIfPossible(addedCells, myRow - 1, myCol - 1);
            checkIfPossible(addedCells, myRow - 1, myCol + 1);
            checkIfPossible(addedCells, myRow + 1, myCol - 1);
            checkIfPossible(addedCells, myRow + 1, myCol + 1);
        }
        return addedCells;
    }

    private void checkIfPossible(ArrayList<Cell> addedCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridWidth() && c >= 0 && c < Grid.getGridWidth()) {
            Cell cell = grid.getCells()[r][c];
            addedCells.add(cell);
        }
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getIceCreated() {
        int ice = iceCreated - lastReportedIce;
        lastReportedIce = iceCreated;
        return ice;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
