package core.ecosystems;

import core.setup.Images;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Animal {
    protected int x;
    protected int y;

    protected Cell cell;
    protected Image myImage;

    public Animal(Cell cell)
    {
        if (cell != null)
        {
            this.cell = cell;
        }
        x = cell.getX();
        y = cell.getY();

        myImage = Images.animal.getSubImage(0,0).getScaledCopy(cell.getWidth(), cell.getHeight());


    }
    public void render(Graphics g)
    {
        g.drawImage(myImage,  x,  y);
    }
    public void update()
    {

    }


}
