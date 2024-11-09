package core.ecosystems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Item {

    private String name;
    private Image image;
    private String info;
    private int x;
    private int y;
    private int cost;

    public Item(String name, Image image, String info, int x, int y) {
        this.name = name;
        this.image = image;
        this.info = info;
        this.x = x;
        this.y = y;
        cost = 4;

    }

    public void render(Graphics g) {
        g.drawImage(image, x, y);
        g.drawString(name, x + 20, y + image.getHeight() + 10);
    }

    public void click(int x, int y)
    {
        if (mouseOver(x,y))
        {

        }
    }

    public boolean mouseOver(int x, int y)
    {
        return (x>this.x && x< this.x+image.getWidth() && y > this.y  && y<this.y + image.getHeight() );

    }

    public int getCost()
    {
        return cost;
    }


}
