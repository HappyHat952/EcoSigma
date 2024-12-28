package core.ecosystems.coralreef.buildings;

import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class CoralRobot extends Building {


    public CoralRobot(){
        myImage = Images.coralRobot;
        name = "Repair Robot";
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
