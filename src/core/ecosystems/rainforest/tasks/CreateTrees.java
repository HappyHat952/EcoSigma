package core.ecosystems.rainforest.tasks;

import core.ecosystems.Grid;
import core.ecosystems.coralreef.animals.Seaweed;
import core.ecosystems.general.Plant;
import core.ecosystems.rainforest.animals.Tree;
import core.ecosystems.tasks.Task;

import java.util.ArrayList;

public class CreateTrees extends Task {
    private int numPlants;
    private int totalPlants;

    public CreateTrees(String name, Grid grid)
    {
        super(name, grid);
        totalPlants = 5;
        numPlants = 0;
    }
    public int getPercentDone() {
        if (numPlants < 5) {
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
            if (p instanceof Tree)
            {
                numPlants++;
            }
        }
    }
}
