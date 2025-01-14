package core.ecosystems.coralreef;

import core.ecosystems.Ecosystem;
import core.ecosystems.coralreef.buildings.SoundMaker;
import core.ecosystems.coralreef.tasks.*;
import core.setup.Images;
import core.ecosystems.general.Cell;
import core.setup.Sounds;
import core.ui.PopupManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CoralReef extends Ecosystem {

    public static int ID;
    private boolean soundOn;

    public CoralReef(GameContainer gc, StateBasedGame sbg, PopupManager pu, int id) {
        super(gc, sbg, pu);
        ID = id;
        grid = new CoralReefGrid(gc);
        shop = new CoralReefShop(grid, gc);
        taskManager.addTask(new CreateSounds("Introduce Sounds", grid));
        taskManager.addTask(new CreateCoral("Create New Coral Structures", grid));
        taskManager.addTask(new RepairCoral("Repair Damaged Coral", grid));
        taskManager.addTask(new CreateReefAnimals("Create All 3 Animals", grid));
        taskManager.addTask(new CreateSeaweed("Plant 3 Seaweed", grid));
        soundOn = false;
    }

    @Override
    public void update() {
        super.update();
        for (int r = 0; r < grid.getCells().length; r++) {
            for (int c = 0; c < grid.getCells()[r].length; c++) {
                Cell cell = grid.getCells()[r][c];
        winImage = Images.coralWin;
        this.id = id;

                if (cell.hasBuilding() && cell.getBuilding() instanceof SoundMaker) {
                    if (!soundOn) {
                        Sounds.coralReef.loop();
                        soundOn = true;
                    }
                }
            }
        }

    }

    public void setSoundOn(boolean soundOn) {
        this.soundOn = soundOn;
    }
}
