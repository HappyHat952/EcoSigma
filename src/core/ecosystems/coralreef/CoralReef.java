package core.ecosystems.coralreef;

import core.ecosystems.Ecosystem;
import core.ecosystems.arctic.ArcticGrid;
import core.ecosystems.arctic.ArcticShop;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CoralReef extends Ecosystem {

    public CoralReef(GameContainer gc, StateBasedGame sbg, PopupManager pu) {
        super(gc, sbg, pu);
        grid = new CoralReefGrid(gc);
        shop = new CoralReefShop(grid, gc);
    }
}
