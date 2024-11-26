package core.ecosystems.tasks;

import core.ecosystems.Grid;

public abstract class Task {

    String name;
    protected Grid grid;
    private boolean complete;

    public Task(String name, Grid grid) {
        this.name = name;
        complete = false;
        this.grid = grid;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isComplete();
    public abstract int getPercentDone();
    public abstract void update();
}
