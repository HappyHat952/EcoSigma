package core.ecosystems.coralreef.animals;

import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class Clownfish extends Animal {
    public Clownfish(Cell cell) {
        super(cell);
        sprite = Images.clownfish;
        name = "clownfish";
        costOfGenome = 25;
    }
}
