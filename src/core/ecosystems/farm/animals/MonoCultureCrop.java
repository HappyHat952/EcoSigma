package core.ecosystems.farm.animals;

import core.ecosystems.general.Cell;

public class MonoCultureCrop extends Crop {


    public MonoCultureCrop(Cell cell) {
        super(cell);
        growTime = 5;
        frame = (int)(Math.random()*sprite.getVerticalCount());
    }
}
