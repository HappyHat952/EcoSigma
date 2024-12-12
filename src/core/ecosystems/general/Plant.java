package core.ecosystems.general;

import core.ecosystems.Grid;
import core.setup.Images;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

public class Plant {
    protected int x;
    protected int y;
    protected String name;

    protected Cell cell;
    protected SpriteSheet sprite;
    protected int frame;

    protected int timer;
    protected int maxWaitTime;

    public Plant(Cell cell)
    {
        if (cell != null)
        {
            this.cell = cell;
            cell.addPlant(this);
        }
        x = cell.getX();
        y = cell.getY();

        frame = 0;
        sprite = Images.plant;
        maxWaitTime = 100000;
        timer = maxWaitTime;

        name = "plant";



    }
    public void render(Graphics g)
    {
        g.drawImage(sprite.getSubImage(0,frame).getScaledCopy(cell.getWidth(), cell.getHeight()),  x,  y);
    }
    public void update(Grid grid)
    {
        //this means all animal sprites MUST be vertical
        if (timer % 33000 == 0)
        {
            if (frame<sprite.getVerticalCount()-1)
            {
                frame ++;
            }
        }

        if (timer == 0)
        {
            timer = maxWaitTime;
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
