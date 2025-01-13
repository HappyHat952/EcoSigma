package core.ecosystems.farm;

import core.ecosystems.Grid;
import core.ecosystems.Shop;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.arctic.buildings.IcePump;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.farm.animals.MonoCultureCrop;
import core.ecosystems.farm.animals.PluroCultureCrop;
import core.ecosystems.farm.buildings.GreenHouse;
import core.ecosystems.farm.buildings.WaterTank;
import core.ecosystems.general.Item;
import core.ecosystems.general.OrganismItem;
import org.newdawn.slick.GameContainer;

import java.util.ArrayList;

public class FarmShop extends Shop {
    Item greenHouseItem;
    Item waterTankItem;


    public FarmShop(Grid grid, GameContainer gc)
    {
        super(grid, gc);
        setItems();
    }

    @Override
    public void setOrganismItems(ArrayList<OrganismItem> organismItems) {
        super.setOrganismItems(organismItems);
        organismItems.add(new OrganismItem(1, MonoCultureCrop.class, grid ));
    }

    public void setItems()
    {
        greenHouseItem = new Item(0, GreenHouse.class, new GreenHouse(), 2, this);
        items.add(greenHouseItem);
        waterTankItem = (new Item (1, WaterTank.class, new WaterTank(),3,this));
        items.add(waterTankItem);
//        items.add(new Item (2, GreenHouse.class, new GreenHouse(),4));
    }

    public void update()
    {
        super.update();
        if (((FarmGrid)grid).getNumGreenHouses() == 4)
        {
            items.remove(greenHouseItem);
        }
        if (((FarmGrid) grid).getNumWateredCells() == 100)
        {
            items.remove(waterTankItem);
        }
    }

}
