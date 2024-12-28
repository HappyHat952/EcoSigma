package core.ecosystems;

import core.Main;
import core.buttons.LabButton;
import core.ecosystems.general.Animal;
import core.ecosystems.general.Organism;
import core.ecosystems.general.Plant;
import core.ecosystems.tasks.Task;
import core.ecosystems.tasks.TaskManager;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

//manages everything regarding a single ecosystem - contains the shop, lab, and grid
abstract public class Ecosystem {
    protected Grid grid;
    protected Shop shop;
    protected LabButton lab;
    protected TaskManager taskManager;
    protected GameContainer gc;
    protected StateBasedGame sbg;
    protected PopupManager pu;

    public Ecosystem(GameContainer gc, StateBasedGame sbg, PopupManager pu) {
        grid = new Grid(gc);
        shop = new Shop(grid, gc);
        lab = new LabButton();
        taskManager = new TaskManager();
        this.gc = gc;
        this.sbg = sbg;
        this.pu = pu;
        pu.activate(0);
    }

    public void render(Graphics g) {
        grid.render(g);
        lab.render(g);
        shop.render(g);
        taskManager.render(g);
        g.drawString(toString(), 400,400);

    }

    public void update() {
        grid.update();
        shop.update();
        for (Task t : taskManager.getAllTasks()) {
            t.update();
        }
    }

    public void mousePressed(int x, int y) {
        shop.mousePressed(x, y);
        grid.mousePressed(x, y);
        if (lab.isMouseOver(x, y)) {
            pu.activate(1);
            sbg.enterState(Main.LAB_ID);
        }
    }

    public void addOrganism(Class<? extends Organism> organism)
    {
        grid.addOrganism(organism);
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }


    public Grid getGrid() {
        return grid;
    }
}
