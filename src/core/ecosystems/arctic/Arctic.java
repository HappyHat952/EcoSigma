package core.ecosystems.arctic;

import core.ecosystems.arctic.animals.PolarBear;
import core.ecosystems.arctic.tasks.*;
import core.ecosystems.Ecosystem;
import core.setup.PopupLoader;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Arctic extends Ecosystem {

    private static ArrayList<Cloud> clouds;
    public static int ID;

    public Arctic(GameContainer gc, StateBasedGame sbg, PopupManager pu, int id)
    {
        super(gc, sbg, pu);
        ID = id;
        grid = new ArcticGrid(gc);
        shop = new ArcticShop(grid, gc);
        taskManager.addTask(new ClearedCO2("Clear CO2 Emissions", grid));
        taskManager.addTask(new CreatedIce("Create Ice", grid));
        taskManager.addTask(new DestroyedOilDrills("Ban Oil Drills", grid));
        taskManager.addTask(new CreateAnimals("Create All 3 Animals", grid));
        taskManager.addTask(new Plant4Plants("Plant Four Plants", grid));
        clouds = new ArrayList<>();
        for (int i = 0; i < ClearedCO2.getTotalClouds(); i++) {
            clouds.add(new Cloud());
        }
        addOrganism(PolarBear.class);
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
    public void mousePressed(int x, int y, int button) {
        super.mousePressed(x, y, button);
    }

    public static ArrayList<Cloud> getClouds() {
        return clouds;
    }
}
