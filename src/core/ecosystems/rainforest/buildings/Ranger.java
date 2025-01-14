package core.ecosystems.rainforest.buildings;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.coralreef.buildings.Coral;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

import java.util.ArrayList;

public class Ranger extends Building {

    private Grid grid;
    private int time;
    private int timer;
    private int maxWaitTime;
    protected Cell currentCell;
    protected Cell futureCell;
    private int x;
    private int y;
    private ArrayList<Cell> c;
    private int direction;
    protected ArrayList<Cell> possibleCells;
    private SpriteSheet sprite;
    public Ranger() {
        super();
        sprite = Images.ranger;
        myImage = sprite.getSubImage(0, 0);
        name = "Ranger";
        resizeImage();
        time = 0;
        grid = Game.getCurrentLevel().getGrid();
        maxWaitTime = 70;
        timer = maxWaitTime;
        x = grid.getCells()[myRow][myCol].getX();
        y = grid.getCells()[myRow][myCol].getY();
        c = new ArrayList<>();
        direction = 0;
        isMoving = true;
        cost = 90;
    }

    @Override
    public void update() {
        super.update();
        time++;
        move();
    }

    public void assignCell(Cell c, Grid grid)
    {
        super.assignCell(c,grid);
        currentCell = c;
        myRow = c.getCol();
        myCol = c.getRow();
        x = c.getX();
        y = c.getY();
    }

    public void move() {
        if (timer % 15 == 0) {
            frame = (frame + 1) % 4;
        }
        if (timer == 0) {
            if (futureCell != null) {
                //switch cell location if future cell is changed
                currentCell.removeBuilding();
                currentCell = futureCell;
                currentCell.addBuilding(this);
                myRow = currentCell.getCol();
                myCol = currentCell.getRow();
                x = currentCell.getX();
                y = currentCell.getY();
                currentCells[0] = currentCell;
            }

            timer = maxWaitTime;


            possibleCells = grid.getOpenAdjacentCells(currentCell.getCol(), currentCell.getRow());
            if (!possibleCells.isEmpty()) {

                //determine next future cell location
                int i = (int) (Math.random() * possibleCells.size());

                futureCell = possibleCells.get(i);
//                determineDirection(futureCell);
            }
        } else {
            timer--;
            if (futureCell != null) {
                int displacement = maxWaitTime - timer;
                x = currentCell.getX() + (int) (displacement * (futureCell.getX() - currentCell.getX()) / ((float) maxWaitTime));
                y = currentCell.getY() + (int) (displacement * (futureCell.getY() - currentCell.getY()) / ((float) maxWaitTime));
            }


        }
    }

    public void render(Graphics g)
    {

        float width = myImage.getWidth();
        float height = myImage.getHeight();
        Image adjusted = myImage.getScaledCopy(Cell.getWidth()*cellWidth, (int)(height/width*Cell.getWidth()* cellWidth));
//        g.drawImage(adjusted, x, y + Cell.getHeight() - adjusted.getHeight());
        g.drawImage(sprite.getSubImage(0, frame).getScaledCopy(Cell.getWidth(), Cell.getHeight()), x, y + Cell.getHeight() - adjusted.getHeight());
        if (grid != null) {
            g.drawString("" + frame, x, y);
        }

    }

    private boolean forwardIsClear(Grid grid)
    {
        Cell cell = null;
        switch(direction)
        {
            case(2 ):
                if (currentCell.getRow()+ 1< 10)
                {
                    cell = grid.getCells()[currentCell.getRow()+1][currentCell.getCol()];
                }
            case(1):
                if (currentCell.getRow()-1> 0)
                {
                    cell = grid.getCells()[currentCell.getRow()-1][currentCell.getCol()];
                }
            case(0):
                if (currentCell.getCol()+1< 10)
                {
                    cell = grid.getCells()[currentCell.getRow()][currentCell.getCol()+1];
                }

            case(3):
                if (currentCell.getCol()-1 > 10)
                {
                    cell = grid.getCells()[currentCell.getRow()][currentCell.getCol()-1];
                }

        }

        if (cell != null)
        {
            return !cell.hasBuilding();
        }
        return false;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

}

