package core.ecosystems.farm.animals;

import core.ecosystems.general.Cell;
import core.setup.Images;

public class PluroCultureCrop extends Crop{

    public PluroCultureCrop(Cell cell) {
        super(cell);
        sprite = Images.plant;
        sprite.setImageColor((float)(Math.random()), (float)(Math.random()),(float)( Math.random()*1f));
        name = "PluroCultureCrop";

    }
}
