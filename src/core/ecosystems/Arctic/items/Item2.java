package core.ecosystems.Arctic.items;

import core.ecosystems.Item;
import core.setup.Images;

public class Item2 extends Item {

    public Item2(int i) {
        super(i);//the index of the item (left to right)
        name = "Item 2";
        image = Images.arcticMachine;
        info = "does stuff";
        cost = 2;

    }
}
