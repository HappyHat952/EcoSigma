package core.ecosystems.arctic.animals;

import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class Lemming extends Animal {
    public Lemming(Cell cell) {
        super(cell);
        sprite = Images.lemming;
        name = "Lemming";
    }
}
