package core.ecosystems.arctic;

import core.Main;
import core.setup.Images;
import org.newdawn.slick.Graphics;
import core.ecosystems.Grid;
import org.newdawn.slick.Image;

public class Cloud {

    private int x;
    private int y;
    private int w;
    private int h;
    private int xSpeed;
    private int ySpeed;
    private Image image;
    private int value;

    public Cloud() {
        image = Images.cloudSheet.getSprite(0, 0);
        w = image.getWidth();
        h = image.getHeight();
        x = (int) (Math.random() *(Grid.getGridWidth() - w));
        y = (int) ((Main.getScreenHeight() -h) * Math.random());
        image = Images.cloudSheet.getSprite(0, 0);

        xSpeed = (int) (Math.random() * 2) + 2;
        ySpeed = (int) (Math.random() * 2) + 2;

        value = 15;
    }

    public void render(Graphics g) {
            g.drawImage(image, x, y);
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

    public int getValue()
    {
        return value;
    }

}
