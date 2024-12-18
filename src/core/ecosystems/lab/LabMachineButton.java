package core.ecosystems.lab;

import core.buttons.Button;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class LabMachineButton extends Button {
    boolean open;

    public LabMachineButton (int x, int y, Image i) {
        super(x,y,i);
    }

    public void render(Graphics g)
    {
        super.render(g);
    }

    public void action()
    {
        open = true;
    }
}
