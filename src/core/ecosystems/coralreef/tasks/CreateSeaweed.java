package core.ecosystems.coralreef.tasks;

import core.ecosystems.Grid;
import core.ecosystems.arctic.animals.Lemming;
import core.ecosystems.arctic.animals.PolarBear;
import core.ecosystems.arctic.animals.Walrus;
import core.ecosystems.coralreef.animals.Seaweed;
import core.ecosystems.general.Animal;
import core.ecosystems.general.Plant;
import core.ecosystems.tasks.Task;

import java.util.ArrayList;

public class CreateSeaweed extends Task {
    private int numPlants;
    private int totalPlants;

    public CreateSeaweed(String name, Grid grid)
    {
        super(name, grid);
        totalPlants = 3;
        numPlants = 0;
    }
    public int getPercentDone() {
        if (numPlants < 3) {
            return (int) ((numPlants / (float) totalPlants) * 100);
        } else {
            return 100;
        }
    }
    public void update()
    {
        ArrayList<Plant> plants = grid.getPlants();
        for (Plant p: plants)
        {
            if (p instanceof Seaweed)
            {
                numPlants++;
            }
        }
    }
}
