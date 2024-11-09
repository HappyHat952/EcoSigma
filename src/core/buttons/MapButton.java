package core.buttons;

import core.ecosystems.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.state.StateBasedGame;

import static core.Main.GAME_ID;

public class MapButton extends Button {

    private int levelID;
    public MapButton(int x, int y, int w, int h, Color color, int levelID) {
        super(x, y, w, h, color);
        this.levelID = levelID;
    }

    public void action(StateBasedGame sbg) {
        Game.levelID = levelID;
        sbg.enterState(GAME_ID);
    }
}
