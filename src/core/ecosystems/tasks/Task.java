package core.ecosystems.tasks;

public abstract class Task {

    String name;
    private boolean complete;

    public Task(String name) {
        this.name = name;
        complete = false;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isComplete();
}
