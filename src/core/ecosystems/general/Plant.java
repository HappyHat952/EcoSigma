package core.ecosystems.general;

import core.Main;
import core.ecosystems.Grid;
import core.setup.Fonts;
import core.setup.Images;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class Plant extends Organism{
    protected int x;
    protected int y;

    protected Cell cell;

    protected int frameTimer;
    protected int frame;

    protected int growTime;
    protected int secondTimer;

    public Plant(Cell cell)
    {
        super(cell);
        if (cell != null)
        {
            this.cell = cell;
            cell.addPlant(this);
        }


        frame = 0;
        sprite = Images.plant;
        growTime = 2;

        name = "plant";
        image = sprite.getSubImage(0, sprite.getVerticalCount()-1);
        image = image.getScaledCopy((float)cell.getWidth()/image.getWidth());
        x = cell.getX();
        y = cell.getY()-(image.getHeight() -Cell.getHeight());



    }

    public void setSprite(SpriteSheet sprite)
    {
        this.sprite = sprite;
        image = sprite.getSubImage(0, sprite.getVerticalCount()-1);
        image = image.getScaledCopy((float)cell.getWidth()/image.getWidth());
        x = cell.getX();
        y = cell.getY()-(image.getHeight() -Cell.getHeight());
    }
    public void render(Graphics g)
    {
        Image image = sprite.getSubImage(0,frame);
        g.drawImage(image.getScaledCopy((float)cell.getWidth()/image.getWidth()),  x,  y);
        if(cell.mouseOver(Mouse.getX(), Main.getScreenHeight() - Mouse.getY()))
        {
            g.setColor(Color.white); g.setFont(Fonts.small);
            g.drawString(name, x,cell.getY());
        }

    }
    public void update(Grid grid) {
        //this means all animal sprites MUST be vertical
        frameTimer++;
        if (frameTimer % 60 == 0) {
            secondTimer++;
            frameTimer = 0;
        }

        if (secondTimer == growTime) {
            if (frame < sprite.getVerticalCount() - 1) {
                frame++;
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

    public boolean isValid (Cell c)
    {
        return true;
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
        return (x> cell.getX() && y>cell.getY() && x<(cell.getX() + Cell.getWidth()) && y< (cell.getY() + Cell.getHeight()));
    }


}
