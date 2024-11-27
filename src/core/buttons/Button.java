package core.buttons;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Button {
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;
    protected String name;

    private int id;
    public Button(int x, int y, int w, int h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, w, h);
        g.setColor(Color.black);
        if (name != null)
        {
            g.drawString(name, x+w/2f, y+ w/2f);
        }
    }

    public boolean isMouseOver(int mouseX, int mouseY) {
        if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
            return true;
        }
        return false;
    }

}
