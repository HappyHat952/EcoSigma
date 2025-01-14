package core.ecosystems.coralreef.buildings;

import core.ecosystems.general.Building;
import core.setup.Images;

public class SoundMaker extends Building {

    public SoundMaker(){
        myImage = Images.soundCreator;
        name = "Audio Amplifier";
        info = "help please";
        resizeImage();
        cost = 85;
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
