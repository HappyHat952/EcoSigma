package core.ecosystems.Arctic.animals;

import core.ecosystems.Animal;
import core.ecosystems.Cell;
import core.setup.Images;

public class Lemming extends Animal {
    public Lemming(Cell cell) {
        super(cell);
        sprite = Images.lemming;
    }
}
