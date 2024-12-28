package core.ecosystems.rainforest.buildings;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.arctic.buildings.OilDrill;
import core.ecosystems.coralreef.buildings.Coral;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;

import java.util.ArrayList;

public class Ranger extends Building {

    private int time;
    public Ranger() {
        myImage = Images.lemming;
        name = "Ranger";
        info = "help";
        isCompleted = false;
        resizeImage();
        time = 0;
    }

    @Override
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
                int random = (int) (Math.random() * cells.size());
                this.assignCell(cells.get(random));
            }
        }

    }

    public void checkIfPossible(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize() && !Game.getCurrentLevel().getGrid().getCells()[r][c].hasBuilding() &&
                !Game.getCurrentLevel().getGrid().getCells()[r][c].hasAnimal() && !Game.getCurrentLevel().getGrid().getCells()[r][c].hasPlant()) {
            Cell cell = Game.getCurrentLevel().getGrid().getCells()[r][c];
            validCells.add(cell);
        }
    }
}
