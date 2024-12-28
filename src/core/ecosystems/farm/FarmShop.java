package core.ecosystems.farm;

import core.ecosystems.Grid;
import core.ecosystems.Shop;
import org.newdawn.slick.GameContainer;

public class FarmShop extends Shop {

    public FarmShop(Grid grid, GameContainer gc)
    {
        super(grid, gc);
        setItems();
    }

}
