package core.ecosystems.coralreef;

import core.ecosystems.general.Cell;
import org.newdawn.slick.Color;

public class CoralReefCell extends Cell {
    public CoralReefCell(int r, int c) {
        super(r, c);
        myColor = new Color(2, 194, 252);
    }
}
