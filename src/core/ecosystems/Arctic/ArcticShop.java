package core.ecosystems.Arctic;

import core.ecosystems.Arctic.items.Item1;
import core.ecosystems.Arctic.items.Item2;
import core.ecosystems.Arctic.items.Item3;
import core.ecosystems.Grid;
import core.ecosystems.Shop;

public class ArcticShop extends Shop {

    public ArcticShop(Grid grid)
    {
        super(grid);
        setItems();
    }

    //MUTATOR
    //setting the items for a specific class
    public void setItems()
    {
        items.add(new Item1(0));
        items.add(new Item2(1));
        items.add(new Item3(2));
    }
}
