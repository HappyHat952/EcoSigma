package core.ecosystems.lab.organismMaker;

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

public class OrganismMaker extends LabScreen {

    CloneProgress[] cloneSlots;

    public OrganismMaker(){
        super();
        machineButton = new LabMachineButton((int)(Main.getScreenWidth()*.6f), (int)(Main.getScreenHeight()*.4f),
                Images.placeHolder.getSubImage(0,3).getScaledCopy((int)(Main.getScreenWidth()*.1f), (int)(Main.getScreenWidth()*.1)));
        cloneSlots = new CloneProgress[3];

    }
    @Override
    public void update() {

        if (open)
        {
            int i = 0;
            for (Genome g: Lab.getGenomes())
            {
                removeCompleted();
                setCloneSlots();
            }
            for (CloneProgress c: cloneSlots)
            {
                if (c!= null)
                {
                    c.update();
                }

            }
        }

    }
    public boolean hasSlotsOpen(){
        for (CloneProgress c: cloneSlots)
        {
            if (c == null)
            {
                return true;
            }
        }
        return false;
    }

    public void render(Graphics g)
    {
        super.render(g);
        if (open)
        {
            g.setColor(Color.black); g.setFont(Fonts.big);
            g.drawString("Cloning Progress", x+Main.getScreenWidth()*.11f, y+Main.getScreenHeight()*.12f);
            int i = 0;
            for(CloneProgress p: cloneSlots)
            {
                if (p == null)
                {
                    g.setLineWidth(4); g.setColor(Color.white);
                    g.drawRect(x+Main.getScreenWidth()*.11f, y+ Main.getScreenHeight()*.21f + i*Main.getScreenHeight()*.15f
                            , Main.getScreenWidth()*.58f, Main.getScreenHeight()*.12f);
                    i++;
                }
                else {
                    p.render(g);
                }
            }
        }
    }

    @Override
    public void keyPressed(int key, char c) {

    }

    @Override
    public void mouseClicked(int button, int x, int y) {
        super.mouseClicked(button, x, y);
        for (CloneProgress p: cloneSlots)
        {
            if (p!= null)
            {
                p.mouseClick(x,y);
            }
        }
    }

    public void setCloneSlots()
    {
        //loops through all clone slots and puts them in a slot if it is not empty/currently used;
        ArrayList<Integer> slots = getAvailableSlots();
        for(Genome g: Lab.getGenomes())
        {
            if (g.isEgged() && !isInProgress(g) && !slots.isEmpty())
            {
                cloneSlots[(slots.getFirst())] = new CloneProgress(10, g, slots.getFirst());
            }
        }
    }

    public void removeCompleted()
    {
        for (int i=0; i<cloneSlots.length; i++)
        {
            if (cloneSlots[i] != null && cloneSlots[i].getIfComplete())
            {
                cloneSlots[i] = null;
            }
        }
    }

    public ArrayList<Integer> getAvailableSlots()
    {
        ArrayList<Integer> available = new ArrayList<>();
        for (int i = 0; i< cloneSlots.length; i++)
        {
            if (cloneSlots[i]== null)
            {
                available.add(i);
            }
        }
        return available;
    }


    public boolean isInProgress(Genome compG)
    {
        for (CloneProgress c: cloneSlots)
        {
            if (c != null && c.getGenome() == compG)
            {
                return true;
            }
        }
        return false;
    }
}
