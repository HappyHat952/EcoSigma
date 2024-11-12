package core.ecosystems;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Cell {
    //static
    protected static int width;
    protected static int height;

    //not static
    private int row;
    private int col;

    private int myX;
    private int myY;

    protected Color myColor;


    public Cell(int r, int c)
    {
        row = r;
        col = c;

        myX = r*width;
        myY = c*height;
        myColor = Color.green;
    }

    public void render(Graphics g)
    {
        g.setColor(myColor);
        g.fillRect(myX, myY, width, height);
        g.setColor(Color.blue);
        g.setLineWidth(10);
        g.drawRect(myX, myY, width, height);
        g.setColor(Color.black);
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
