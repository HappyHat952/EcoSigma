package core.ecosystems.coralreef;

import core.ecosystems.Ecosystem;
import core.ecosystems.coralreef.tasks.CreateCoral;
import core.ecosystems.coralreef.tasks.CreateSounds;
import core.ecosystems.coralreef.tasks.RepairCoral;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import static core.ecosystems.lab.Lab.setAvailableAnimals;

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

    }


}
