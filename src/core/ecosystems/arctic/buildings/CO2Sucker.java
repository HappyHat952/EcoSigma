package core.ecosystems.arctic.buildings;

import core.ecosystems.general.Building;
import core.setup.Images;

public class CO2Sucker extends Building {

    private int time;
    public CO2Sucker() {
        myImage = Images.CO2SuckerSheet.getSubImage(0,0);
        name = "CO2 Sucker";
        info = "help please";
        time = 0;
        resizeImage();
    }

    public void update() {
        time++;
        if (time >= (5 * 60)){
            isCompleted = true;
            time = 0;
        }
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
