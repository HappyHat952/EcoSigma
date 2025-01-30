package core.lab.petriDish;

import core.Game;
import core.Main;
import core.lab.Genome;
import core.lab.Lab;
import core.lab.LabMachineButton;
import core.lab.LabScreen;
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
        machineButton = new LabMachineButton((int)(Main.getScreenWidth()*.35f), (int)(Main.getScreenHeight()*.3f),
                Images.petriDishes.getScaledCopy((int)(Main.getScreenWidth()*.2f), (int)(Main.getScreenWidth()*.2f)),2);
        id = 2;

    }


    @Override
    public void update() {

        if (open)
        {
            setDishes(Lab.getGenomes());
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
            else {
                g.setFont(Fonts.big);
                g.drawString("Make Genomes before placing in egg",
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
                if(!Game.getPause() && d.mouseOver(x,y))
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
            if (!g.isEgged())
            {
                dishes.add(new EggDish(g));
            }

        }
    }

}
