package core.ecosystems.general;

import core.Main;
import core.ecosystems.Grid;
import core.ecosystems.Shop;
import core.setup.Fonts;
import core.ui.PopupManager;
import org.lwjgl.input.Mouse;
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
    protected Class<? extends Building> buildingClass;
    protected Building buildingObject;
    protected Color myColor;
    protected boolean wasClicked;
    protected int myNum;
    protected Shop shop;



    public Item(int i, Class<? extends Building> buildingClass, Building buildingObject, int popupID, Shop shop) {
        this.name = buildingObject.getName();
        this.image = buildingObject.getMyImage().getScaledCopy((int)(Main.getScreenWidth()*.12), (int)(Main.getScreenWidth()*.12));
        this.info = buildingObject.getInfo();
        this.x = i * Shop.getBuffer() + Shop.getMargin() + Grid.getGridWidth();
        this.y = Shop.getHeight();
        this.myNum = popupID;
        this.buildingClass = buildingClass;
        this.buildingObject = buildingObject;
        myColor = Color.white;
        cost = buildingObject.getCost();
        this.shop = shop;

    }

    public void render(Graphics g) {
        g.drawImage(image, x, y);
        g.setColor(myColor);
        g.drawString(name+"\n$ "+cost, x + 20, y + image.getHeight() + 10);
        g.drawRect(x, y,image.getWidth(), image.getHeight());

        if (shop != null && !shop.hasMoney(cost) )
        {
            g.setColor (new Color(255,0,0,50));
            g.fillRect(x,y,image.getWidth(),image.getHeight());
        }


        if (mouseOver(Mouse.getX(), Main.getScreenHeight() -Mouse.getY())) {
            image.drawFlash(x, y);
            if(info != null)
            {
                g.setFont(Fonts.small);
                g.setColor(Color.black);
                g.drawString(name, x + image.getWidth()*.6f - Fonts.small.getWidth(name) / .6f, y + image.getHeight() / 2f);
            }

        }
    }

    public void click(int x, int y)
    {
        if(!wasClicked)
        {
            PopupManager.activate(myNum);
        }
        if (mouseOver(x,y))
        {
            wasClicked = true;
        }



    }

    public boolean mouseOver(int x, int y)
    {
        return (x>this.x && x< (this.x+image.getWidth()) && y > this.y  && y< (this.y + image.getHeight()) );

    }

    //Accessor
    public Class<? extends Building> getBuildingClass()
    {
//        building = new Building();
        return buildingClass;
    }

    public Building getBuildingObject() {
        return buildingObject;
    }

    public int getCost()
    {
        return cost;
    }

    //mutator



}
