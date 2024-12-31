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

    protected Cell cell;
    protected SpriteSheet sprite;
    protected int frame;

    protected int timer;
    protected int maxWaitTime;

    // 0 down, 1 left, 2 right, 3 up
    protected int direction;

    public Animal(Cell cell) {
        if (cell != null) {
            this.cell = cell;
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
        myClass = Animal.class;
    }

    public void render(Graphics g) {
        g.drawImage(sprite.getSubImage(frame, direction).getScaledCopy(cell.getWidth(), cell.getHeight()), x, y);
    }

    public void update(Grid grid) {
        if (timer % 15 == 0) {
            frame = (frame + 1) % 4;
        }

        if (timer == 0) {
            timer = maxWaitTime;

            ArrayList<Cell> cells = grid.getOpenAdjacentCells(cell.getRow(), cell.getCol());
            if (!cells.isEmpty()) {
                int i = (int) (Math.random() * cells.size());

                Cell newCell = cells.get(i);
                determineDirection(newCell);

                cell.removeAnimal();
                cell = newCell;
                cell.addAnimal(this);
                x = cell.getX();
                y = cell.getY();
            }
        } else {
            timer--;
        }
    }


    private void determineDirection(Cell newCell) {
        int r = newCell.getRow() - cell.getRow(); // GREATER THAN 0 IF IT MOVED RIGHT, LESS IF LEFT
        int c = newCell.getCol() - cell.getCol(); // GREATER THAN 0 IF IT MOVED DOWN, LESS IF UP

        if (r > 0) {
            direction = 2;
        } else if (r < 0) {
            direction = 1;
        } else if (c > 0) {
            direction = 0;
        } else if (c < 0) {
            direction = 3;
        }
    }
}
