package core.ecosystems.coralreef;

import core.ecosystems.Grid;
import core.ecosystems.Shop;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.arctic.buildings.IcePump;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.general.Item;
import org.newdawn.slick.GameContainer;

public class CoralReefShop extends Shop {
    public CoralReefShop(Grid g, GameContainer gc) {
        super(g, gc);
        setItems();
    }

    public void setItems()
    {
        items.add(new Item(0, CO2Sucker.class, new CO2Sucker(), 2));
        items.add(new Item (1, IcePump.class, new IcePump(),3));
        items.add(new Item (2, Protesters.class, new Protesters(),4));
    }

    public void update(){
        // logic for tasks
    }
}
