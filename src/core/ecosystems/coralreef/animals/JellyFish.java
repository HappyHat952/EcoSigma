package core.ecosystems.coralreef.animals;

import core.ecosystems.Grid;
import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class JellyFish extends Animal {
    public JellyFish(Cell cell) {
        super(cell);
        sprite = Images.jellyFish;
        name = "jellyfish";
        costOfGenome = 25;
    }
    public void update(Grid grid) {
        // loops through the walk cycle (happens every time)
        this.grid = grid;
        if (timer % 15 == 0) {
            frame = (frame + 1) % 4;
        }
        if (timer == 0) {

            if (futureCell != null) {
                //switch cell location if future cell is changed
                currentCell.removeAnimal();
                currentCell = futureCell;
                currentCell.addAnimal(this);
                x = currentCell.getX();
                y = currentCell.getY();
            }

            timer = maxWaitTime;

            possibleCells = grid.getOpenAdjacentCells(currentCell.getRow(), currentCell.getCol());

            if (!possibleCells.isEmpty()) {

                //determine next future cell location
                int i = (int) (Math.random() * possibleCells.size());

                futureCell = possibleCells.get(i);
                determineDirection(futureCell);
                futureCell.addAnimal(this);

            }
        } else {
            timer--;

            if (futureCell != null) {
                int displacement = maxWaitTime - timer;
                x = currentCell.getX() + (int) (displacement * (futureCell.getX() - currentCell.getX()) / ((float) maxWaitTime));
                y = currentCell.getY() + (int) (displacement * (futureCell.getY() - currentCell.getY()) / ((float) maxWaitTime));
            }


        }
        possibleCells = grid.getOpenAdjacentCells(currentCell.getCol(), currentCell.getRow());
    }
}
