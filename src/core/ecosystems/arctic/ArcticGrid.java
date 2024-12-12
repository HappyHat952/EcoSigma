package core.ecosystems.arctic;

import core.ecosystems.arctic.buildings.OilDrill;
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
        OilDrill oilDrill1 = new OilDrill();
        oilDrill1.assignCell(cells[5][5]);
        OilDrill oilDrill2 = new OilDrill();
        oilDrill2.assignCell(cells[2][1]);
        OilDrill oilDrill3 = new OilDrill();
        oilDrill3.assignCell(cells[8][7]);
        buildings.add(oilDrill1);
        buildings.add(oilDrill2);
        buildings.add(oilDrill3);
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
            if (b instanceof OilDrill) {
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
