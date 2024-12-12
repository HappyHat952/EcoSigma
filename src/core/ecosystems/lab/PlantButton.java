package core.ecosystems.lab;

import core.buttons.Button;
import core.ecosystems.general.Plant;
import core.setup.Images;

    public class PlantButton extends Button {
        Class<? extends Plant> plant;
        public PlantButton(int x, int y, Class<? extends Plant> a, String name) {
            super(x, y, Images.labMachine);
            plant = a;
            this.name = "create " + name;
        }
        public Class<? extends Plant> getPlant()
        {
            return plant;
        }


    }
