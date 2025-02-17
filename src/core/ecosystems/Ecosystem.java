package core.ecosystems;

import core.Game;
import core.Main;
import core.buttons.Button;
import core.buttons.LabButton;
import core.ecosystems.general.Building;
import core.ecosystems.general.Organism;
import core.ecosystems.general.OrganismItem;
import core.ecosystems.tasks.Task;
import core.ecosystems.tasks.TaskManager;
import core.setup.Fonts;
import core.setup.Images;
import core.ui.PopupManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;
import core.lab.Lab;

import java.util.ArrayList;

//manages everything regarding a single ecosystem - contains the shop, lab1, and grid
abstract public class Ecosystem {
    protected Grid grid;
    protected Shop shop;
    protected LabButton lab;
    protected TaskManager taskManager;
    protected GameContainer gc;
    protected StateBasedGame sbg;
    protected PopupManager pu;
    protected boolean isCompleted;
    protected boolean hasBeenOpened;
    protected Image winImage;
    protected Button reset;
    protected Button home;
    protected int id;

    public Ecosystem(GameContainer gc, StateBasedGame sbg, PopupManager pu) {
        grid = new Grid(gc);
        //shop = new Shop(grid, gc);
        lab = new LabButton();
        taskManager = new TaskManager();
      //  buildings = new ArrayList<>();
        this.gc = gc;
        this.sbg = sbg;
        this.pu = pu;
        // REPLACE WITH FILE READING
        isCompleted = false;
        hasBeenOpened = false;
        //pu.activate(0);
        winImage = Images.win;
        reset = new Button(Grid.getGridWidth() + (int)(Main.getScreenWidth()*.3f),(int)(Main.getScreenHeight()*.55f),70,70, Color.green,"reset");
        home =  new Button(Grid.getGridWidth() + (int)(Main.getScreenWidth()*.26f),(int)(Main.getScreenHeight()*.55f),70,70, Color.blue,"home");

    }

    public Shop getShop(){
        return shop;
    }
    public void setOrganismItems(ArrayList<Class<? extends Organism>> list)
    {
        ArrayList<OrganismItem> organismItems = new ArrayList<>();
        int i =0;
        for (Class clazz: list)
        {
            organismItems.add(new OrganismItem(i, clazz, grid));
            i++;
        }
        shop.setOrganismItems(organismItems);
    }

    public void render(Graphics g) {
        grid.render(g);
        lab.render(g);
        shop.render(g);
        taskManager.render(g);
        if (isCompleted) {
            g.setFont(Fonts.big);
            g.drawImage(winImage.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight()),0,0);
        }
        reset.render(g);
        home.render(g);

    }

    public void update() {
        grid.update();
        shop.update();
        for (Task t : taskManager.getAllTasks()) {
            t.update();
            t.getMoney(shop);
        }
        if (!isCompleted && taskManager.getCurrentProgress() == 1) {
            isCompleted = true;
        }
    }

    public void mousePressed(int x, int y, int button) {
        shop.mousePressed(x, y);
        grid.mousePressed(x, y, button);
        if (lab.isMouseOver(x, y)) {
            sbg.enterState(Main.LAB_ID);
        }
        if (reset.isMouseOver(x,y))
        {
            Game.reset(id);
        }
        if (home.isMouseOver(x,y))
        {
            sbg.enterState(Main.MAP_ID);
        }
    }

    public void addOrganism(Class<? extends Organism> organism)
    {
       // grid.addOrganism(organism);
        shop.addOrganism(organism);
    }



    public TaskManager getTaskManager() {
        return taskManager;
    }


    public Grid getGrid() {
        return grid;
    }

    public void setCompleted(boolean b) {
        isCompleted = b;
    }

    public boolean isCompleted() {
        return isCompleted;
    }


    //if opened, sets first open to true
    public void setFirstOpen(){
        PopupManager.activate(0);
//        if (!hasBeenOpened)
//        {
//            PopupManager.activate(0);
//        }
//        hasBeenOpened = true;
    }
}
