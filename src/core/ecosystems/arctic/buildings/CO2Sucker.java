package core.ecosystems.arctic.buildings;

import core.ecosystems.arctic.Arctic;
import core.ecosystems.general.Building;
import core.setup.Images;

public class CO2Sucker extends Building {

    private int time;
    public CO2Sucker() {
        myImage = Images.CO2SuckerSheet.getSubImage(0,0);
        mySprite = Images.CO2SuckerSheet;
        myImage = myImage.getScaledCopy(myImage.getWidth(), myImage.getHeight());
        name = "CO2 Sucker";
        info = "help please";
        time = 0;
        frameRate = 12;
        resizeImage();
        cost = 35;
    }

    public void update() {
        super.update();

        time++;
        if (time >= (5 * 60)){
            isCompleted = true;
            time = 0;
        }
        if (frame == mySprite.getVerticalCount() - 1 && !Arctic.getClouds().isEmpty())
        {
            frame = 0;
        }
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
