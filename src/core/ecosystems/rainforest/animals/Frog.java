package core.ecosystems.rainforest.animals;

import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class Frog extends Animal {

    public Frog(Cell cell) {
        super(cell);
        sprite = Images.frog;
        name = "frog";
    }
}
