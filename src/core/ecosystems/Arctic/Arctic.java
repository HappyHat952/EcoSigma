package core.ecosystems.Arctic;

import core.ecosystems.Arctic.tasks.ClearedCO2;
import core.ecosystems.Ecosystem;
import core.ecosystems.Shop;
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
        clouds.add(new Cloud());
    }

    public void render(Graphics g) {
        super.render(g);
        for (int i = 0; i < clouds.size(); i++) {
            clouds.get(i).render(g);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        super.mousePressed(x, y);
        for (int i = 0; i < clouds.size(); i++) {
            if (clouds.get(i).mouseOver(x, y)) {

            }
        }
    }

    public static ArrayList<Cloud> getClouds() {
        return clouds;
    }
}
