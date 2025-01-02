package core.buttons;

import core.Game;
import core.lab.Lab;
import core.setup.Fonts;
import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import static core.Main.GAME_ID;

public class MapButton extends Button {

    private int levelID;
    private String name;
    public MapButton(int x, int y, int w, int h, Color color, int levelID) {
        super(x, y, w, h, color);
        this.levelID = levelID;
    }

    public void action(StateBasedGame sbg) {
        Game.levelID = levelID;
        sbg.enterState(GAME_ID);
        Lab.setAvailableAnimals(Game.levelID);
    }

    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.white);
        g.setLineWidth(4);
        g.drawRect(x, y, w, h);

        g.setFont(Fonts.small);
        g.setColor(Color.black);
        if (levelID == 0) {
            g.drawString("Arctic", x + w/10, y + w/3);
        } else if (levelID == 1) {
            g.drawString("Coral", x + w/10, y + w/9);
            g.drawString("Reef", x + w/10, y + w/2);
        } else if (levelID == 2) {
            g.drawString("Rain", x + w/10, y + w/9);
            g.drawString("Forest", x + w/10, y + w/2);
        } else {
            g.drawString("Farm", x + w/10, y + w/3);
        }

        if (Game.getEcosystems()[levelID].isCompleted()) {
            g.drawImage(Images.check.getScaledCopy(w, h), x, y);
        }
    }
}
