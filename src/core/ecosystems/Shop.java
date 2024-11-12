package core.ecosystems;


import core.Main;
import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class Shop {

    private final float x = Main.getScreenWidth() * .65f;
    private final float y = Main.getScreenHeight() * .7f;
    private final float margin = Main.getScreenWidth() * .05f;
    private final float buffer = 180;
    private ArrayList<Item> items;

    protected static int money;

    public Shop() {
        items = new ArrayList<>();
        money = 10;

    }

    public void setItems(int levelID) {
        if (levelID == 0) {
            for (int i = 0; i<3; i++)
            {
                items.add(new Item("Arctic Machine", Images.arcticMachine, "Makes it cold",
                        (int)(Grid.getGridWidth()+ margin + i * buffer), (int) y ) );
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawString("$ "+money, Grid.getGridWidth() + margin, Main.getScreenHeight() * .65f);

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
            if (i.mouseOver(x,y) && money >= i.getCost())
            {
                money -= i.getCost();
            }
        }
    }


    //ACCESSOR

    public ArrayList<Item> getItems() {
        return items;
    }
}
