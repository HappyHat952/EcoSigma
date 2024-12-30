package core.ecosystems.general;

import core.ecosystems.Grid;
import core.setup.Images;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

public class Plant extends Organism{
    protected int x;
    protected int y;

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
        maxWaitTime = 30;
        timer = maxWaitTime;

        name = "plant";



    }
    public void render(Graphics g)
    {
        g.drawImage(sprite.getSubImage(frame,0).getScaledCopy(cell.getWidth(), cell.getHeight()),  x,  y);
    }
    public void update(Grid grid)
    {
        if (timer > 0) {
            timer--;
        }


        if (timer == 0) {
            frame = (frame + 1) % sprite.getHorizontalCount();
            timer = maxWaitTime;
        }
        //this means all animal sprites MUST be vertical
//        if (timer % 33000 == 0)
//        {
//            if (frame<sprite.getVerticalCount()-1)
//            {
//                frame ++;
//            }
//        }
//
//        if (timer == 0)
//        {
//            timer = maxWaitTime;
//        }
//        else {
//            timer --;
//        }
    }


}
