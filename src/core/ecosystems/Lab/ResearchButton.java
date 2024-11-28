package core.ecosystems.Lab;

import core.buttons.Button;
import core.ecosystems.Animal;
import core.ecosystems.Cell;
import core.setup.Images;
import org.newdawn.slick.Color;

public class ResearchButton extends Button {
    Class<? extends Animal> animal;
    public ResearchButton(int x, int y, Class<? extends Animal> a, String name) {
        super(x, y, Images.labMachine);
        animal = a;
        this.name = "create " + name;
    }
    public Class<? extends Animal> getAnimal()
    {
        return animal;
    }


}
