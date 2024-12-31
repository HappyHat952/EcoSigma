package core.ecosystems.lab.organismMaker;

import core.Main;
import core.buttons.Button;
import core.ecosystems.lab.Genome;
import core.ecosystems.lab.Lab;
import core.ecosystems.lab.LabScreen;
import core.setup.Fonts;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


public class CloneProgress {
    private Button timerOrEcosystem;
    private int maxTime;
    private int totalTime;
    private int myIndex;
    private int frameTime;

    private boolean isTiming;
    private boolean ready;

    private Genome myGenome;
    public CloneProgress(int maxTime, Genome g, int i)
    {
        this.maxTime = maxTime;
        totalTime = maxTime;
        myGenome = g;
        myIndex = i;

        timerOrEcosystem = new Button((int)(Main.getScreenWidth()*.66f), (int)(LabScreen.getScreenY() + Main.getScreenHeight()*.21f + i*Main.getScreenHeight()*.15f)
                , (int)(Main.getScreenWidth()*.1f), (int)(Main.getScreenHeight()*.12f), Color.lightGray, "Start Clone");
    }

    public void render(Graphics g)
    {
        //progressBar
        g.setColor(Color.black);
        g.fillRect(Main.getScreenWidth()*.23f, LabScreen.getScreenY()+ Main.getScreenHeight()*.21f + myIndex*Main.getScreenHeight()*.15f
                , Main.getScreenWidth()*.37f, Main.getScreenHeight()*.12f);
        g.setColor(Color.cyan);
        g.fillRect(Main.getScreenWidth()*.23f, LabScreen.getScreenY() + Main.getScreenHeight()*.21f + myIndex*Main.getScreenHeight()*.15f
                , Main.getScreenWidth()*.37f*(totalTime*1f/maxTime), Main.getScreenHeight()*.12f);
        g.setColor(Color.black); g.setFont(Fonts.medium);
        g.drawString(""+totalTime+"/ "+maxTime+"+ "+Lab.getOrganismName(myGenome.getOrganism()), Main.getScreenWidth()*.28f, LabScreen.getScreenY()+ Main.getScreenHeight()*.21f + myIndex*Main.getScreenHeight()*.15f);

        if (timerOrEcosystem != null)
        {
            timerOrEcosystem.render(g);
        }

    }

    public void update()
    {
        if (isTiming) {
            frameTime++;

            if (frameTime % 60 == 0) {
                if (totalTime > 0) {
                    totalTime--;
                    timerOrEcosystem = null;
                } else {
                    timerOrEcosystem = new Button((int) (Main.getScreenWidth() * .66f), (int) (LabScreen.getScreenY() + Main.getScreenHeight() * .21f + myIndex * Main.getScreenHeight() * .15f)
                            , (int) (Main.getScreenWidth() * .1f), (int) (Main.getScreenHeight() * .12f), Color.green, "Put In Ecosystem");
                }
            }
        }
    }

    public void mouseClick(int x, int y)
    {
        if (timerOrEcosystem != null && timerOrEcosystem.isMouseOver(x,y))
        {
            if (!isTiming)
            {
                isTiming = true;
            }
            else if (totalTime <= 0)
            {
                if (myGenome.isEgged() && !myGenome.isUsed())
                {
                    Lab.addOrganismToGame(myGenome.getOrganism());
                    myGenome.use();
                    ready = true;
                }
            }
        }
    }

    public boolean getIfComplete(){ return myGenome.isUsed();}
    public Genome getGenome(){ return myGenome;}

}
