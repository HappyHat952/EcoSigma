package core.ecosystems.rainforest;

import core.ecosystems.Grid;
import core.ecosystems.Shop;
import core.ecosystems.coralreef.buildings.BioRock;
import core.ecosystems.coralreef.buildings.CoralRobot;
import core.ecosystems.coralreef.buildings.SoundMaker;
import core.ecosystems.general.Item;
import org.newdawn.slick.GameContainer;

public class RainForestShop extends Shop {
    public RainForestShop(Grid g, GameContainer gc) {
        super(g, gc);
        setItems();
    }

    public void setItems()
    {
        items.add(new Item(0, BioRock.class, new BioRock(), 2));
        items.add(new Item (1, CoralRobot.class, new CoralRobot(),3));
        items.add(new Item (2, SoundMaker.class, new SoundMaker(),4));
    }

    public void update(){
        // logic for tasks
    }
}
