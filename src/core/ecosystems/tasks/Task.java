package core.ecosystems.tasks;

import core.ecosystems.Grid;
import core.ecosystems.Shop;

public abstract class Task {

    String name;
    protected Grid grid;
    protected int moneyValue;
    protected boolean hasUsedMoney;

    public Task(String name, Grid grid) {
        this.name = name;
        this.grid = grid;
    }

    public String getName() {
        return name;
    }
    public int getValue(){ return moneyValue;}

    public boolean isComplete() {
        if (getPercentDone() == 100) {
            return true;
        }
        return false;
    }
    public abstract int getPercentDone();
    public abstract void update();

    public void getMoney(Shop shop)
    {
        if (isComplete() && !hasUsedMoney)
        {
            shop.addMoney(moneyValue);
            hasUsedMoney = true;
        }
    }
}
