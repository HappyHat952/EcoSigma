package core.ecosystems.general;

import core.Main;
import core.ecosystems.Grid;
import core.lab.Lab;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class OrganismItem {
    protected int x;
    protected int y;
    protected int i;
    protected int numOrganisms;
    protected Grid grid;

    protected Class<? extends Organism> myOrganism;

    protected static int buffer;
    protected static int margin;
    protected static int size;

    public OrganismItem(int i , Class<? extends Organism> myOrganism, Grid grid)
    {
        margin = Grid.getGridWidth() + (int)(Main.getScreenWidth()*.22f);
        buffer = (int)(Main.getScreenWidth()*.05f);
        size = (int) (Main.getScreenWidth() *.04f);

        x = margin + buffer* i;
        y = (int) (Main.getScreenHeight() *.65f);
        this.myOrganism = myOrganism;
        this.grid = grid;
        this.i = i;
        numOrganisms = 2;

    }
    public void render(Graphics g)
    {
        //draws square if none available or red animal image
        g.setColor (Color.white);
        g.fillRect(x,y,size,size);
      //  g.drawImage(Lab.getOrganismName())
        g.setColor(Color.black);
        g.drawString(""+numOrganisms, x + size/2, y + size/2);

    }

    public void action() {
        if (numOrganisms >0)
        {
            grid.addMouseOrganism(myOrganism);
            numOrganisms --;
        }
    }

    public boolean mouseOver(int x, int y)
    {
        return (x> this.x && x < this.x + size && y> this.y && y< this.y + size);
    }

    public void click(int x, int y)
    {
        if (mouseOver( x,  y))
        {
            action();
        }
    }
}
