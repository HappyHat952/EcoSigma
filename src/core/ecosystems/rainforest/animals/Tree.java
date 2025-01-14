package core.ecosystems.rainforest.animals;

import core.ecosystems.general.Cell;
import core.ecosystems.general.Plant;
import core.ecosystems.rainforest.RainForestCell;
import core.setup.Images;

public class Tree extends Plant {
    public Tree(Cell cell) {
        super(cell);
        setSprite(Images.tree);
        name = "Tree";
        costOfGenome = 25;
    }

    public boolean isValid(Cell c )
    {
        if (((RainForestCell) c).isHealthy()) {
            return true;
        } else {
            return false;
        }
        // lkajsdlkfjalskdfj
    }
}
