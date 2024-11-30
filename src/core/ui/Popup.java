package core.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import core.ui.PopupButton;

import core.ecosystems.Game;

public class Popup {
    private PopupButton myButton;
    private String title;
    private String message;

    private boolean active;

    public Popup(String title, String message)
    {
        this.title = title;
        this.message = message;
        myButton = new PopupButton(220,240);
        Game.pause();
    }

    public Popup()
    {
        title = "test";
        message = "tester\nererererer";

        myButton = new PopupButton(440,240);
        active = true;
        Game.pause();
    }

    public void render(Graphics g) {
        if (active)
        {
            g.resetFont();
            g.setColor(Color.white);
            g.fillRect(40,40,500,300);
            g.setColor(Color.black);
            g.drawString(title,40,40);
            g.setColor(Color.darkGray);
            g.drawString(message, 40,70);
            myButton.render(g);
        }

    }

    public void update() {
    }

    public void click(int x, int y) {
        if (myButton.isMouseOver(x,y))
        {
            active = false;
            Game.unpause();
        }
    }

    public boolean isActive()
    {
        return active;
    }
    public void activate(){ active = true;}
}