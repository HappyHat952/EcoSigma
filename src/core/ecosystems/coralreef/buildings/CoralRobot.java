package core.ecosystems.coralreef.buildings;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.util.ArrayList;

public class CoralRobot extends Building {

    private int time;
    private Grid grid;
    private int coralRepaired;
    private int timer;
    private int maxWaitTime;
    protected Cell currentCell;
    protected Cell futureCell;
    private int x;
    private int y;
    private ArrayList<Cell> c;
    private int direction;
    protected ArrayList<Cell> possibleCells;

    public CoralRobot() {
        super();
        myImage = Images.coralRobot;
        name = "Repair Robot";
        info = "help please";
        resizeImage();
        time = 0;
        grid = Game.getCurrentLevel().getGrid();
        coralRepaired = 0;
        maxWaitTime = 70;
        timer = maxWaitTime;
        x = grid.getCells()[myRow][myCol].getX();
        y = grid.getCells()[myRow][myCol].getY();
        c = new ArrayList<>();
        direction = 0;
    }

    public void update() {
        super.update();
        time++;
        if (time % 100 == 0)
        {
//            ArrayList<Cell> cells = new ArrayList<>();
//            int r = myRow;
//            int c = myCol;
//            checkIfPossible(cells, r - 1, c - 1);
//            checkIfPossible(cells, r - 1, c);
//            checkIfPossible(cells, r - 1, c + 1);
//            checkIfPossible(cells, r, c - 1);
//            checkIfPossible(cells, r, c + 1);
//            checkIfPossible(cells, r + 1, c - 1);
//            checkIfPossible(cells, r + 1, c);
//            checkIfPossible(cells, r + 1, c + 1);
//            if (!cells.isEmpty()) {
//                grid.getCells()[myRow][myCol].removeBuilding();
//                int random = (int) (Math.random() * cells.size());
//                this.assignCell(cells.get(random), grid);
//            }
        }
        move();
        checkForDamage();

    }

    public void assignCell(Cell c, Grid grid)
    {
        super.assignCell(c,grid);
        currentCell = c;
        myRow = c.getRow();
        myCol = c.getCol();
        x = c.getX();
        y = c.getY();
    }

    public void move() {
        if (timer == 0) {
            if (futureCell != null) {
                //switch cell location if future cell is changed
                currentCell.removeBuilding();
                currentCell = futureCell;
                currentCell.addBuilding(this);
                myRow = currentCell.getRow();
                myCol = currentCell.getCol();
                x = currentCell.getX();
                y = currentCell.getY();
                currentCells[0] = currentCell;
            }

            timer = maxWaitTime;


            possibleCells = grid.getOpenAdjacentCells(currentCell.getRow(), currentCell.getCol());
            if (!possibleCells.isEmpty()) {

                //determine next future cell location
                int i = (int) (Math.random() * possibleCells.size());

                futureCell = possibleCells.get(i);
                determineDirection(futureCell);
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
        g.drawImage(adjusted, x, y + Cell.getHeight() - adjusted.getHeight());

    }

    public void checkIfPossible(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c < Grid.getGridSize() && !grid.getCells()[r][c].hasBuilding() &&
                !grid.getCells()[r][c].hasAnimal() && !grid.getCells()[r][c].hasPlant()) {
            Cell cell = grid.getCells()[r][c];
            validCells.add(cell);
        }
    }

    public void checkCellsForDamage(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c < Grid.getGridSize() && grid.getCells()[r][c].getBuilding() instanceof Coral
                && !((Coral) grid.getCells()[r][c].getBuilding()).isHealthy()) {
            Cell cell = grid.getCells()[r][c];
            validCells.add(cell);
        }
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void checkForDamage() {
        ArrayList<Cell> cells = new ArrayList<>();
        int r = myRow;
        int c = myCol;
        checkCellsForDamage(cells, r - 1, c - 1);
        checkCellsForDamage(cells, r - 1, c);
        checkCellsForDamage(cells, r - 1, c + 1);
        checkCellsForDamage(cells, r, c - 1);
        checkCellsForDamage(cells, r, c + 1);
        checkCellsForDamage(cells, r + 1, c - 1);
        checkCellsForDamage(cells, r + 1, c);
        checkCellsForDamage(cells, r + 1, c + 1);

        if (!cells.isEmpty()) {
            int random = (int) (Math.random() * cells.size());
            ((Coral) (cells.get(random).getBuilding())).setIsHealthy(true);
            coralRepaired++;
        }

    }

    public int getCoralRepaired() {
        return coralRepaired;
    }

    private void determineDirection(Cell newCell) {
        int r = newCell.getRow() - currentCells[0].getRow(); // GREATER THAN 0 IF IT MOVED RIGHT, LESS IF LEFT
        int c = newCell.getCol() - currentCells[0].getCol(); // GREATER THAN 0 IF IT MOVED DOWN, LESS IF UP

        if (r > 0) {
            direction = 2; // moving right
        } else if (r < 0) {
            direction = 1; //moving left
        } else if (c > 0) {
            direction = 0; //moving down
        } else if (c < 0) {
            direction = 3; // moving up
        }
    }
}
