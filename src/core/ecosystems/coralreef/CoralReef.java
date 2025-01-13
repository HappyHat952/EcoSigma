package core.ecosystems.coralreef;

import core.ecosystems.Ecosystem;
import core.ecosystems.coralreef.tasks.*;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CoralReef extends Ecosystem {

    public static int ID;

    public CoralReef(GameContainer gc, StateBasedGame sbg, PopupManager pu, int id) {
        super(gc, sbg, pu);
        ID = id;
        grid = new CoralReefGrid(gc);
        shop = new CoralReefShop(grid, gc);
        taskManager.addTask(new CreateSounds("Introduce Sounds", grid));
        taskManager.addTask(new CreateCoral("Create New Coral Structures", grid));
        taskManager.addTask(new RepairCoral("Repair Damaged Coral", grid));
        taskManager.addTask(new CreateReefAnimals("Create All 3 Animals", grid));
        taskManager.addTask(new CreateSeaweed("Plant 3 Seaweed", grid));

    }


}
