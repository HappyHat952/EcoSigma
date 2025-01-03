package core.lab;

import core.Main;
import core.buttons.Button;
import core.ecosystems.general.Organism;
import core.setup.Fonts;
import core.setup.Images;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.ArrayList;

public class GenomeMaker extends LabScreen {
    static ArrayList<Button> screenButtons;
    static String[] segments;

    public GenomeMaker()
    {
        super();
        machineButton = new LabMachineButton((int)(Main.getScreenWidth()*.05f), (int)(Main.getScreenHeight()*.3f),
                Images.genomeMaker.getScaledCopy((int)(Main.getScreenWidth()*.2f), (int)(Main.getScreenWidth()*.2)));
        screenButtons = new ArrayList<Button>();
    }


    @Override
    public void update() {

    }

    public void render(Graphics g)
    {
        super.render(g);

        if (open)
        {
            g.setColor(Color.black);
            g.setFont(Fonts.big);
            g.drawString("GENOME MAKER", x+Main.getScreenWidth()*.11f, y+Main.getScreenHeight()*.12f);
            g.drawString("Pick the Genome of an Organism to Clone!", x+Main.getScreenWidth()*.11f, y+Main.getScreenHeight()*.17f);



            g.setLineWidth(3);
            g.setColor(Color.white);
            g.drawRect(x+Main.getScreenWidth()*.125f , y+Main.getScreenHeight()*.5f, width - Main.getScreenWidth()*.25f,
                    Fonts.medium.getHeight());


            for(Button b: screenButtons)
            {
                b.render(g);
                if (b.isMouseOver(Mouse.getX(), Main.getScreenHeight() - Mouse.getY()))
                {
                    g.setFont(Fonts.medium);
                    g.drawString(b.getName().substring(2) +" genome",x + Main.getScreenWidth()*.125f, Main.getScreenHeight()*.47f);
                    int letterW = Fonts.medium.getWidth("G");
                    //g.drawString(segments[screenButtons.indexOf(b)].substring(0, 1+(int)((width - Main.getScreenWidth()*.25f) /letterW)),
                    //        x + Main.getScreenWidth()*.125f,
                    //        y+ Main.getScreenHeight() *.5f);
                }
            }

        }
    }

    @Override
    public void keyPressed(int key, char c) {
        int index;
        if (key>= Input.KEY_1 && key<= Input.KEY_0)
        {
            index = key - 2;
            if (index < Lab.getAvailableOrganisms().size())
            {
                Lab.addGenome(new Genome(Lab.getAvailableOrganisms().get(index)));
            }

        }
    }

    public void setButtons()
    {
        screenButtons = new ArrayList<>();
        ArrayList<Class<? extends Organism>> organisms = Lab.getAvailableOrganisms();
        for(int i=0; i< organisms.size(); i++)
        {
            screenButtons.add(new Button((int)(Main.getScreenWidth()*.25f + Main.getScreenWidth()*i*.5f/organisms.size()),
                    (int)(Main.getScreenHeight()*.35f),(int) (Main.getScreenWidth()*.45f/organisms.size()),
                    (int)(Main.getScreenHeight()*.1f),Color.lightGray,""+(i+1)+": " +Lab.getOrganismName(organisms.get(i)) ));
        }

        setSegments(organisms.size());
    }

    @Override
    public void mouseClicked(int button, int x, int y) {
        super.mouseClicked(button, x, y);
        if (open)
        {
            for(Button b: screenButtons)
            {
                if (b.isMouseOver(x,y))
                {
                    Lab.addGenome(new Genome(Lab.getAvailableOrganisms().get(screenButtons.indexOf(b))));
                }
            }
        }
    }

    public void setSegments( int num)
    {
        segments = new String[num];
        for(int i = 0; i< num; i++)
        {
            String dna = "";
            for (int j = 0; j < 120; j++)
            {
                String b;
                double f = Math.random();
                if (f<.25){ b = "A";}
                else if (f< .5){ b = "G";}
                else if (f< .75){ b = "T";}
                else{ b = "C";}
                dna = dna + b;
            }
            segments[i] = dna;
        }
    }
}
