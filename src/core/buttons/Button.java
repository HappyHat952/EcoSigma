package core.buttons;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Button {
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;
    private Image image;
    protected  String name;

    private int id;
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
            g.setColor(Color.black);
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
