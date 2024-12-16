package core.ecosystems.coralreef.buildings;

import core.ecosystems.general.Building;
import core.setup.Images;

public class BioRock extends Building {

    public BioRock(){
        myImage = Images.bioRock;
        name = "Biorock";
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
