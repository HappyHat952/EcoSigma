package core.ecosystems.general;

import core.ecosystems.Grid;
import core.setup.Images;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

import java.util.ArrayList;

public class Animal extends Organism {
    protected int x;
    protected int y;
    protected Class<? extends Animal> myClass;

    protected Cell currentCell;
    protected Cell futureCell;
    protected int frame;

    protected int timer;
    protected int maxWaitTime;

    // 0 down, 1 left, 2 right, 3 up
    protected int direction;

    protected ArrayList<Cell> possibleCells;

    protected Grid grid;


    public Animal(Cell cell) {
        super(cell);
        if (cell != null) {
            this.currentCell = cell;
            cell.addAnimal(this);
        }
        x = cell.getX();
        y = cell.getY();

        frame = 0;
        direction = 0;
        sprite = Images.animal;
        maxWaitTime = 70;
        timer = maxWaitTime;

        name = "animal";
        possibleCells = new ArrayList<>();
        myClass = Animal.class;
        image = sprite.getSubImage(0, 0);
    }

    public void render(Graphics g) {
        g.drawImage(sprite.getSubImage(frame, direction).getScaledCopy(Cell.getWidth(), Cell.getHeight()), x, y);
//        if (grid != null) {
//            g.drawString("" + forwardIsClear(grid), x, y);
//        }
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

            possibleCells = grid.getOpenAdjacentCells(currentCell.getCol(), currentCell.getRow());

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


    protected void determineDirection(Cell newCell) {
        int r = newCell.getRow() - currentCell.getRow(); // GREATER THAN 0 IF IT MOVED RIGHT, LESS IF LEFT
        int c = newCell.getCol() - currentCell.getCol(); // GREATER THAN 0 IF IT MOVED DOWN, LESS IF UP

        if (r > 0) {
            direction = 2; // moving right
        } else if (r < 0) {
            direction = 1; //moving left
        } else if (c > 0) {
            direction = 0; //moving down
        } else if (c < 0) {
            direction = 3; // moving up
        }
    }

    private boolean forwardIsClear(Grid grid)
    {
        Cell cell = null;
        switch(direction)
        {
            case(2 ):
                if (currentCell.getRow()+ 1< 10)
                {
                    cell = grid.getCells()[currentCell.getRow()+1][currentCell.getCol()];
                }
            case(1):
                if (currentCell.getRow()-1> 0)
                {
                    cell = grid.getCells()[currentCell.getRow()-1][currentCell.getCol()];
                }
            case(0):
                if (currentCell.getCol()+1< 10)
                {
                    cell = grid.getCells()[currentCell.getRow()][currentCell.getCol()+1];
                }

            case(3):
                if (currentCell.getCol()-1 > 10)
                {
                    cell = grid.getCells()[currentCell.getRow()][currentCell.getCol()-1];
                }

        }

        if (cell != null)
        {
            return !cell.hasBuilding();
        }
        return false;
    }

    private Cell setToForward(Grid grid)
    {
        switch(direction)
        {
            case(2):
                return grid.getCells()[currentCell.getRow()+1][currentCell.getCol()];
            case(1):
                return grid.getCells()[currentCell.getRow()-1][currentCell.getCol()];
            case(0):
                return grid.getCells()[currentCell.getRow()][currentCell.getCol()+1];
            case(3):
                return grid.getCells()[currentCell.getRow()][currentCell.getCol()-1];
        }
        return currentCell;
    }
}
