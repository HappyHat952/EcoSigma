package core.ecosystems;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Cell {
    //static
    private static int width;
    private static int height;

    //not static
    private int row;
    private int col;

    private int myX;
    private int myY;


    public Cell(int r, int c)
    {
        row = r;
        col = c;

        myX = r*width;
        myY = c*height;
    }

    public void render(Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(myX, myY, width, height);
        g.setColor(Color.blue);
        g.setLineWidth(10);
        g.drawRect(myX, myY, width, height);
        g.setColor(Color.white);
        g.drawString(row+", "+col, myX,myY);
    }

    public void update()
    {

    }

    //ACCESSOR
    //MUTATOR
    public static void setWidth(int w)
    {
        width = w;
    }
    public static void setHeight(int h)
    {
        height = h;
    }
}
