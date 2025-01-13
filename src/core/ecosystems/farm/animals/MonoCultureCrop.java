package core.ecosystems.farm.animals;

import core.ecosystems.general.Cell;

public class MonoCultureCrop extends Crop {


    public MonoCultureCrop(Cell cell) {
        super(cell);
        growTime = 8;
        frame = 0;
        name = "monoculture";
        price = 2;
        // frame = (int)(Math.random()*sprite.getVerticalCount());
    }
}
