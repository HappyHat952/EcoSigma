package core.setup;

import core.Main;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Images {

    //PLACEHOLDERS
    public static SpriteSheet placeHolder;
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
    public static Image lab;
    //LAB
    public static Image labMachine;
    // ARCTIC
    public static Image arcticMachine;
    public static SpriteSheet arcticCells;
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
    public static SpriteSheet clownfish;
    public static SpriteSheet stingray;
    public static SpriteSheet jellyFish;
    public static SpriteSheet seaweed;
    // LEVEL 3
    // 3: FARM
    public static SpriteSheet farmCells;
    public static Image greenHouse;

    // 4: CITY
    public static SpriteSheet cityCells;
    public static Image cityBuilding;

    // LAB
    public static Image labBackground;
    public static Image genomeMaker;
    public static Image petriDishes;
    public static Image organismMaker;

    public static void loadImages() {
        try {

            //PLACEHOLDERS
            placeHolder = new SpriteSheet("res/game/placeHolder.png", 256, 256);


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
            mapScreen = (new Image("res/map/map.png")).getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
            // GAME
            check = (new Image("res/game/check.png").getScaledCopy(boxWidth, boxWidth));
            animal =new SpriteSheet( (new Image("res/game/animal_placeholder.png")), 128, 128);
            plant = new SpriteSheet( (new Image("res/game/plant_placeholder.png")), 128,128 );
            lab = new Image("res/game/lab.png");
            //LAB
            labMachine = new Image("res/game/LabMachine.png");
            // ARCTIC
                arcticCells = new SpriteSheet("res/game/arctic/arcticCells.png", 224,224);
                //machines
                arcticMachine = new Image("res/game/arctic/machine/arcticMachine.png");
                CO2SuckerSheet = new SpriteSheet(new Image("res/game/arctic/machine/carbonSucker.png").getScaledCopy(2), 128, 128);
                pump = new Image("res/game/arctic/machine/pump.png");
                oilDrill = new Image("res/game/arctic/machine/oilDrill.png");
                protesters = new Image("res/game/arctic/protesters.png");

                //animals
                polarBear =new SpriteSheet( (new Image("res/game/arctic/animals/polarBear.png")), 280, 280);
                walrus =new SpriteSheet( (new Image("res/game/arctic/animals/walrus.png")), 128, 128);
                lemming =new SpriteSheet( (new Image("res/game/arctic/animals/lemming.png")), 256, 256);
                //other
                cloudSheet = new SpriteSheet((new Image("res/game/arctic/cloud.png")), 128, 128);

            // LEVEL 2
            damagedCoral = new Image("res/game/coralreef/bleachedCoral.png");
            bioRock = new Image("res/game/coralreef/bioRock.png");
            soundCreator = new Image("res/game/coralreef/soundCreator.png");
            coralRobot = new Image("res/game/coralreef/robotRepairer.png");

            //animals
            clownfish = new SpriteSheet((new Image("res/game/coralreef/clownfish.png")), 128, 128);
            stingray = new SpriteSheet((new Image("res/game/coralreef/stingray.png")), 128, 128);
            jellyFish = new SpriteSheet((new Image("res/game/coralreef/jellyFish.png")), 128, 128);
            seaweed = new SpriteSheet((new Image("res/game/coralreef/seaweed.png")), 128, 128);
            // LEVEL 3
            // LEVEL 3: FARM
            farmCells = new SpriteSheet("res/game/farm/farmCells.png",192,192 );
            greenHouse = new Image("res/game/farm/buildings/greenhouse.png");


            // LEVEL 4: CITY
            cityCells = new SpriteSheet("res/game/city/cityCell.png", 384,384);
            cityBuilding = new Image("res/game/city/buildings/cityBuilding.png");


            // LEVEL 5

            // LAB
            labBackground = new Image("res/lab/lab.png");
            genomeMaker = new Image("res/lab/genomeMaker.png");
            petriDishes = new Image("res/lab/eggMaker.png");
            organismMaker = new Image("res/lab/organismMaker.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}
