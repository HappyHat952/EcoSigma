package core.ecosystems.Arctic;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Cloud {

    private int x;
    private int y;
    private int w;
    private int h;
    private boolean isDeleted;

    public Cloud() {
        x = 500;
        y= 500;
        w = 100;
        h = 100;
        isDeleted = false;
    }

    public void render(Graphics g) {
        if (!isDeleted) {
            g.setColor(Color.cyan);
            g.fillRect(x, y, w, h);
        }
    }

    public boolean mouseOver(int mouseX, int mouseY) {
        if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
            return true;
        }
        return false;
    }

    public void delete() {
        isDeleted = true;
    }

}
