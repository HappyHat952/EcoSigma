package core.ecosystems.rainforest.animals;

import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class Parrot extends Animal {

    public Parrot(Cell cell) {
        super(cell);
        sprite = Images.parrot;
        name = "parrot";
        costOfGenome = 25;
    }
}
