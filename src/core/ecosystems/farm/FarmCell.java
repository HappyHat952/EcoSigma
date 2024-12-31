package core.ecosystems.farm;

import core.ecosystems.general.Cell;
import core.setup.Images;
import org.newdawn.slick.Color;

public class FarmCell extends Cell {

    public FarmCell(int r, int c) {
        super(r, c);
        myColor = new Color(40,255,40);
        myImage = Images.farmCells.getSubImage(0,0);

    }
}
