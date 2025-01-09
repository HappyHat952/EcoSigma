package core.ecosystems.coralreef.animals;

import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class Stingray extends Animal {
    public Stingray(Cell cell) {
        super(cell);
        sprite = Images.stingray;
        name = "stingray";
    }
}
