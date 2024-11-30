package core.ecosystems.Arctic;

import core.ecosystems.Arctic.tasks.*;
import core.ecosystems.Ecosystem;
import core.ecosystems.Shop;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import core.ecosystems.tasks.Task;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Arctic extends Ecosystem {

    private static ArrayList<Cloud> clouds;

    public Arctic(GameContainer gc, StateBasedGame sbg, PopupManager pu)
    {
        super(gc, sbg, pu);
        grid = new ArcticGrid(gc);
        shop = new ArcticShop(grid, gc);
        taskManager.addTask(new ClearedCO2("Clear CO2 Emissions", grid));
        taskManager.addTask(new CreatedIce("Create Ice", grid));
        taskManager.addTask(new DestroyedOilDrills("Ban Oil Drills", grid));
        taskManager.addTask(new CreateAnimals("Create all three Animals", grid));
        taskManager.addTask(new Plant4Plants("Plant four plants", grid));
        clouds = new ArrayList<>();
        for (int i = 0; i < ClearedCO2.getTotalClouds(); i++) {
            clouds.add(new Cloud());
        }
    }

    public void render(Graphics g) {
        super.render(g);
        for (Cloud c: clouds) {
            c.render(g);
        }
    }

    public void update() {
        super.update();
        for (Cloud c: clouds) {
            c.update();
        }

    }

    @Override
    public void mousePressed(int x, int y) {
        super.mousePressed(x, y);
    }

    public static ArrayList<Cloud> getClouds() {
        return clouds;
    }
}
