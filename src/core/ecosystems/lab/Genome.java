package core.ecosystems.lab;

import core.Main;
import core.ecosystems.general.Organism;
import org.newdawn.slick.Graphics;

public class Genome {
    private Class<? extends Organism> organism;
    private int x;
    private int y;
    private boolean egged; //has it been put in an egg (aka, can it be made)
    private boolean used;
    public Genome(Class<? extends Organism > o)
    {
        organism = o;

    }

    public void render(Graphics g)
    {
        g.fillOval(x,y,(int)(Main.getScreenWidth()*.02), (int) (Main.getScreenWidth()*.02));
    }

    public void putInEgg(){ egged = true;}
    public void use(){ used = true;}
    public boolean isEgged(){ return egged;}
    public boolean isUsed(){ return used;}
    public Class<? extends Organism> getOrganism()
    {
        return organism;
    }
}
