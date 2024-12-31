package core.ecosystems;


import core.Main;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.general.Item;
import core.setup.Fonts;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class Shop {

    private final int x = (int) (Main.getScreenWidth() * .7f);
    private static final int y = (int)( Main.getScreenHeight() * .75f);
    private final static int margin = (int)(Main.getScreenWidth() * .05f);
    private final static int buffer = (int)( 200/1920f * Main.getScreenWidth() ) ;
    protected ArrayList<Item> items;
    protected Grid grid;
    protected GameContainer gc;

    protected static int money;

    public Shop(Grid g, GameContainer gc) {
        items = new ArrayList<>();
        money = 50;
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
        g.drawString("$ "+money , Grid.getGridWidth() + margin + Main.getScreenWidth()*.07f, Main.getScreenHeight() * .6f);

        g.setFont(Fonts.small);
        for (int i = 0; i < items.size(); i++) {
            items.get(i).render(g);
        }

    }

    public void update()
    {

    }
    //MUTATOR

    public void mousePressed(int x, int y) {
        for (Item i: items)
        {
            if (i.mouseOver(x,y) && money >= i.getCost() && !grid.mouseHasBuilding())
            {
                money -= i.getCost();
                grid.addMouseBuilding(i.getBuildingClass());
                try {
                    gc.setMouseCursor(i.getBuildingObject().getMyImage().getScaledCopy(50,50),50,50);
                } catch (SlickException e) {
                    throw new RuntimeException(e);
                }
                i.click(x,y);
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
