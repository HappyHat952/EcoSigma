package core.ecosystems;


import core.Main;
import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class Shop {

    private final int x = (int) (Main.getScreenWidth() * .65f);
    private static final int y = (int)( Main.getScreenHeight() * .7f);
    private final static int margin = (int)(Main.getScreenWidth() * .05f);
    private final static int buffer = (int)( 200/1920f * Main.getScreenWidth() ) ;
    protected ArrayList<Item> items;
    protected Grid grid;

    protected static int money;

    public Shop( Grid g) {
        items = new ArrayList<>();
        money = 50;
        grid = g;

    }

    public void setItems() {
            for (int i = 0; i<3; i++)
            {
                items.add(new Item (i));
//                items.add(new Item("Arctic Machine", Images.arcticMachine, "Makes it cold",
//                        (int)(Grid.getGridWidth()+ margin + i * buffer), (int) y ) );
            }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawString("$ "+money + "\nitems: "+items.size(), Grid.getGridWidth() + margin, Main.getScreenHeight() * .65f);

        for (int i = 0; i < items.size(); i++) {
            items.get(i).render(g);
        }
    }

    public void update()
    {

    }
    //MUTATOR

    public void mousePressed(int x, int y)
    {
        for (Item i: items)
        {
            if (i.mouseOver(x,y) && money >= i.getCost() && !grid.mouseHasBuilding())
            {
                money -= i.getCost();
                grid.addBuilding(i.getBuilding());//later make it so it matches the item purchased.
            }
        }
    }


    //ACCESSOR

    public ArrayList<Item> getItems() {
        return items;
    }
    public static int getHeight() { return y;}
    public static int getBuffer() { return buffer;}
    public static int getMargin(){ return margin;};
}
