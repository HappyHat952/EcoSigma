package core.ecosystems.general;

import core.ecosystems.Grid;
import core.setup.Images;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

import java.util.ArrayList;

public class Animal {
    protected int x;
    protected int y;
    protected String name;
    protected Class<? extends Animal> myClass;

    protected Cell cell;
    protected SpriteSheet sprite;
    protected int frame;

    protected int timer;
    protected int maxWaitTime;

    public Animal(Cell cell)
    {
        if (cell != null)
        {
            this.cell = cell;
            cell.addAnimal(this);
        }
        x = cell.getX();
        y = cell.getY();

        frame = 0;
        sprite = Images.animal;
        maxWaitTime = 100;
        timer = maxWaitTime;

        name = "animal";
        myClass = Animal.class;



    }
    public void render(Graphics g)
    {
        g.drawImage(sprite.getSubImage(0,frame).getScaledCopy(cell.getWidth(), cell.getHeight()),  x,  y);
    }
    public void update(Grid grid)
    {
        //this means all animal sprites MUST be vertical
        if (timer %15 == 0)
        {
            if (frame<sprite.getVerticalCount()-1)
            {
                frame ++;
            }
            else {
                frame = 0;

            }
        }

        if (timer == 0)
        {
            timer = maxWaitTime;

            ArrayList<Cell> tempCells = grid.getOpenAdjacentCells(cell.getRow(),cell.getCol());
            int i = (int)(Math.random() * tempCells.size());

            if (!tempCells.isEmpty())
            {
                cell.removeAnimal();

                cell = tempCells.get(i);
                cell.addAnimal(this);
                x = cell.getX();
                y = cell.getY();
            }
        }
        else {
            timer --;
        }
    }

    public String toString()
    {
        return name;
    }


}
