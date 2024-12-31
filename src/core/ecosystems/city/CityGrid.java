package core.ecosystems.city;

import core.ecosystems.Grid;
import core.ecosystems.city.buildings.CityBuilding;
import org.newdawn.slick.GameContainer;

import java.util.ArrayList;

public class CityGrid extends Grid {
    private ArrayList<CityBuilding> cityBuildings;
    public CityGrid(GameContainer gc)
    {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new CityCell(i, j);
            }
        }
        cityBuildings = new ArrayList<>();
        cityBuildings.add(new CityBuilding());
        cityBuildings.add(new CityBuilding());
        int i = 1;

        for (CityBuilding c: cityBuildings)
        {
            c.assignCell(cells[3+i][3], this);
            i--;
        }

    }
}
