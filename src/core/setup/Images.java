package core.setup;

import core.Main;
import core.ecosystems.Cell;
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
    public static SpriteSheet animal;
    //LAB
    public static Image labMachine;
    // ARCTIC
    public static Image arcticMachine;
    public static SpriteSheet CO2SuckerSheet;

    public static SpriteSheet polarBear;
    public static SpriteSheet walrus;
    public static SpriteSheet lemming;
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
            animal =new SpriteSheet( (new Image("res/game/animal_placeholder.png")), 128, 128);
            //LAB
            labMachine = new Image("res/game/LabMachine.png");
            // ARCTIC
                //machines
                arcticMachine = new Image("res/game/arctic/arcticMachine.png");
                CO2SuckerSheet = new SpriteSheet(new Image("res/game/arctic/carbonSucker.png").getScaledCopy(3), 128, 128);

                //animals
                polarBear =new SpriteSheet( (new Image("res/game/arctic/polar_bear.png")), 128, 128);
                walrus =new SpriteSheet( (new Image("res/game/arctic/walrus.png")), 128, 128);
                lemming =new SpriteSheet( (new Image("res/game/arctic/lemming.png")), 128, 128);
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
