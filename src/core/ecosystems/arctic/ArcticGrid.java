package core.ecosystems.arctic;

import core.ecosystems.arctic.buildings.Fire;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.ecosystems.Grid;
import org.newdawn.slick.GameContainer;

import java.util.ArrayList;

public class ArcticGrid extends Grid {

    public ArcticGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new ArcticCell(i, j);
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

    @Override
    public void mousePressed(int x, int y) {
        if (mouseBuilding != null) {
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (cells[i][j].mouseOver(x, y) && !cells[i][j].hasBuilding()) {
                        if (mouseBuilding instanceof Protesters) {
                            if (isValid(cells[i][j])) {
                                mouseBuilding.assignCell(cells[i][j]);
                                buildings.add(mouseBuilding);
                                mouseBuilding = null;
                                gc.setDefaultMouseCursor();
                                return;
                            }
                        } else {
                            mouseBuilding.assignCell(cells[i][j]);
                            buildings.add(mouseBuilding);
                            mouseBuilding = null;
                            gc.setDefaultMouseCursor();
                        }
                    }
                }
            }
        } else {
            System.out.println("NO BUILDING");
        }
    }

    public boolean isValid(Cell cell) {
        ArrayList<Cell> validCells = new ArrayList<>();

        for (Building b: buildings) {
            if (b instanceof Fire) {
                int r = b.getMyRow();
                int c = b.getMyCol();

                checkIfPossible(validCells, r-1, c-1);
                checkIfPossible(validCells, r-1, c);
                checkIfPossible(validCells, r-1, c+1);
                checkIfPossible(validCells, r, c-1);
                checkIfPossible(validCells, r, c+1);
                checkIfPossible(validCells, r+1, c-1);
                checkIfPossible(validCells, r+1, c);
                checkIfPossible(validCells, r+1, c+1);
            }
        }

        if (validCells.contains(cell)) {
            return true;
        } else {
            return false;
        }

    }


    public void checkIfPossible(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize()) {
            Cell cell = cells[r][c];
            validCells.add(cell);
        }
    }
}
