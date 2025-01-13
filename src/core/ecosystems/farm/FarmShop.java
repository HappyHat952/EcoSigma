package core.ecosystems.farm;

import core.ecosystems.Grid;
import core.ecosystems.Shop;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.arctic.buildings.IcePump;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.farm.animals.PluroCultureCrop;
import core.ecosystems.farm.buildings.GreenHouse;
import core.ecosystems.farm.buildings.WaterTank;
import core.ecosystems.general.Item;
import core.ecosystems.general.OrganismItem;
import org.newdawn.slick.GameContainer;

public class FarmShop extends Shop {
    Item greenHouseItem;


    public FarmShop(Grid grid, GameContainer gc)
    {
        super(grid, gc);
        setItems();
    }


    public void setItems()
    {
        greenHouseItem = new Item(0, GreenHouse.class, new GreenHouse(), 2);
        items.add(greenHouseItem);
        items.add(new Item (1, WaterTank.class, new WaterTank(),3));
//        items.add(new Item (2, GreenHouse.class, new GreenHouse(),4));
    }

    public void update()
    {
        super.update();
        if (((FarmGrid)grid).getNumGreenHouses() == 4)
        {
            items.remove(greenHouseItem);
        }
    }

}
