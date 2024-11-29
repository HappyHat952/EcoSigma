package core.ecosystems.tasks;

import core.ecosystems.Grid;

public abstract class Task {

    String name;
    protected Grid grid;

    public Task(String name, Grid grid) {
        this.name = name;
        this.grid = grid;
    }

    public String getName() {
        return name;
    }

    public boolean isComplete() {
        if (getPercentDone() == 100) {
            return true;
        }
        return false;
    }
    public abstract int getPercentDone();
    public abstract void update();
}
