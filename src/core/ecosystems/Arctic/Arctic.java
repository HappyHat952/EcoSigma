package core.ecosystems.Arctic;

import core.ecosystems.Arctic.tasks.ClearedCO2;
import core.ecosystems.Ecosystem;
import core.ecosystems.Shop;
import core.ecosystems.tasks.Task;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class Arctic extends Ecosystem {

    private static ArrayList<Cloud> clouds;

    public Arctic()
    {
        super();
        grid = new ArcticGrid();
        shop = new ArcticShop(grid);
        taskManager.addTask(new ClearedCO2("Clear CO2 Emissions"));
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
        for (Cloud c: clouds) {
            if (c.mouseOver(x, y)) {
                c.delete();
            }
        }
    }

    public static ArrayList<Cloud> getClouds() {
        return clouds;
    }
}
