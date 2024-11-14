package core.ecosystems.Arctic.tasks;

import core.ecosystems.tasks.Task;

public class ClearedCO2 extends Task {

    public ClearedCO2(String name) {
        super(name);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

}
