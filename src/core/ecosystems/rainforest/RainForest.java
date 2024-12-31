package core.ecosystems.rainforest;

import core.Main;
import core.ecosystems.Ecosystem;
import core.ecosystems.coralreef.CoralReefGrid;
import core.ecosystems.coralreef.CoralReefShop;
import core.ecosystems.coralreef.tasks.CreateCoral;
import core.ecosystems.coralreef.tasks.CreateSounds;
import core.ecosystems.coralreef.tasks.RepairCoral;
import core.ecosystems.rainforest.tasks.EnrichSoil;
import core.ecosystems.rainforest.tasks.ExtinguishFires;
import core.ecosystems.rainforest.tasks.HireRangers;
import core.setup.Fonts;
import core.ui.PopupManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class RainForest extends Ecosystem {

    private String danger;
    public static int ID;
    public RainForest(GameContainer gc, StateBasedGame sbg, PopupManager pu, int id) {
        super(gc, sbg, pu);
        ID = id;
        grid = new RainForestGrid(gc);
        shop = new RainForestShop(grid, gc);
        taskManager.addTask(new EnrichSoil("Enrich Soil", grid));
        taskManager.addTask(new ExtinguishFires("Extinguish Fires", grid));
        taskManager.addTask(new HireRangers("Hire Rangers", grid));
        danger = "High";
        //shop = new RainForestShop(grid, gc);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setFont(Fonts.medium);
        g.setColor(Color.black);
        g.drawString("Danger Levels: " + danger, (float) Main.getScreenWidth() /2, 5);
    }
}
