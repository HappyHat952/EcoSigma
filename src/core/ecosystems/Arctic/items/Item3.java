package core.ecosystems.Arctic.items;

import core.ecosystems.Item;
import core.setup.Images;

public class Item3 extends Item {

    public Item3(int i) {
        super(i);//the index of the item (left to right)
        name = "Item 3";
        image = Images.arcticMachine;
        info = "does stuff";
        cost = 3;

    }
}
