package core.ecosystems.coralreef.buildings;

import core.ecosystems.general.Building;
import core.setup.Images;

public class SoundMaker extends Building {

    public SoundMaker(){
        myImage = Images.soundCreator;
        name = "Sound Creator";
        info = "help please";
        resizeImage();
    }

    public void update() {
        super.update();

    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
