package core.buttons;

import core.setup.Images;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class HelpButtons extends Button {

    private Image homeButton;
    private Image helpButton;
    private Image soundOnButton;
    private Image soundOffButton;
    private Image pauseButton;
    private int buffer;

    public HelpButtons(int x, int y) {
        super(x, y);
        homeButton = Images.homeButton;
        helpButton = Images.helpButton;
        soundOnButton = Images.soundOnButton;
        soundOffButton = Images.soundOffButton;
        pauseButton = Images.pauseButton;
        buffer = homeButton.getWidth();
    }

    public void render(Graphics g) {
        g.drawImage(homeButton, x, y);
        g.drawImage(helpButton, x +buffer, y);
        g.drawImage(soundOnButton, x + buffer * 2, y);
        g.drawImage(pauseButton, x + buffer * 3, y);
    }


}
