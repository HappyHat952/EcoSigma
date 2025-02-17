package core.ecosystems.coralreef;

import core.ecosystems.Grid;
import core.ecosystems.Shop;
import core.ecosystems.arctic.buildings.CO2Sucker;
import core.ecosystems.arctic.buildings.IcePump;
import core.ecosystems.arctic.buildings.Protesters;
import core.ecosystems.coralreef.buildings.BioRock;
import core.ecosystems.coralreef.buildings.CoralRobot;
import core.ecosystems.coralreef.buildings.SoundMaker;
import core.ecosystems.general.Item;
import org.newdawn.slick.GameContainer;

public class CoralReefShop extends Shop {
    public CoralReefShop(Grid g, GameContainer gc) {
        super(g, gc);
        setItems();
        money = 200;
    }

    public void setItems()
    {
        items.add(new Item(0, BioRock.class, new BioRock(), 1,this));
        items.add(new Item (1, CoralRobot.class, new CoralRobot(),2,this));
        items.add(new Item (2, SoundMaker.class, new SoundMaker(),3,this));
    }

    public void update(){
        // logic for tasks
    }
}
