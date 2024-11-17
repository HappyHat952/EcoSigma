package core.ecosystems.Arctic;

import core.ecosystems.Building;
import core.ecosystems.Grid;

public class ArcticGrid extends Grid {

    public ArcticGrid()
    {
        super();
        for (int i = 0;i< cells.length;i++ )
        {
            for (int j = 0; j< cells[0].length; j++)
            {
                cells[i][j] = new ArcticCell(i,j);
            }
        }
        mouseBuilding = new Building();
    }
}
