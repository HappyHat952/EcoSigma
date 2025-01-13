package core.ecosystems.coralreef;

import core.Main;
import core.ecosystems.Grid;
import core.ecosystems.arctic.ArcticCell;
import core.ecosystems.coralreef.buildings.BioRock;
import core.ecosystems.coralreef.buildings.Coral;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.ecosystems.rainforest.buildings.Ranger;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;

import java.util.ArrayList;

import static core.ecosystems.coralreef.buildings.BioRock.MAX_CORAL_CREATED;

public class CoralReefGrid extends Grid {
    public CoralReefGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new CoralReefCell(j, i);
            }
        }
        Coral coral1 = new Coral(false);
        coral1.assignCell(cells[3][3], this);
        Coral coral2 = new Coral(false);
        coral2.assignCell(cells[5][5], this);
        Coral coral3 = new Coral(false);
        coral3.assignCell(cells[8][7], this);

        addBuilding(coral1);
        addBuilding(coral2);
        addBuilding(coral3);
    }

    @Override
    public void update() {
        super.update();

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                cells[i][j].update(Mouse.getX(), Main.getScreenHeight() - Mouse.getY());
                if (cells[i][j].hasBuilding() && cells[i][j].getBuilding() instanceof BioRock && ((BioRock) cells[i][j].getBuilding()).isCompleted()
                        && !((BioRock) cells[i][j].getBuilding()).isCoralCreated()) {

                    ArrayList<Cell> c = getSurroundingCells(i, j);

                    for (int a = 0; a < MAX_CORAL_CREATED; a++) {
                        if (!c.isEmpty()) {
                            int random = (int) (Math.random() * c.size());
                            Coral coral = new Coral(true);
                            coral.assignCell(c.get(random), this);
                            buildings.add(coral);
                            c.remove(random);
                            ((BioRock) cells[i][j].getBuilding()).setCoralCreated(true);
                        }
                    }
                }
            }
        }
    }

    public ArrayList<Cell> getSurroundingCells(int myRow, int myCol) {
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
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c < Grid.getGridSize() && !this.getCells()[r][c].hasBuilding()) {
            Cell cell = this.getCells()[r][c];
            addedCells.add(cell);
        }
    }
}
