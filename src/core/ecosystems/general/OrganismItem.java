package core.ecosystems.general;

import core.ecosystems.Grid;
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

    public OrganismItem(int i , Class<? extends Organism> myOrganism, Grid grid)
    {

    }
    public void render(Graphics g)
    {
        //draws square if none available or red animal image

    }

    public void action() {
        if (numOrganisms >0)
        {
            grid.addOrganism(myOrganism);
            numOrganisms --;
        }
    }
}
