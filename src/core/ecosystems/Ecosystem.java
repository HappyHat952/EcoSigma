package core.ecosystems;

import core.ecosystems.tasks.TaskManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

//manages everything regarding a single ecosystem - contains the shop, lab, and grid
abstract public class Ecosystem {
    protected Grid grid;
    protected Shop shop;
    protected TaskManager taskManager;

    public Ecosystem(){
        grid = new Grid();
        shop = new Shop(grid);
        taskManager = new TaskManager();
        taskManager.addTask("Do stuff");
        taskManager.addTask("Do stuff");
        taskManager.addTask("Do stuff");
        taskManager.addTask("Do stuff");
//        shop.setItems();
    }

    public void render(Graphics g){
        grid.render(g);
        shop.render(g);
        taskManager.render(g);
    }

    public void update()
    {
        grid.update();
        shop.update();
    }

    public void mousePressed(int x, int y)
    {
        shop.mousePressed(x,y);
        grid.mousePressed(x,y);
    }
}
