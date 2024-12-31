package core.ecosystems.coralreef.buildings;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;

import java.util.ArrayList;

public class CoralRobot extends Building {

    private int time;
    private Grid grid;
    private int coralRepaired;

    public CoralRobot(){
        myImage = Images.coralRobot;
        name = "Repair Robot";
        info = "help please";
        resizeImage();
        time = 0;
        grid = Game.getCurrentLevel().getGrid();
        coralRepaired = 0;
    }

    public void update() {
        super.update();
        time++;
        if (time % 100 == 0) {
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
            if (!cells.isEmpty()) {
                grid.getCells()[myRow][myCol].removeBuilding();
                int random = (int) (Math.random() * cells.size());
                this.assignCell(cells.get(random), grid);
            }
        }
        checkForDamage();
    }

    public void checkIfPossible(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize() && !grid.getCells()[r][c].hasBuilding() &&
                !grid.getCells()[r][c].hasAnimal() && !grid.getCells()[r][c].hasPlant()) {
            Cell cell = grid.getCells()[r][c];
            validCells.add(cell);
        }
    }

    public void checkCellsForDamage(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize() && grid.getCells()[r][c].getBuilding() instanceof Coral
        && !((Coral) grid.getCells()[r][c].getBuilding()).isHealthy()) {
            Cell cell = grid.getCells()[r][c];
            validCells.add(cell);
        }
    }
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void checkForDamage(){
        ArrayList<Cell> cells = new ArrayList<>();
        int r = myRow;
        int c = myCol;
        checkCellsForDamage(cells, r-1, c-1);
        checkCellsForDamage(cells, r-1, c);
        checkCellsForDamage(cells, r-1, c+1);
        checkCellsForDamage(cells, r, c-1);
        checkCellsForDamage(cells, r, c+1);
        checkCellsForDamage(cells, r+1, c-1);
        checkCellsForDamage(cells, r+1, c);
        checkCellsForDamage(cells, r+1, c+1);

        if (!cells.isEmpty()) {
            int random = (int) (Math.random() * cells.size());
            ((Coral) (cells.get(random).getBuilding())).setIsHealthy(true);
            coralRepaired++;
        }

    }

    public int getCoralRepaired() {
        return coralRepaired;
    }
}
