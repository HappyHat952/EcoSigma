package core.ecosystems.city;

import core.ecosystems.Ecosystem;
import core.ecosystems.farm.FarmGrid;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class City extends Ecosystem{
    public City(GameContainer gc, StateBasedGame sbg, PopupManager pu) {
        super(gc, sbg, pu);
        grid = new CityGrid(gc);
        shop = new CityShop(grid, gc);

        //add tasks in future


    }
}
