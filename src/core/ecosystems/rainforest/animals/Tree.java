package core.ecosystems.rainforest.animals;

import core.ecosystems.general.Cell;
import core.ecosystems.general.Plant;
import core.setup.Images;

public class Tree extends Plant {
    public Tree(Cell cell) {
        super(cell);
        growTime = 1;
        image = Images.plant;
    }
}
