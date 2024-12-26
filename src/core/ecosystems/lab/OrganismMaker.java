package core.ecosystems.lab;

import core.Main;
import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class OrganismMaker extends LabScreen{

    public OrganismMaker(){
        super();
        machineButton = new LabMachineButton((int)(Main.getScreenWidth()*.6f), (int)(Main.getScreenHeight()*.4f),
                Images.placeHolder.getSubImage(0,3).getScaledCopy((int)(Main.getScreenWidth()*.1f), (int)(Main.getScreenWidth()*.1)));
    }
    @Override
    public void update() {

        if (open)
        {
            for (Genome g: Lab.getGenomes())
            {
                if (g.isEgged() && !g.isUsed())
                {
                    Lab.addOrganismToGame(g.getOrganism());
                    g.use();
                }
            }
        }

    }

    public void render(Graphics g)
    {
        super.render(g);
        g.setColor(Color.black);
        if (open)
        {
            g.drawString("Automatically puts organism in ecosystem", Main.getScreenWidth()/2, Main.getScreenHeight()/2);
        }
    }

    @Override
    public void keyPressed(int key, char c) {

    }
}
