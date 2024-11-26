package core.ecosystems;

import core.setup.Images;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Building {

    protected int myRow;
    protected int myCol;
    protected Cell cell;
    protected Image myImage;

    public Building()
    {
        myImage = Images.arcticMachine;
        resizeImage();
    }

    public void assignCell(Cell cell)
    {
        this.cell = cell;
        myRow = cell.getRow();
        myCol = cell.getCol();
        cell.addBuilding(this);
    }

    public void render(Graphics g)
    {
        g.drawImage(myImage, cell.getX(), cell.getY());
    }
    //accessor
    public Image getMyImage() {return myImage;}
    //mutator
    public void resizeImage()
    {
        myImage = myImage.getScaledCopy(Cell.getWidth(), Cell.getHeight());
    }
}
