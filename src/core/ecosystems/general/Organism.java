package core.ecosystems.general;

import org.newdawn.slick.Image;

public class Organism {
    protected String name;
    protected Image image;

    protected Organism(Cell cell)
    {

    }

    public String toString()
    {
        return name;
    }
    public Image getImage(){ return image; }
}
