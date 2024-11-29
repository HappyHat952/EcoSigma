package core.ecosystems.Arctic.tasks;

import core.ecosystems.Animal;
import core.ecosystems.Arctic.animals.Lemming;
import core.ecosystems.Arctic.animals.PolarBear;
import core.ecosystems.Arctic.animals.Walrus;
import core.ecosystems.Grid;
import core.ecosystems.Plant;
import core.ecosystems.tasks.Task;

import java.util.ArrayList;

public class Plant4Plants extends Task {
    private int numPlants;
    private int totalPlants;

    public Plant4Plants(String name, Grid grid)
    {
        super(name, grid);
        totalPlants = 4;
        numPlants = 0;
    }
    public int getPercentDone() {
        if (numPlants < 4) {
            return (int) ((numPlants / (float) totalPlants) * 100);
        } else {
            return 100;
        }
    }
    public void update()
    {
        ArrayList<Plant> plants = grid.getPlants();
        numPlants = plants.size();
    }
}
