package core.ecosystems.Arctic.animals;

import core.ecosystems.Animal;
import core.ecosystems.Cell;
import core.setup.Images;

public class PolarBear extends Animal {
    public PolarBear(Cell cell) {
        super(cell);
        sprite = Images.polarBear;
    }
}
