package core.lab;

import core.buttons.Button;
import core.ecosystems.general.Organism;
import core.setup.Images;

public class OrganismCreator extends Button {
    Class<? extends Organism> organism;
    public OrganismCreator(int x, int y, Class<? extends Organism> a, String name) {
        super(x, y, Images.labMachine);
        organism = a;
        this.name = "create " + name;
    }
    public Class<? extends Organism> getOrganism()
    {
        return organism;
    }


}
