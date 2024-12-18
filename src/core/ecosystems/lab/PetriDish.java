package core.ecosystems.lab;

import core.Main;
import core.setup.Images;

public class PetriDish  extends LabScreen {

    public PetriDish()
    {
        super();
        machineButton = new LabMachineButton((int)(Main.getScreenWidth()*.4f), (int)(Main.getScreenHeight()*.4f),
                Images.placeHolder.getSubImage(0,1).getScaledCopy((int)(Main.getScreenWidth()*.1f), (int)(Main.getScreenWidth()*.1)));
    }


    @Override
    void update() {

    }

    @Override
    public void keyPressed(int key, char c) {

    }

}
