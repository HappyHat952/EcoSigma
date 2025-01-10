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
    protected SpriteSheet sprite;
    protected int frame;

    protected int timer;
    protected int maxWaitTime;

    // 0 down, 1 left, 2 right, 3 up
    protected int direction;

    protected ArrayList<Cell> possibleCells;


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
        image = sprite.getSubImage(0,0);
    }

    public void render(Graphics g) {
        g.drawImage(sprite.getSubImage(frame, direction).getScaledCopy(Cell.getWidth(), Cell.getHeight()), x, y);
    }

    public void update(Grid grid) {
        // loops through the walk cycle (happens every time)
        if (timer % 15 == 0) {
            frame = (frame + 1) % 4;
        }
        //stage 1: moving
        //stage 2: determine next cell location

        if (timer == 0) {

            if (futureCell != null)
            {
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
            }
        } else {
            timer--;
            if (futureCell != null)
            {
                int displacement = maxWaitTime - timer;
                x = currentCell.getX() + (int)( displacement * (futureCell.getX() - currentCell.getX())/((float)maxWaitTime) );
                y = currentCell.getY() + (int) (displacement * (futureCell.getY() - currentCell.getY())/((float)maxWaitTime));
            }
        }
        possibleCells = grid.getOpenAdjacentCells(currentCell.getCol(),currentCell.getRow());
    }


    private void determineDirection(Cell newCell) {
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
}
