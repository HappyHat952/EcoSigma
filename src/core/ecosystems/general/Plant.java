package core.ecosystems.general;

import core.ecosystems.Grid;
import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

public class Plant extends Organism{
    protected int x;
    protected int y;

    protected Cell cell;
    protected SpriteSheet sprite;
    protected int frame;

    protected int frameTimer;

    protected int growTime;
    protected int secondTimer;

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
        growTime = 2;

        name = "plant";



    }
    public void render(Graphics g)
    {
        g.drawImage(sprite.getSubImage(0,frame).getScaledCopy(cell.getWidth(), cell.getHeight()),  x,  y);
        g.drawString(""+ frame, x,y);
    }
    public void update(Grid grid)
    {
        //this means all animal sprites MUST be vertical
        frameTimer ++;
        if (frameTimer% 60 == 0)
        {
            secondTimer ++;
            frameTimer =0;
        }

        if (secondTimer == growTime)
        {
            if (frame< sprite.getVerticalCount()-1)
            {
                frame ++;
            }
            secondTimer = 0;
        }
//        if (frameTimer % 33000 == 0)
//        {
//            if (frame<sprite.getVerticalCount()-1)
//            {
//                frame ++;
//            }
//        }
//
//        if (frameTimer == 0)
//        {
//            frameTimer = maxWaitTime;
//        }
//        else {
//            frameTimer --;
//        }
    }

    public boolean isMature()
    {
        return (frame == sprite.getVerticalCount()-1);
    }
    public Cell getCell(){ return cell;}

    public void click(int x, int y, int button)
    {
        sprite.setImageColor(1f,0f,0f);
    }
    public boolean mouseOver(int x, int y)
    {
        return (x>this.x && y>this.y && x<(this.x + Cell.getWidth()) && y< (this.y + Cell.getHeight()));
    }


}
