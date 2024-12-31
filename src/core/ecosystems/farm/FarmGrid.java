package core.ecosystems.farm;

import core.ecosystems.Grid;
import core.ecosystems.farm.animals.Crop;
import core.ecosystems.farm.animals.MonoCultureCrop;
import core.ecosystems.farm.buildings.GreenHouse;
import core.ecosystems.general.Cell;
import core.ecosystems.general.Plant;
import org.newdawn.slick.GameContainer;

public class FarmGrid extends Grid {

    public FarmGrid(GameContainer gc) {
        super(gc);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new FarmCell(i, j);
            }
        }
        GreenHouse greenHouse = new GreenHouse();
        Cell[] greenCells;
        greenCells = new Cell[] {cells[4][0]};
        greenHouse.assignCell(greenCells, this, 5,5, true);

        addBuilding(greenHouse);

        for (int i = 0; i< cells.length; i+=2)
        {
            for (int j = 0; j< cells[0].length; j ++)
            {
                addPlant(MonoCultureCrop.class, cells[i][j]);
            }
        }
    }

    @Override
    public void mousePressed(int x, int y, int button ) {
        super.mousePressed(x, y, button);
        for (int i = 0; i< plants.size(); i++)
        {
            Plant p = plants.get(i);
            p.click(x,y, button);
            if (p.mouseOver(x,y))
            {
                    Crop c = (Crop) p;
                    shop.addMoney(c.getPrice());
                plants.remove(p);
                i--;

            }
        }
    }
}
