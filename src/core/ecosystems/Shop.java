package core.ecosystems;


import core.Main;
import core.setup.Images;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class Shop {

    private final float x = Main.getScreenWidth() * .65f;
    private final float y = Main.getScreenHeight() * .7f;
    private final float buffer = 180;
    private ArrayList<Item> items;
    public Shop() {
        items = new ArrayList<>();
    }

    public void setItems(int levelID) {
        if (levelID == 0) {
            items.add(new Item("Arctic Machine", Images.arcticMachine, "Makes it cold"));
            items.add(new Item("Arctic Machine", Images.arcticMachine, "Makes it cold"));
            items.add(new Item("Arctic Machine", Images.arcticMachine, "Makes it cold"));
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).render(g, x + i * buffer, y);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
