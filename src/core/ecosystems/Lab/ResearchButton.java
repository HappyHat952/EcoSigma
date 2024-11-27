package core.ecosystems.Lab;

import core.buttons.Button;
import core.ecosystems.Animal;
import org.newdawn.slick.Color;

public class ResearchButton extends Button {
    Animal animal;
    public ResearchButton(int x, int y, int w, int h, Color color, Animal animal) {
        super(x, y, w, h, color);
        name = "create "+ animal.toString();
    }


}
