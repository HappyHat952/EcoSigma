package core.ecosystems.city;

import core.ecosystems.Grid;
import core.ecosystems.city.buildings.CityBuilding;
import core.ecosystems.general.Cell;
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

        Cell[] buildingCells = new Cell[]{
                cells[1][0], cells [1][1], cells[1][4], cells[1][5],
                cells[2][4], cells[2][5], cells[2][8], cells[2][9],
                cells[3][4], cells[3][9], cells[3][8]};
        for (Cell c: buildingCells)
        {
            CityBuilding b = new CityBuilding();
            b.assignCell(c, this);
            cityBuildings.add(b);
            addBuilding( b);


        }

    }
}
