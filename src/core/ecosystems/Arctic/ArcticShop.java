package core.ecosystems.Arctic;

import core.ecosystems.Arctic.buildings.CO2Sucker;
import core.ecosystems.Arctic.buildings.IcePump;
import core.ecosystems.Arctic.buildings.Protestors;
import core.ecosystems.Grid;
import core.ecosystems.Item;
import core.ecosystems.Shop;
import org.newdawn.slick.GameContainer;

public class ArcticShop extends Shop {

    public ArcticShop(Grid grid, GameContainer gc)
    {
        super(grid, gc);
        setItems();
    }

    //MUTATOR
    //setting the items for a specific class
    public void setItems()
    {
        items.add(new Item(0, CO2Sucker.class, new CO2Sucker()));
        items.add(new Item (1, IcePump.class, new IcePump()));
        items.add(new Item (2, Protestors.class, new Protestors()));
    }
}
