package core.ecosystems.arctic.animals;

import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class PolarBear extends Animal {
    public PolarBear(Cell cell) {
        super(cell);
        sprite = Images.polarBear;
        name = "Polar Bear";
        costOfGenome = 120;
    }
}
