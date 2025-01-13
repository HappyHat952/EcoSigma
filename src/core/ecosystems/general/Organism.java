package core.ecosystems.general;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class Organism {
    protected String name;
    protected Image image;
    protected SpriteSheet sprite;
    protected int costOfGenome;

    protected Organism(Cell cell)
    {

    }

    public String toString()
    {
        return name;
    }
    public Image getImage(){
        if (sprite != null)
        {
            return sprite.getSubImage(0,0);
        }
        return image;
    }
    public int getCostOfGenome(){ return costOfGenome;}
}
