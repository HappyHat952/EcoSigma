package core.ecosystems.Arctic.animals;

import core.ecosystems.Animal;
import core.ecosystems.Cell;
import core.setup.Images;

public class Walrus extends Animal {
    public Walrus(Cell cell) {
        super(cell);
        sprite = Images.walrus;
    }
}
