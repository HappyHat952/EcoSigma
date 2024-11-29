package core.ecosystems.Lab;

import core.buttons.Button;
import org.newdawn.slick.Color;

public class UpgradeLab extends Button {

    private int timer;
    private int maxTime;
    private int frames;
    private boolean researching;
    private boolean complete;

    public UpgradeLab() {
        super(0, 0, 600, 100, Color.red);
        name = "upgrade lab";
        maxTime = 10; //in seconds
        timer = maxTime;
        researching = false;
        complete = false;
    }

    public void update() {
        frames ++;
        if (frames %60 == 0 && researching)
        {
            timer --;
            if (timer == 0)
            {
                maxTime*=(1f);
                timer = maxTime;
                researching = false;
                complete = true;
            }
        }
        name ="upgrade lab -" + timer;
    }

    public void action()
    {
        researching = true;
        timer = maxTime;
    }

    public boolean isComplete()
    {
        return complete;
    }
    public void reset()
    {
        complete = false;
    }
}
