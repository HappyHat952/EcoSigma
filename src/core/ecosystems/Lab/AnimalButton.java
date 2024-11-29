package core.ecosystems.Lab;

import core.buttons.Button;
import core.ecosystems.Animal;
import core.setup.Images;

public class AnimalButton extends Button {
    Class<? extends Animal> animal;
    public AnimalButton(int x, int y, Class<? extends Animal> a, String name) {
        super(x, y, Images.labMachine);
        animal = a;
        this.name = "create " + name;
    }
    public Class<? extends Animal> getAnimal()
    {
        return animal;
    }


}
