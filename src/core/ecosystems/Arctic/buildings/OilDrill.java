package core.ecosystems.Arctic.buildings;

import core.ecosystems.Building;
import core.setup.Images;

public class OilDrill extends Building {

    public OilDrill() {
        myImage = Images.oilDrill;
        name = "Oil Drill";
        info = "help please";
        resizeImage();
    }
}
