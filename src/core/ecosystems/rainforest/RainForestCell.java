package core.ecosystems.rainforest;

import core.ecosystems.general.Cell;
import core.setup.Images;
import org.newdawn.slick.Color;

public class RainForestCell extends Cell {

    private boolean isHealthy;
    public RainForestCell(int r, int c) {
        super(r, c);
        myColor = new Color(3, 92, 26);
        isHealthy = false;
        myImage = Images.unhealthySoil;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
        if (isHealthy) {
            myImage = Images.healthySoil;
        } else {
            myImage = Images.unhealthySoil;
        }
    }

    public boolean isHealthy() {
        return isHealthy;
    }


}
