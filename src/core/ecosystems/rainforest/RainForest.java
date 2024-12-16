package core.ecosystems.rainforest;

import core.ecosystems.Ecosystem;
import core.ecosystems.coralreef.CoralReefGrid;
import core.ecosystems.coralreef.CoralReefShop;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class RainForest extends Ecosystem {
    public RainForest(GameContainer gc, StateBasedGame sbg, PopupManager pu) {
        super(gc, sbg, pu);
        grid = new RainForestGrid(gc);
        //shop = new RainForestShop(grid, gc);
    }
}
