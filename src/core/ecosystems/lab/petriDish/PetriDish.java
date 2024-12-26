package core.ecosystems.lab.petriDish;

import core.Main;
import core.ecosystems.lab.Genome;
import core.ecosystems.lab.Lab;
import core.ecosystems.lab.LabMachineButton;
import core.ecosystems.lab.LabScreen;
import core.setup.Fonts;
import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class PetriDish  extends LabScreen {

    public ArrayList<EggDish> dishes;

    public PetriDish()
    {
        super();
        dishes = new ArrayList<>();
        machineButton = new LabMachineButton((int)(Main.getScreenWidth()*.4f), (int)(Main.getScreenHeight()*.4f),
                Images.placeHolder.getSubImage(0,1).getScaledCopy((int)(Main.getScreenWidth()*.1f), (int)(Main.getScreenWidth()*.1)));
    }


    @Override
    public void update() {

        if (open)
        {

        }
    }

    public void render(Graphics g)
    {
        super.render(g);
        g.setColor(Color.black);
        if (open)
        {
            int i = 0;
            for (EggDish e: dishes)
            {
                e.render(g, i);
                i++;
            }
            if (!Lab.getGenomes().isEmpty())
            {
                g.setFont(Fonts.big);
                g.drawString("Click circle to put genome in egg",
                        x+Main.getScreenWidth()*.11f, y+Main.getScreenHeight()*.12f);
            }

            g.resetFont();
        }
    }

    @Override
    public void keyPressed(int key, char c) {

    }

    @Override
    public void mouseClicked(int button, int x, int y) {
        super.mouseClicked(button, x, y);
        if (open)
        {
            for (EggDish d: dishes)
            {
                if(d.mouseOver(x,y))
                {
                    d.getGenome().putInEgg();
                }
            }
        }
    }

    public void setDishes(ArrayList<Genome> genomes)
    {
        dishes = new ArrayList<>();
        for (Genome g: genomes)
        {
            dishes.add(new EggDish(g));
        }
    }

}