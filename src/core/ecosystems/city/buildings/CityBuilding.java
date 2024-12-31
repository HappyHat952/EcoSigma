package core.ecosystems.city.buildings;

import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;

public class CityBuilding extends Building {

    public CityBuilding()
    {
        super();
        myImage = Images.cityBuilding;
    }

    public void click(int x, int y, int button)
    {
        super.click(x,y, button);
        if (mouseOver(x, y))
        {
            myImage = Images.placeHolder.getSubImage(0,0).getScaledCopy(200,500);
        }
    }
}
