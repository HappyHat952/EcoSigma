package core.ecosystems.coralreef.tasks;

import core.ecosystems.Grid;
import core.ecosystems.coralreef.animals.Clownfish;
import core.ecosystems.coralreef.animals.JellyFish;
import core.ecosystems.coralreef.animals.Stingray;
import core.ecosystems.general.Animal;
import core.ecosystems.tasks.Task;

import java.util.ArrayList;

public class CreateReefAnimals extends Task {
    private int numAnimals;
    private int totalAnimals;

    public CreateReefAnimals(String name, Grid grid)
    {
        super(name, grid);
        totalAnimals = 3;
        numAnimals = 0;
    }
    public int getPercentDone() {
        if (numAnimals <= 3) {
            return (int) ((numAnimals / (float) totalAnimals) * 100);
        } else {
            return 100;
        }
    }
    public void update()
    {
        int clownCount=0;
        int jellyCount=0;
        int stingCount=0;
        ArrayList<Animal> animals = grid.getAnimals();
        for (Animal a: animals)
        {
            if (a instanceof Clownfish && clownCount == 0)
            {
                clownCount++;
            }
            else if (a instanceof JellyFish && jellyCount == 0)
            {
                jellyCount++;
            }
            else if (a instanceof Stingray && stingCount == 0)
            {
                stingCount++;
            }
        }
        numAnimals = clownCount + jellyCount + stingCount;
    }
}
