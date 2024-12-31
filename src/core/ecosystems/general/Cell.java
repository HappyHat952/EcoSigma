package core.ecosystems.general;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Cell {
    //static
    protected static int width;
    protected static int height;

    //not static
    private int row;
    private int col;

    private int myX;
    private int myY;
    private boolean isOver;

    protected Color myColor;
    protected Image myImage;

    protected Building myBuilding;
    protected Animal myAnimal;
    protected Plant myPlant;
    protected int myState;  // tracks what state the cell is in.


    public Cell(int r, int c)
    {
        row = r;
        col = c;

        myX = c*width;
        myY = r*height;
        myColor = Color.green;
    }

    public void render(Graphics g)
    {
        if(myImage == null)
        {
            g.setColor(myColor);
            g.fillRect(myX, myY, width, height);
        }
        else {
            g.drawImage(myImage.getScaledCopy(width, height), myX,myY);
        }

        g.setColor(Color.black);
        g.setLineWidth(1);
        g.drawRect(myX, myY, width, height);


        if (isOver)
        {
            g.setColor(new Color(1f,1f,1f,.5f));
            g.fillRect(myX,myY, width,height);
        }
//        g.setColor(Color.black);
//        g.drawString("row: "+row +"\ncol: "+ col, myX,myY);

//        if (myBuilding != null)
//        {
//            myBuilding.render(g);
//        }
    }

    public void update(int x, int y)
    {
        isOver = mouseOver(x,y);
    }
    public void setColor(Color color) {
        myColor = color;
    }
    public void setImage(Image image)
    {
        myImage = image;
    }

    //ACCESSOR
    public boolean mouseOver(int x, int y)
    {
        return (x>myX && y >myY && x<myX+width && y< myY+height);
    }
    public Color getColor() {
        return myColor;
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
    public int getX() {return myX;  }
    public int getY()
    {
        return myY;
    }
    public boolean hasBuilding(){ return !(myBuilding == null);}
    public boolean hasAnimal(){return !(myAnimal == null);}
    public boolean hasPlant(){return !(myPlant == null);}
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
    public void addAnimal(Animal a){myAnimal = a;}
    public void addPlant( Plant p){ myPlant = p;}
    public void removeAnimal(){myAnimal = null;}
    public void removePlant(){myPlant = null;}
    public void removeBuilding(){
        myBuilding = null;
    }

    public Building getBuilding() {
        if (hasBuilding()) {
            return myBuilding;
        }
        return null;
    }
}
