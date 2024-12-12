package core.ecosystems.arctic.buildings;

import core.ecosystems.general.Building;
import core.setup.Images;

public class OilDrill extends Building {

    public OilDrill() {
        myImage = Images.oilDrill;
        name = "Oil Drill";
        info = "help please";
        resizeImage();
    }
}
