package core.ecosystems.rainforest.buildings;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.arctic.buildings.OilDrill;
import core.ecosystems.coralreef.buildings.Coral;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.util.ArrayList;

public class FireDrone extends Building {
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
    public FireDrone() {
        super();
        myImage = Images.coralRobot;
        name = "Fire Drone";
        info = "help please";
        resizeImage();
        time = 0;
        grid = Game.getCurrentLevel().getGrid();
        maxWaitTime = 70;
        timer = maxWaitTime;
        x = grid.getCells()[myRow][myCol].getX();
        y = grid.getCells()[myRow][myCol].getY();
        c = new ArrayList<>();
        direction = 0;
    }

    @Override
    public void update() {
        super.update();
        time++;
        move();
        checkForDamage();
    }

    public void checkForDamage() {
        ArrayList<Cell> cells = new ArrayList<>();
        // changed
        int c = myRow;
        int r = myCol;
        checkCellsForDamage(cells, r - 1, c - 1);
        checkCellsForDamage(cells, r - 1, c);
        checkCellsForDamage(cells, r - 1, c + 1);
        checkCellsForDamage(cells, r, c - 1);
        checkCellsForDamage(cells, r, c + 1);
        checkCellsForDamage(cells, r + 1, c - 1);
        checkCellsForDamage(cells, r + 1, c);
        checkCellsForDamage(cells, r + 1, c + 1);

    }

    public void checkCellsForDamage(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c < Grid.getGridSize() && grid.getCells()[r][c].getBuilding() instanceof Fire )
        {
            Cell cell = grid.getCells()[r][c];
            validCells.add(cell);
        }
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    private void determineDirection(Cell newCell) {
        int c = newCell.getRow() - currentCells[0].getRow(); // GREATER THAN 0 IF IT MOVED RIGHT, LESS IF LEFT
        int r = newCell.getCol() - currentCells[0].getCol(); // GREATER THAN 0 IF IT MOVED DOWN, LESS IF UP

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

    public Fire getFire() {
        ArrayList<Cell> cells = new ArrayList<>();
        int c = myRow;
        int r = myCol;
        checkIfPossible(cells, r-1, c-1);
        checkIfPossible(cells, r-1, c);
        checkIfPossible(cells, r-1, c+1);
        checkIfPossible(cells, r, c-1);
        checkIfPossible(cells, r, c+1);
        checkIfPossible(cells, r+1, c-1);
        checkIfPossible(cells, r+1, c);
        checkIfPossible(cells, r+1, c+1);

        for (Cell cell: cells) {
            if (cell.getBuilding() instanceof Fire) {
                return (Fire) cell.getBuilding();
            }
        }
        return null;
    }

    public void checkIfPossible(ArrayList<Cell> validCells, int r, int c) {
        if (r >= 0 && r < Grid.getGridSize() && c >= 0 && c <  Grid.getGridSize()) {
            Cell cell = Game.getCurrentLevel().getGrid().getCells()[r][c];
            validCells.add(cell);
        }
    }

    }