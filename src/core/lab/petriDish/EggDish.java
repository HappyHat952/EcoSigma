package core.lab.petriDish;

import core.Main;
import core.lab.Genome;
import core.lab.Lab;
import core.setup.Fonts;
import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class EggDish {
    Genome genome;
    int pixelX;
    int pixelY;
    int pixelW;
    int pixelH;

    private int dish;
    public EggDish(Genome g)
    {
        genome = g;
        dish = (int)( Math.random() * 3);
    }

    public void render(Graphics g, int i)
    {
        int x = i%4;
        int y = i/4;
        int w = (int)(Main.getScreenWidth()*.28f);
        int h = (int)(Main.getScreenHeight()*.32f);

        pixelX = (int)(w + x*Main.getScreenHeight()*.21f);
        pixelY = (int)(h + y* Main.getScreenHeight()*.21f);
        pixelW = (int) (Main.getScreenHeight()*.23f);
        pixelH = (int)(Main.getScreenHeight()*.23f);

        //the petri dish
        //     g.setColor(Color.cyan);
        g.drawImage(Images.petriDish.getSubImage(0,dish).getScaledCopy(pixelW,pixelH), pixelX, pixelY);
  //      g.fillOval(pixelX, pixelY, pixelW, pixelH);

        //the name
        g.setColor(Color.black); g.setFont(Fonts.small);
        int textW = Fonts.small.getWidth(Lab.getOrganismName(genome.getOrganism()));
        g.drawString(Lab.getOrganismName(genome.getOrganism()), pixelX +(int)(pixelW/2f)- (int)(textW/2f) , pixelY
         + pixelH + Fonts.small.getHeight());
    }

    public Genome getGenome(){ return genome;}
    public boolean mouseOver(int x, int y)
    {
        return  (distance(x,y, pixelX + (int)(pixelW/2f), pixelY + (int)(pixelH/2f))< pixelW/2 );
    }
    public int distance(int x1, int y1, int x2, int y2)
    {
        return (int)(Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2), 2)));
    }
}