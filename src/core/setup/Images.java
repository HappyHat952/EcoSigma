package core.setup;

import core.Main;
import core.ecosystems.tasks.TaskManager;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Images {

    // CONSTANTS
    static int boxWidth = 30;

    // TITLE
    public static Image titleScreen;
    // INTRO
    public static SpriteSheet introScreenSheet;
    // MAP
    public static Image mapScreen;
    // GAME
    public static Image check;
    // ARCTIC
    public static Image arcticMachine;
    // LEVEL 2

    // LEVEL 3

    // LEVEL 4

    // LEVEL 5

    // LAB

    public static void loadImages() {
        try {

            // TITLE
            titleScreen = (new Image("res/title/title.png")).getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
            // INTRO
            introScreenSheet = new SpriteSheet("res/intro/intro.png", 1920, 1080);
            // MAP
            mapScreen = (new Image("res/map/mapBlank.png")).getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
            // GAME
            check = (new Image("res/game/check.png").getScaledCopy(boxWidth, boxWidth));
            // ARCTIC
            arcticMachine = new Image("res/game/arctic/arcticMachine.png");
            // LEVEL 2

            // LEVEL 3

            // LEVEL 4

            // LEVEL 5

            // LAB
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}
