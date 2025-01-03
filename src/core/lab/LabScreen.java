package core.lab;

import core.Main;
import core.buttons.Button;
import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

abstract public class LabScreen {
    static protected int height;
    static protected int width;
    static protected int x;
    static protected int y;
    protected Button closeButton;
    protected LabMachineButton machineButton;


    protected boolean open;//determines if the lab1 machine has been opened

    public LabScreen()
    {
        x = (int)(Main.getScreenWidth()*.1f);
        y = (int)(Main.getScreenHeight()*.1f);
        width = (int)(Main.getScreenWidth()*.8f);
        height = (int)(Main.getScreenHeight()*.8f);

        closeButton = new Button(x+width,y,
                Images.placeHolder.getSubImage(0,0).getScaledCopy((int)(Main.getScreenHeight()*.05f),(int)(Main.getScreenHeight()*.05f)));
    }
    public void render(Graphics g)
    {
        machineButton.render(g);
        if (open)
        {
            g.setColor(new Color(23,23,23));
            g.fillRect(x,y,width, height);
            g.setColor(new Color(23,23,233));
            g.fillRect(2*x,2*y,width-(2*x), height- 2*y);
            closeButton.render(g);
        }

    }
    protected abstract void update();

    public void mouseClicked(int button, int x, int y)
    {
        if (!open && machineButton.isMouseOver( x,  y))
        {
            open = true;
            Lab.freeze();
        }
        if (open && (closeButton.isMouseOver(x,y)||!mouseOver(x,y)))
        {
            open = false;
            Lab.unfreeze();
        }
    }

    public boolean mouseOver(int x, int y)
    {
        if (x>this.x && x<(this.x+width))
        {
            if (y>this.y && y<(this.y + height))
            {
                return true;
            }
        }
        return false;
    }

    abstract public void keyPressed(int key, char c);

    public boolean getIsOpen(){     return open;}
    public static int getScreenX(){        return x;}
    public static int getScreenY(){        return y;}
    public static int getScreenHeight(){   return height;}
    public static int getScreenWidth(){    return width;}

    public int getMachineX(){       return machineButton.getX();}
    public int getMachineY(){       return machineButton.getY();}
    public int getMachineHeight(){       return machineButton.getHeight();}
    public int getMachineWidth(){       return machineButton.getWidth();}
}
