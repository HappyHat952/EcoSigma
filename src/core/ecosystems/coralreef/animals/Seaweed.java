package core.ecosystems.coralreef.animals;

import core.ecosystems.general.Cell;
import core.ecosystems.general.Plant;
import core.setup.Images;

public class Seaweed extends Plant {
    public Seaweed(Cell cell) {
        super(cell);
        sprite = Images.seaweed;
        name = "seaweed";
    }
}
