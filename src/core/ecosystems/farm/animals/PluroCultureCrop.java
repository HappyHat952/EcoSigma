package core.ecosystems.farm.animals;

import core.ecosystems.general.Cell;
import core.setup.Images;

public class PluroCultureCrop extends Crop{

    public PluroCultureCrop(Cell cell) {
        super(cell);
        growTime = 4;
        sprite = Images.plant;
        //sprite.setImageColor(1f, (float)(Math.random()),(float)( Math.random()));
        name = "pluroculture";
        price = 6;
        costOfGenome = 100;

    }
}
