package core.ecosystems.arctic.buildings;

import core.ecosystems.general.Building;
import core.setup.Images;

public class Fire extends Building {

    public Fire() {
        myImage = Images.check;
        name = "Fire";
        info = "help please";
        resizeImage();
    }
}
