package core.ecosystems.city;

import core.ecosystems.Grid;
import core.ecosystems.Shop;
import org.newdawn.slick.GameContainer;

public class CityShop extends Shop {
    public CityShop(Grid g, GameContainer gc) {
        super(g, gc);
        setItems();
    }


}
