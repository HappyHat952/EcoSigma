package core.ui;

import java.util.ArrayList;

import core.ecosystems.Game;
import core.setup.PopupLoader;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class PopupManager {
    private static ArrayList<Popup> popups;
    int X_LEFT = 1500;
    private static boolean successionComplete;

    public PopupManager()
    {
        popups = new ArrayList<>();
        popups.add(PopupLoader.POP1);
        popups.add(PopupLoader.POP2);
        popups.add(PopupLoader.POP3);
        popups.add(PopupLoader.POP4);
        popups.add(PopupLoader.POP5);
    }

    public static void render(Graphics g)
    {
        for (Popup p: popups)
        {
            p.render(g);
        }
        g.drawString("num popups: "+ popups.size(), 0,0);
    }

    public static  void update( )
    {
        for (Popup p: popups)
        {
            p.update();
        }

    }

    public static void mousePressed(int button, int x, int y) {
        for (Popup p: popups)
        {
            p.click(x, y);
        }
    }

    public static void activate(int i )
    {
        popups.get(i).activate();
        Game.pause();
    }


    public static void addPopup(Popup p)
    {
        popups.add(p);
    }



}