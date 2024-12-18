package core.buttons;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Button {
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected Color color;
    protected Image image;
    protected  String name;

    public Button(int x, int y, int w, int h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    public Button(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
        w = image.getWidth();
        h = image.getHeight();
    }

    public Button(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g) {
        if (image == null)
        {
            g.setColor(color);
            g.fillRect(x, y, w, h);

        }
        else {
            g.drawImage(image, x,y);
        }

        if (name != null)
        {
            g.setColor(Color.white);
            g.drawString(name, x+w/2f, y+ h/2f);
        }
    }

    public boolean isMouseOver(int mouseX, int mouseY) {
        if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
            return true;
        }
        return false;
    }
}
