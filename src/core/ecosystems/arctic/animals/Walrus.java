package core.ecosystems.arctic.animals;

import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class Walrus extends Animal {
    public Walrus(Cell cell) {
        super(cell);
        sprite = Images.walrus;
        name = "Walrus";
    }
}
