package core.ecosystems.general;

import core.ecosystems.Ecosystem;
import core.ecosystems.Grid;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Building {

    protected int myRow;
    protected int myCol;
    protected int cost;

    protected int cellWidth;
    protected int cellHeight;
    protected Cell cell;
    protected Cell[] cells;
    protected Image myImage;
    protected String name;
    protected String info;
    protected boolean isCompleted;
    protected Ecosystem ecosystem;

    public Building()
    {
        cost = 4;
    }

    public void assignCell(Cell cell, Grid grid)
    {
        this.cell = cell;
        cells = new Cell[]{cell};
        myRow = cell.getCol();
        myCol = cell.getRow();
        cell.addBuilding(this);
        //grid.addBuilding(this);
        cellWidth = 1;
        cellHeight = 1;
    }

    public void assignCell(Cell[] cells, Grid grid, int cellW, int cellH, boolean floating)
    {
        this.cells = cells;

        //first cell must be the top left.
        myRow = cells[0].getRow();
        myCol = cells[0].getCol();
        cellWidth = cellW;
        cellHeight = cellH;


        //if the building "floats" the cell that it is over doesn't contain the cell
        //(therefore, animals and plants can be directly under the floating building on the cell)
        if (!floating)
        {
            for (Cell c: cells)
            {
                c.addBuilding(this);
            }
        }

        //grid.addBuilding(this);
    }

    public void render(Graphics g)
    {
        //scaled by the width.
        float width = myImage.getWidth();
        float height = myImage.getHeight();
        Image adjusted = myImage.getScaledCopy(Cell.getWidth()*cellWidth, (int)(height/width*Cell.getWidth()* cellWidth));
        g.drawImage(adjusted, cells[0].getX(), cells[0].getY() + Cell.getHeight() - adjusted.getHeight());
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
    public int getCost()
    {
        return cost;
    }
    public String getInfo() {
        return info;
    }
    public Cell getCell(){ return cell;}
    public Cell[] getCells() { return cells;}

    public boolean mouseOver(int x, int y)
    {
        return (x > cells[0].getX() && x< cells[0].getX() + cellWidth* Cell.getWidth()
                && y > cells[0].getY() && y< (cells[0].getY() + cellHeight* Cell.getHeight()));
    }

    //mutator
    public void resizeImage()
    {
        myImage = myImage.getScaledCopy(Cell.getWidth(), Cell.getHeight());
    }

    public void click(int x, int y, int button)
    {

    }




}
