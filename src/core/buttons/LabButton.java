package core.buttons;

import core.Main;
import core.ecosystems.Grid;
import core.setup.Images;
import org.newdawn.slick.Color;

public class LabButton extends Button {
    public LabButton() {
        super(Grid.getGridWidth()+(int)(Main.getScreenWidth()*.04f), (int)(Main.getScreenHeight()*.55f),
                Images.lab.getScaledCopy((int)(Main.getScreenWidth()*.1f), (int)(Main.getScreenHeight()*.15f)));
//
//        super(Grid.getGridWidth()+(int)(Main.getScreenWidth()*.05f), (int)(Main.getScreenHeight()*.55f),
//                (int)(Main.getScreenWidth()*.1f), (int)(Main.getScreenHeight()*.15f), Color.green);
        name = "Lab";
    }

}
