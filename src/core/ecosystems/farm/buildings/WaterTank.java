package core.ecosystems.farm.buildings;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.farm.FarmCell;
import core.ecosystems.farm.FarmGrid;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;

import java.util.ArrayList;

public class WaterTank extends Building {
    Grid grid;
    private int frameTimer;
    int currentStage;
    boolean corners;
    public WaterTank()
    {
        super();
        myImage = Images.placeHolder.getScaledCopy(Cell.getWidth() , (int)(Cell.getWidth()*1.5f));
        cost = 40;
        name = "Water Tank";
        corners = false;
    }

    public void update()
    {
        super.update();
        frameTimer++;
        if (frameTimer %160 == 0 && currentStage <2)
        {
            currentStage ++;
        }
        if (frameTimer %79 == 0 )
        {
            for (Cell c : getSurroundingCells(currentStage, corners))
            {
                c.setImage(Images.farmCells.getSubImage(0,1));
                ((FarmCell)c).waterCell();
            }
            corners = !corners;

        }

    }

    public ArrayList<Cell> getSurroundingCells(int stage, boolean corners) {
        ArrayList<Cell> addedCells = new ArrayList<>();

        //based on the stage, and if it needs corners, determine what cells need to be added.
        if (stage == 0)
        {
            checkIfPossible(addedCells, myRow, myCol);
        }
        else {
            for (int i = -stage; i <= stage; i++) {
                for (int j = -stage; j <= stage; j++) {
                    if (corners && Math.abs(i) == Math.abs(j) && Math.abs(i) == stage) {
                        checkIfPossible(addedCells, myRow + i, myCol + j);
                    } else if (!corners && Math.abs(i) != Math.abs(j) && (Math.abs(i) == stage || Math.abs(j) == stage)) {
                        checkIfPossible(addedCells, myRow + i, myCol + j);
                    }

                }
            }
        }

        return addedCells;
    }

    public void checkIfPossible(ArrayList<Cell> addedCells, int r, int c) {
        grid = Game.getCurrentLevel().getGrid();
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize()) {
            Cell cell = grid.getCells()[r][c];
            addedCells.add(cell);
        }
    }
}
