package core.ecosystems.farm;

import core.ecosystems.Grid;
import core.ecosystems.Shop;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.arctic.buildings.IcePump;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.farm.buildings.GreenHouse;
import core.ecosystems.general.Item;
import org.newdawn.slick.GameContainer;

public class FarmShop extends Shop {

    public FarmShop(Grid grid, GameContainer gc)
    {
        super(grid, gc);
        setItems();
    }

    public void setItems()
    {
        items.add(new Item(0, GreenHouse.class, new GreenHouse(), 2));
        items.add(new Item (1, GreenHouse.class, new GreenHouse(),3));
        items.add(new Item (2, GreenHouse.class, new GreenHouse(),4));
    }

}
