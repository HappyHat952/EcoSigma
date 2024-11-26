package core.ecosystems.Arctic;

import core.Main;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import core.ecosystems.Grid;

public class Cloud {

    private int x;
    private int y;
    private int w;
    private int h;
    private int xSpeed;
    private int ySpeed;
    private boolean isDeleted;

    public Cloud() {
        w = 100;
        h = 100;
        x = (int) (Math.random() *(Grid.getGridWidth() - w));
        y = (int) ((Main.getScreenHeight() -h) * Math.random());

        xSpeed = (int) (Math.random() * 2) + 3;
        ySpeed = (int) (Math.random() * 2) + 3;
        isDeleted = false;
    }

    public void render(Graphics g) {
        if (!isDeleted) {
            g.setColor(Color.cyan);
            g.fillRect(x, y, w, h);
        }
    }

    public void update() {
        if (x > 0 && x < Grid.getGridWidth() - w ) {
            x += xSpeed;

        } else {
            xSpeed = xSpeed * -1;

            x+= xSpeed;

        }
        if (y > 0 && y < Main.getScreenHeight() - h) {
            y += ySpeed;
        } else {
            ySpeed = ySpeed * -1;
            y+= ySpeed;
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

    public boolean isDeleted() {
        return isDeleted;
    }
}
