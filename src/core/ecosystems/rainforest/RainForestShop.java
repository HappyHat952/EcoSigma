package core.ecosystems.rainforest;

import core.ecosystems.Grid;
import core.ecosystems.Shop;
import core.ecosystems.coralreef.buildings.BioRock;
import core.ecosystems.coralreef.buildings.CoralRobot;
import core.ecosystems.coralreef.buildings.SoundMaker;
import core.ecosystems.general.Item;
import core.ecosystems.rainforest.buildings.FireDrone;
import core.ecosystems.rainforest.buildings.Ranger;
import core.ecosystems.rainforest.buildings.SoilEnrichmentMachine;
import org.newdawn.slick.GameContainer;

public class RainForestShop extends Shop {
    public RainForestShop(Grid g, GameContainer gc) {
        super(g, gc);
        setItems();
        money = 350;
    }

    public void setItems()
    {
        items.add(new Item(0, FireDrone.class, new FireDrone(), 3,this));
        items.add(new Item (1, SoilEnrichmentMachine.class, new SoilEnrichmentMachine(),2,this));
        items.add(new Item (2, Ranger.class, new Ranger(),1,this));
    }

    public void update(){
        // logic for tasks
    }
}
