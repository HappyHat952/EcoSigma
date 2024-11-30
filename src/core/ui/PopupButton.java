package core.ui;

import core.buttons.Button;
import org.newdawn.slick.Color;

public class PopupButton extends Button {
    final static int WIDTH = 75;
    final static int HEIGHT = 50;
    public PopupButton(int x, int y)
    {
        super(x,y, WIDTH, HEIGHT, Color.blue);
        name = "continue";
    }
}

