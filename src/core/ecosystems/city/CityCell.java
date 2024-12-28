package core.ecosystems.city;

import core.ecosystems.general.Cell;
import org.newdawn.slick.Color;

public class CityCell extends Cell {

    public CityCell(int r, int c) {
        super(r, c);
        myColor = Color.lightGray;
    }
}
