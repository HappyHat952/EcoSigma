package core.ecosystems.Arctic.tasks;

import core.ecosystems.Animal;
import core.ecosystems.Arctic.animals.Lemming;
import core.ecosystems.Arctic.animals.PolarBear;
import core.ecosystems.Arctic.animals.Walrus;
import core.ecosystems.Grid;
import core.ecosystems.tasks.Task;

import java.util.ArrayList;

public class CreateAnimals extends Task {
    private int numAnimals;
    private int totalAnimals;

    public CreateAnimals(String name, Grid grid)
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
        int polarCount=0;
        int lemmingCount=0;
        int walrusCount=0;
        ArrayList<Animal> animals = grid.getAnimals();
        for (Animal a: animals)
        {
            if (a instanceof PolarBear && polarCount == 0)
            {
                polarCount++;
            }
            else if (a instanceof Lemming && lemmingCount == 0)
            {
                lemmingCount++;
            }
            else if (a instanceof Walrus && walrusCount == 0)
            {
                walrusCount++;
            }
        }
        numAnimals = polarCount + lemmingCount+walrusCount;
    }
}
