package core.ecosystems.coralreef;

import core.ecosystems.general.Cell;
import org.newdawn.slick.Color;

public class CoralReefCell extends Cell {
    public CoralReefCell(int r, int c) {
        super(r, c);
        myColor = new Color(154, 248, 255);
    }
}
