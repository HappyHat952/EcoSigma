package core.ecosystems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Item {

    private String name;
    private Image image;
    private String info;
    public Item(String name, Image image, String info) {
        this.name = name;
        this.image = image;
        this.info = info;
    }

    public void render(Graphics g, float x, float y) {
        g.drawImage(image, x, y);
        g.drawString(name, x + 20, y + image.getHeight() + 10);
    }


}
