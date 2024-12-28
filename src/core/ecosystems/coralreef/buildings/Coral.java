package core.ecosystems.coralreef.buildings;

import core.ecosystems.general.Building;
import core.setup.Images;

public class Coral extends Building {

    private boolean healthy;
    private int time;

    public Coral(boolean b) {
        name = "Coral";
        info = "help please";
        healthy = b;
        if (healthy) {
            myImage = Images.protesters;
        } else {
            myImage = Images.damagedCoral;
        }
        resizeImage();
    }

    @Override
    public void update() {
        super.update();
        time++;
        if (healthy && time % 120 == 0 && Math.random() < .1) {
            setIsHealthy(false);
        }
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setIsHealthy(boolean b) {
        healthy = b;
        if (healthy) {
            myImage = Images.protesters;
        } else {
            myImage = Images.damagedCoral;
        }
    }
}
