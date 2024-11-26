package core.ecosystems;

import core.Main;
import core.ecosystems.Arctic.tasks.ClearedCO2;
import core.ecosystems.tasks.Task;
import core.ecosystems.tasks.TaskManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

//manages everything regarding a single ecosystem - contains the shop, lab, and grid
abstract public class Ecosystem {
    protected Grid grid;
    protected Shop shop;
    protected LabButton lab;
    protected TaskManager taskManager;
    protected GameContainer gc ;
    protected StateBasedGame sbg;

    public Ecosystem(GameContainer gc, StateBasedGame sbg){
        grid = new Grid(gc);
        shop = new Shop(grid, gc);
        lab = new LabButton();
        taskManager = new TaskManager();
        this.gc =gc;
        this.sbg = sbg;
    }

    public void render(Graphics g){
        grid.render(g);
        lab.render(g);
        shop.render(g);
        taskManager.render(g);
    }

    public void update()
    {
        grid.update();
        shop.update();
        for (Task t: taskManager.getAllTasks()) {
            t.update();
        }
    }

    public void mousePressed(int x, int y)
    {
        shop.mousePressed(x,y);
        grid.mousePressed(x,y);
        if(lab.isMouseOver(x,y))
        {
            sbg.enterState(Main.LAB_ID);
        }
    }
}
