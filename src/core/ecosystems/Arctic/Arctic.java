package core.ecosystems.Arctic;

import core.ecosystems.Ecosystem;
import core.ecosystems.Shop;

public class Arctic extends Ecosystem {

    public Arctic()
    {
        super();
        grid = new ArcticGrid();
        shop = new ArcticShop(grid);
    }
}
