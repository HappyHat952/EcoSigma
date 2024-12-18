package core.ecosystems.lab;

import core.Main;
import core.buttons.Button;
import core.setup.Images;
import org.newdawn.slick.Image;

public class GenomeMaker extends LabScreen {

    public GenomeMaker()
    {
        super();
        machineButton = new LabMachineButton((int)(Main.getScreenWidth()*.1f), (int)(Main.getScreenHeight()*.4f),
                Images.placeHolder.getSubImage(0,2).getScaledCopy((int)(Main.getScreenWidth()*.1f), (int)(Main.getScreenWidth()*.1)));
    }


    @Override
    void update() {

    }

    @Override
    public void keyPressed(int key, char c) {

    }
}
