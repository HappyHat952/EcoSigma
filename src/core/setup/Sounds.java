package core.setup;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Sounds {

    public static Sound click;
    public static Music coralReef;
    public static void loadSounds() throws SlickException {
        coralReef = new Music("res/sounds/coralReef.wav");

    }

}