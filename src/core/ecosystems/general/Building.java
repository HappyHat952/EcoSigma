package core.ecosystems.general;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Building {

    protected int myRow;
    protected int myCol;
    protected Cell cell;
    protected Image myImage;
    protected String name;
    protected String info;
    protected boolean isCompleted;

    public Building()
    {

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

    public void update() {

    }
    //accessor

    public int getMyCol() {
        return myCol;
    }

    public int getMyRow() {
        return myRow;
    }

    public Image getMyImage() {return myImage;}

    public String getName() {
        return name;
    }
    public String getInfo() {
        return info;
    }

    //mutator
    public void resizeImage()
    {
        myImage = myImage.getScaledCopy(Cell.getWidth(), Cell.getHeight());
    }


}
