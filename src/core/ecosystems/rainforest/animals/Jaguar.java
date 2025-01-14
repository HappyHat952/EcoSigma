package core.ecosystems.rainforest.animals;

import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class Jaguar extends Animal {

    public Jaguar(Cell cell) {
        super(cell);
        sprite = Images.jaguar;
        name = "jaguar";
        costOfGenome = 25;
    }
}
