package core.lab;

import core.buttons.Button;
import core.setup.Fonts;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class LabMachineButton extends Button {
    boolean open;
    int order;

    public LabMachineButton (int x, int y, Image i, int order) {
        super(x,y,i);
        this.order= order;
    }

    public void render(Graphics g)
    {
        super.render(g);
        if (LabScreen.isSomethingOpen())
        {
            g.drawImage(image,x,y);
        }
        g.setColor(Color.white); g.setFont(Fonts.big);
        g.drawString(""+order, x,y);

    }

    public void action()
    {
        open = true;
    }
}
