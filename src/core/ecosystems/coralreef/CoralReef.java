package core.ecosystems.coralreef;

import core.ecosystems.Ecosystem;
import core.ecosystems.arctic.ArcticGrid;
import core.ecosystems.arctic.ArcticShop;
import core.ecosystems.arctic.tasks.ClearedCO2;
import core.ecosystems.coralreef.tasks.CreateCoral;
import core.ecosystems.coralreef.tasks.CreateSounds;
import core.ecosystems.coralreef.tasks.RepairCoral;
import core.ecosystems.lab.Lab;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import static core.ecosystems.lab.Lab.setAvailableAnimals;

public class CoralReef extends Ecosystem {

    public CoralReef(GameContainer gc, StateBasedGame sbg, PopupManager pu) {
        super(gc, sbg, pu);
        grid = new CoralReefGrid(gc);
        shop = new CoralReefShop(grid, gc);
        taskManager.addTask(new CreateSounds("Introduce Sounds", grid));
        taskManager.addTask(new CreateCoral("Create New Coral Structures", grid));
        taskManager.addTask(new RepairCoral("Repair Damaged Coral", grid));

    }


}
