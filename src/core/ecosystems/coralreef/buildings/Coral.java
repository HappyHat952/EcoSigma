package core.ecosystems.coralreef.buildings;

import core.ecosystems.general.Building;
import core.setup.Images;

public class Coral extends Building {

    private int health;
    private final int MAX_HEALTH = 5;

    public Coral() {
        myImage = Images.damagedCoral;
        name = "Coral";
        info = "help please";
        resizeImage();
        health = 1;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void addHealth(int i) {
        if (i > 0 && health < MAX_HEALTH) {
            health =+ i;
        }
    }


}
