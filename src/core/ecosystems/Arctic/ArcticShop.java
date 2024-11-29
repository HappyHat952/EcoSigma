package core.ecosystems.Arctic;

import core.ecosystems.Arctic.buildings.CO2Sucker;
import core.ecosystems.Arctic.buildings.IcePump;
import core.ecosystems.Arctic.buildings.Protesters;
import core.ecosystems.Arctic.tasks.ClearedCO2;
import core.ecosystems.Arctic.tasks.DestroyedOilDrills;
import core.ecosystems.Game;
import core.ecosystems.Grid;
import core.ecosystems.Item;
import core.ecosystems.Shop;
import core.ecosystems.tasks.Task;
import org.newdawn.slick.GameContainer;

public class ArcticShop extends Shop {

    public ArcticShop(Grid grid, GameContainer gc)
    {
        super(grid, gc);
        setItems();
    }

    //MUTATOR
    //setting the items for a specific class
    public void setItems()
    {
        items.add(new Item(0, CO2Sucker.class, new CO2Sucker()));
        items.add(new Item (1, IcePump.class, new IcePump()));
        items.add(new Item (2, Protesters.class, new Protesters()));
    }

    public void update() {
        for (Task t : Game.getCurrentLevel().getTaskManager().getAllTasks()) {
            if (t.isComplete()) {
                if (t instanceof ClearedCO2) {
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).getBuildingObject() instanceof CO2Sucker) {
                            items.remove(i);
                            i--;
                        }
                    }
                } else if (t instanceof DestroyedOilDrills) {
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).getBuildingObject() instanceof Protesters) {
                            items.remove(i);
                            i--;
                        }
                    }
                }
            }
        }
    }
}
