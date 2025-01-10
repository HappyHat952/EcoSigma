package core.ecosystems.coralreef.animals;

import core.ecosystems.general.Animal;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class JellyFish extends Animal {
    public JellyFish(Cell cell) {
        super(cell);
        sprite = Images.jellyFish;
        name = "jellyfish";
    }
}
