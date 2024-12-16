package core.ecosystems.coralreef.animals;

import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class Turtle extends Animal {
    public Turtle(Cell cell) {
        super(cell);
        sprite = Images.lemming;
    }
}
