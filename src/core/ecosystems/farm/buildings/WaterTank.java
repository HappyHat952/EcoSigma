package core.ecosystems.farm.buildings;

import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class WaterTank extends Building {
    public WaterTank()
    {
        super();
        myImage = Images.placeHolder.getScaledCopy(Cell.getWidth() , (int)(Cell.getWidth()*1.5f));
        cost = 30;
    }
}
