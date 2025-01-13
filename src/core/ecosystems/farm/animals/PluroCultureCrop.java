package core.ecosystems.farm.animals;

import core.ecosystems.general.Cell;
import core.setup.Images;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class PluroCultureCrop extends Crop{

    public PluroCultureCrop(Cell cell) {
        super(cell);
        growTime = 4;
        Image spriteImage = Images.pluroCulture.getSubImage((int)(Math.random()*3),0);
        sprite = new SpriteSheet(spriteImage, 160,320);
        setSprite(sprite);
        //sprite.setImageColor(1f, (float)(Math.random()),(float)( Math.random()));
        name = "pluroculture";
        price = 6;
        costOfGenome = 100;

    }
}
