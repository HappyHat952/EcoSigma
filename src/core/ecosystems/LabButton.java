package core.ecosystems;

import core.Main;
import core.buttons.Button;
import org.newdawn.slick.Color;

public class LabButton extends Button {
    public LabButton() {
        super(Grid.getGridWidth()+(int)(Main.getScreenWidth()*.05f), (int)(Main.getScreenHeight()*.55f),
                (int)(Main.getScreenWidth()*.1f), (int)(Main.getScreenHeight()*.15f), Color.green);
    }
}
