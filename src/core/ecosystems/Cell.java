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

    protected Building myBuilding;
    protected int myState;  // tracks what state the cell is in.


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
        if (myBuilding != null)
        {
            myBuilding.render(g);
        }
    }

    public void update()
    {

    }

    //ACCESSOR
    public boolean mouseOver(int x, int y)
    {
        return (x>myX && y >myY && x<myX+width && y< myY+height);
    }
    public static int getWidth()
    {
        return width;
    }
    public static int getHeight()
    {
        return height;
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    public int getX()
    {
        return myX;
    }
    public int getY()
    {
        return myY;
    }
    public boolean hasBuilding(){ return !(myBuilding == null);}
    //MUTATOR
    public static void setWidth(int w)
    {
        width = w;
    }
    public static void setHeight(int h)
    {
        height = h;
    }

    public void addBuilding(Building b)
    {
        myBuilding = b;
    }
}
