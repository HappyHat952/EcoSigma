package core.ecosystems.arctic.buildings;

import core.ecosystems.arctic.Arctic;
import core.ecosystems.arctic.ArcticCell;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.Game;
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
        mySprite = Images.animatedPump;
        myImage = Images.animatedPump.getSubImage(0,0);
        name = "Ice Pump";
        info = "help";
        time = 0;
        stage = 0;
        isCompleted = false;
        iceCreated = 0;
        frameRate = 23;
        lastReportedIce = 0;
        resizeImage();
        cost = 60;
    }

    public void update() {
        super.update();
        grid = Game.getCurrentLevel().getGrid();
        if (stage < 2) {
            time++;
            if (time >= 5 * 60) {
                time = 0;
                ArrayList<Cell> cells = getSurroundingCells(stage);
                for (Cell cell : cells) {
                    if (!((ArcticCell)cell).isIce())
                    {
                        ArcticCell c = (ArcticCell)cell;
                        c.setToIce();
                        cell.setImage(Images.arcticCells.getSubImage(0,4));
                        Game.getCurrentShop().addMoney(15);
                    }

                }
                iceCreated += cells.size();
                stage++;
            }
        }
        if (frame == mySprite.getVerticalCount())
        {
            frame = 0;
        }
    }

    public ArrayList<Cell> getSurroundingCells(int stage) {
        ArrayList<Cell> addedCells = new ArrayList<>();
        if (stage == 0) {
            checkIfPossible(addedCells, myRow - 1, myCol);
            checkIfPossible(addedCells, myRow + 1, myCol);
            checkIfPossible(addedCells, myRow, myCol - 1);
            checkIfPossible(addedCells, myRow, myCol + 1);
            checkIfPossible(addedCells, myRow, myCol);
        } else if (stage == 1) {
            checkIfPossible(addedCells, myRow - 1, myCol - 1);
            checkIfPossible(addedCells, myRow - 1, myCol + 1);
            checkIfPossible(addedCells, myRow + 1, myCol - 1);
            checkIfPossible(addedCells, myRow + 1, myCol + 1);
        }
        return addedCells;
    }

    public void checkIfPossible(ArrayList<Cell> addedCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize()) {
            Cell cell = grid.getCells()[r][c];
            addedCells.add(cell);
        }
    }

}
