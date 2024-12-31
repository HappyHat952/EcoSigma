package core.ecosystems.rainforest.buildings;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.coralreef.buildings.Coral;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;

import java.util.ArrayList;

public class FireDrone extends Building {
        private int time;
        private boolean isCompleted;
        private Grid grid;

        public FireDrone() {
            myImage = Images.lemming;
            name = "Fire Drone";
            info = "help";
            isCompleted = false;
            resizeImage();
            grid = Game.getCurrentLevel().getGrid();
            time = 0;
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
            checkForFire();
        }

    public void checkIfPossible(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize() && !grid.getCells()[r][c].hasBuilding() &&
                !grid.getCells()[r][c].hasAnimal() && !grid.getCells()[r][c].hasPlant()) {
            Cell cell = grid.getCells()[r][c];
            validCells.add(cell);
        }
    }

    public void checkCellsForFire(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize() && grid.getCells()[r][c].getBuilding() instanceof Fire) {
            Cell cell = grid.getCells()[r][c];
            validCells.add(cell);
        }
    }

    public void checkForFire(){
        ArrayList<Cell> cells = new ArrayList<>();
        int r = myRow;
        int c = myCol;
        checkCellsForFire(cells, r-1, c-1);
        checkCellsForFire(cells, r-1, c);
        checkCellsForFire(cells, r-1, c+1);
        checkCellsForFire(cells, r, c-1);
        checkCellsForFire(cells, r, c+1);
        checkCellsForFire(cells, r+1, c-1);
        checkCellsForFire(cells, r+1, c);
        checkCellsForFire(cells, r+1, c+1);

        if (!cells.isEmpty()) {
            int random = (int) (Math.random() * cells.size());
            Fire fire = (Fire) cells.get(random).getBuilding();
            grid.getBuildings().remove(fire);
            grid.getCells()[fire.getMyRow()][fire.getMyCol()].removeBuilding();
        }

    }

    }
