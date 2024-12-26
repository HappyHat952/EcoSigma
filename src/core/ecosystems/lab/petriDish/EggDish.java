package core.ecosystems.lab.petriDish;

import core.Main;
import core.ecosystems.lab.Genome;
import core.ecosystems.lab.Lab;
import core.setup.Fonts;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class EggDish {
    Genome genome;
    int pixelX;
    int pixelY;
    int pixelW;
    int pixelH;
    public EggDish(Genome g)
    {
        genome = g;
    }

    public void render(Graphics g, int i)
    {
        int x = i%4;
        int y = i/4;
        int w = (int)(Main.getScreenWidth()*.22f);
        int h = (int)(Main.getScreenHeight()*.22f);

        pixelX = (int)(w + x*Main.getScreenHeight()*.11f);
        pixelY = (int)(h + y* Main.getScreenHeight()*.11f);
        pixelW = (int) (Main.getScreenHeight()*.1f);
        pixelH = (int)(Main.getScreenHeight()*.11f);

        g.setColor(Color.cyan);
        g.fillOval(pixelX, pixelY, pixelW, pixelH);
        g.setColor(Color.black); g.setFont(Fonts.small);
        g.drawString(Lab.getOrganismName(genome.getOrganism()), pixelX, pixelY);
    }

    public Genome getGenome(){ return genome;}
    public boolean mouseOver(int x, int y)
    {
        return  (distance(x,y, pixelX + (int)(pixelW/2), pixelY + (int)(pixelH/2))< pixelW/2 );
    }
    public int distance(int x1, int y1, int x2, int y2)
    {
        return (int)(Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2), 2)));
    }
}