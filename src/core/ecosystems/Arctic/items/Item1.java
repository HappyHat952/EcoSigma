package core.ecosystems.Arctic.items;

import core.ecosystems.Item;
import core.setup.Images;
import org.newdawn.slick.Image;

//rename later!
public class Item1 extends Item {
    public Item1(int i) {
        super(i);//the index of the item (left to right)
        name = "Item 1";
        image = Images.arcticMachine;
        info = "does stuff";
        cost = 1;

    }
}
