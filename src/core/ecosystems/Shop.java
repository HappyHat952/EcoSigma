package core.ecosystems;


import core.Main;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.general.Item;
import core.ecosystems.general.OrganismItem;
import core.setup.Fonts;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class Shop {

    private final int x = (int) (Main.getScreenWidth() * .7f);
    private static final int y = (int)( Main.getScreenHeight() * .75f);
    private final static int margin = (int)(Main.getScreenWidth() * .04f);
    private final static int buffer = (int)( 260/1920f * Main.getScreenWidth() ) ;
    protected ArrayList<Item> items;
    //protected OrganismItem organismItem;
    protected ArrayList<OrganismItem> organismItems;
    protected Grid grid;
    protected GameContainer gc;

    protected static int money;

    public Shop(Grid g, GameContainer gc) {
        items = new ArrayList<>();
        money = 5000;
        grid = g;
        this.gc = gc;

    }

    public void setItems() {

    }

    public void addMoney(int value)
    {
        money += value;
    }

    public void render(Graphics g) {
        g.setColor(Color.white); g.setFont(Fonts.big);
        g.drawString("$ "+money , Grid.getGridWidth() + margin + Main.getScreenWidth()*.12f, Main.getScreenHeight() * .565f);

        g.setFont(Fonts.small);
        for (int i = 0; i < items.size(); i++) {
            items.get(i).render(g);
        }

//        if (organismItem != null)
//        {
//            organismItem.render(g);
//        }
        for (int i = 0; i < organismItems.size(); i++) {
            organismItems.get(i).render(g);
        }

    }

    public void update()
    {

    }
    //MUTATOR

    public void setOrganismItems(ArrayList<OrganismItem> organismItems)
    {
        this.organismItems = organismItems;
    }

    public void mousePressed(int x, int y) {
        for (Item i: items)
        {
            if (i.mouseOver(x,y) && money >= i.getCost() && !grid.mouseHasBuilding() && !grid.mouseHasOrganism())
            {
                money -= i.getCost();
                grid.addMouseBuilding(i.getBuildingClass());
                try {
                    gc.setMouseCursor(i.getBuildingObject().getMyImage().getScaledCopy(50,50),25,25);
                } catch (SlickException e) {
                    throw new RuntimeException(e);
                }
                i.click(x,y);
            }
        }
        for (OrganismItem oi: organismItems) {
            if (oi != null)
            {
                oi.click(x,y);
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
