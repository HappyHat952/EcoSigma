package core.ecosystems.farm;

import core.ecosystems.Ecosystem;
import core.ecosystems.farm.tasks.AddedGreenhouse;
import core.ecosystems.farm.tasks.PlantTenVariedPlants;
import core.ecosystems.farm.tasks.RemoveMonocultures;
import core.ecosystems.farm.tasks.WaterAllPlants;
import core.setup.PopupLoader;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class Farm extends Ecosystem {
    public static int ID;
    public Farm(GameContainer gc, StateBasedGame sbg, PopupManager pu, int id) {
        super(gc, sbg, pu);
        ID = id;
        grid = new FarmGrid(gc);
        shop = new FarmShop(grid,gc);
        grid.addShop(shop);
        PopupLoader.loadPopups(ID);
        pu.activate(0);
        //add new tasks
        taskManager.addTask(new AddedGreenhouse("Add four Greenhouses", grid) );
        taskManager.addTask(new PlantTenVariedPlants("Add ten bio-diverse plants", grid));
        taskManager.addTask(new RemoveMonocultures("remove 20 monoculture plants", grid));
        taskManager.addTask(new WaterAllPlants("Place WaterTanks and irrigation pipes", grid));
    }

}
