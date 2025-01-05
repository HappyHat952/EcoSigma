package core.ecosystems.arctic;

import core.ecosystems.general.Cell;
import core.setup.Images;
import org.newdawn.slick.Color;

public class ArcticCell extends Cell {
    private boolean isIce;
    public ArcticCell(int r, int c) {
        super(r, c);
        myColor = Color.lightGray;
        isIce = false;
        myImage = Images.arcticCells.getSubImage(0,0);
    }

    public void setToIce()
    {
        setImage(Images.arcticCells.getSubImage(0,4));
        isIce = true;
    }

    public boolean isIce()
    {
        return isIce;
    }
}
