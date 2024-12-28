package core.ecosystems.arctic;

import core.ecosystems.general.Cell;
import core.setup.Images;
import org.newdawn.slick.Color;

public class ArcticCell extends Cell {
    public ArcticCell(int r, int c) {
        super(r, c);
        myColor = Color.lightGray;
        myImage = Images.arcticCells.getSubImage(0,0);
    }
}
