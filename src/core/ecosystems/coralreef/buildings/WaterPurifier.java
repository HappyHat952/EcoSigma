package core.ecosystems.coralreef.buildings;

import core.ecosystems.general.Building;
import core.setup.Images;

public class WaterPurifier extends Building {

    public WaterPurifier(){
        myImage = Images.CO2SuckerSheet.getSubImage(0,0);
        name = "Building";
        info = "help please";
        resizeImage();
    }

    public void update() {

    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
