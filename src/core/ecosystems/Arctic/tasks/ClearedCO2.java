package core.ecosystems.Arctic.tasks;

import core.ecosystems.Arctic.Arctic;
import core.ecosystems.tasks.Task;

public class ClearedCO2 extends Task {

    private int totalClouds;
    private int cloudsDone;

    public ClearedCO2(String name) {
        super(name);
//        totalClouds = Arctic.getClouds().size();
        totalClouds = 1;
        cloudsDone = 0;
    }

    @Override
    public boolean isComplete() {
        if (cloudsDone == totalClouds) {
            return true;
        }
        return false;
    }

    @Override
    public int getPercentDone() {
        return (int) ((cloudsDone/(float) totalClouds) * 100);
    }

    public void deleteCloud() {
        cloudsDone++;
    }

}
