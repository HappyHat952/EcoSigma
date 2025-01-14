package core.ecosystems.arctic.animals;

import core.ecosystems.general.Cell;
import core.ecosystems.general.Plant;
import core.setup.Images;

public class CompionMoss extends Plant {

    public CompionMoss(Cell cell) {
        super(cell);
        setSprite(Images.compionMoss);
        name = "compion moss";
        costOfGenome = 20;
    }
}
