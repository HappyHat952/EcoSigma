package core.ecosystems;

import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Item {

    protected String name;
    protected Image image;
    protected String info;
    protected int index;
    protected int x;
    protected int y;
    protected int cost;
    protected Building building;
    protected Color myColor;

    public Item(String name, Image image, String info, int i, int y) {
        this.name = name;
        this.image = image;
        this.info = info;
        index = i;
        this.x = i*Shop.getBuffer() + Shop.getMargin() + Grid.getGridWidth();
        this.y = Shop.getHeight();
        cost = 4;

    }
    public Item(int i ) {
        this.name = "notNamed";
        this.image = Images.arcticMachine.getFlippedCopy(false, true);//upside down Image if not there
        this.info = "doesn't exist";
        this.x = i* Shop.getBuffer() + Shop.getMargin() + Grid.getGridWidth();
        this.y = Shop.getHeight();
        cost = 4;
        building = new Building();

        myColor = Color.white;

    }

    public void render(Graphics g) {
        g.drawImage(image, x, y);
        g.setColor(myColor);
        g.drawString(name+"\n$ "+cost, x + 20, y + image.getHeight() + 10);
        g.drawRect(x, y,image.getWidth(), image.getHeight());
    }

    public void click(int x, int y)
    {
        if (mouseOver(x,y))
        {
            myColor = Color.green;
        }
        else {
            myColor = Color.white;
        }
    }

    public boolean mouseOver(int x, int y)
    {
        return (x>this.x && x< (this.x+image.getWidth()) && y > this.y  && y< (this.y + image.getHeight()) );

    }

    //Accessor
    public Building getBuilding()
    {
        building = new Building();
        return building;
    }

    public int getCost()
    {
        return cost;
    }

    //mutator



}
