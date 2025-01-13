package core.ecosystems.rainforest.tasks;

import core.ecosystems.Grid;
import core.ecosystems.general.Animal;
import core.ecosystems.rainforest.animals.Frog;
import core.ecosystems.rainforest.animals.Jaguar;
import core.ecosystems.rainforest.animals.Parrot;
import core.ecosystems.tasks.Task;

import java.util.ArrayList;

public class CreateAllAnimals extends Task {

    private int numAnimals;
    private int totalAnimals;

    public CreateAllAnimals(String name, Grid grid)
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
        int jaguarCount=0;
        int frogCount=0;
        int parrotCount=0;
        ArrayList<Animal> animals = grid.getAnimals();
        for (Animal a: animals)
        {
            if (a instanceof Jaguar && jaguarCount == 0)
            {
                jaguarCount++;
            }
            else if (a instanceof Frog && frogCount == 0)
            {
                frogCount++;
            }
            else if (a instanceof Parrot && parrotCount == 0)
            {
                parrotCount++;
            }
        }
        numAnimals = jaguarCount + frogCount + parrotCount;
    }
}
