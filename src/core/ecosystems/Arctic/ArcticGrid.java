package core.ecosystems.Arctic;

import core.ecosystems.Building;
import core.ecosystems.Grid;
import org.newdawn.slick.GameContainer;

public class ArcticGrid extends Grid {

    public ArcticGrid(GameContainer gc)
    {
        super(gc);
        for (int i = 0;i< cells.length;i++ )
        {
            for (int j = 0; j< cells[0].length; j++)
            {
                cells[i][j] = new ArcticCell(i,j);
            }
        }
    }
}
