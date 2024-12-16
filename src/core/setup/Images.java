package core.setup;

import core.Main;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Images {

    // CONSTANTS
    static int boxWidth = 30;
    // BUTTONS
    public static Image homeButton;
    public static Image helpButton;
    public static Image soundOnButton;
    public static Image soundOffButton;
    public static Image pauseButton;
    // TITLE
    public static Image titleScreen;
    // INTRO
    public static SpriteSheet introScreenSheet;
    // MAP
    public static Image mapScreen;
    // GAME
    public static Image check;
    public static SpriteSheet animal;
    public static SpriteSheet plant;
    //LAB
    public static Image labMachine;
    // ARCTIC
    public static Image arcticMachine;
    public static SpriteSheet CO2SuckerSheet;
    public static SpriteSheet cloudSheet;
    public static Image pump;
    public static Image oilDrill;
    public static Image protesters;

    public static SpriteSheet polarBear;
    public static SpriteSheet walrus;
    public static SpriteSheet lemming;
    // CORAL REEF
    public static Image damagedCoral;
    public static Image bioRock;
    public static Image soundCreator;
    public static Image coralRobot;
    // LEVEL 3

    // LEVEL 4

    // LEVEL 5

    // LAB

    public static void loadImages() {
        try {
            // BUTTONS
            homeButton = new Image("res/buttons/homeButton.png");
            helpButton = new Image("res/buttons/helpButton.png");
            soundOnButton = new Image("res/buttons/soundOnButton.png");
            soundOffButton = new Image("res/buttons/soundOffButton.png");
            pauseButton = new Image("res/buttons/pauseButton.png");
            // TITLE
            titleScreen = (new Image("res/title/title.png")).getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
            // INTRO
            introScreenSheet = new SpriteSheet("res/intro/intro.png", 1920, 1080);
            // MAP
            mapScreen = (new Image("res/map/mapBlank.png")).getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
            // GAME
            check = (new Image("res/game/check.png").getScaledCopy(boxWidth, boxWidth));
            animal =new SpriteSheet( (new Image("res/game/animal_placeholder.png")), 128, 128);
            plant = new SpriteSheet( (new Image("res/game/plant_placeholder.png")), 128,128 );
            //LAB
            labMachine = new Image("res/game/LabMachine.png");
            // ARCTIC
                //machines
                arcticMachine = new Image("res/game/arctic/arcticMachine.png");
                CO2SuckerSheet = new SpriteSheet(new Image("res/game/arctic/carbonSucker.png").getScaledCopy(2), 128, 128);
                pump = new Image("res/game/arctic/pump.png");
                oilDrill = new Image("res/game/arctic/oilDrill.png");
                protesters = new Image("res/game/arctic/protesters.png");

                //animals
                polarBear =new SpriteSheet( (new Image("res/game/arctic/polar_bear.png")), 128, 128);
                walrus =new SpriteSheet( (new Image("res/game/arctic/walrus.png")), 128, 128);
                lemming =new SpriteSheet( (new Image("res/game/arctic/lemming.png")), 128, 128);
                //other
                cloudSheet = new SpriteSheet((new Image("res/game/arctic/cloud.png")), 128, 128);

            // LEVEL 2
            damagedCoral = new Image("res/game/coralreef/bleachedCoral.png");
            bioRock = new Image("res/game/coralreef/bioRock.png");
            soundCreator = new Image("res/game/coralreef/soundCreator.png");
            coralRobot = new Image("res/game/coralreef/robotRepairer.png");

            // LEVEL 3

            // LEVEL 4

            // LEVEL 5

            // LAB
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}
