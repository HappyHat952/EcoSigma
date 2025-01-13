package core.ui;

import java.util.ArrayList;

import core.Game;
import core.setup.PopupLoader;
import org.newdawn.slick.Graphics;

import static core.setup.PopupLoader.POPS;

public class PopupManager {
    private static ArrayList<Popup> popups;

    public PopupManager()
    {
        popups = PopupLoader.POPS;
    }

    public static void render(Graphics g)
    {
        for (Popup p: PopupLoader.POPS)
        {
            p.render(g);
        }
    }

    public static  void update( )
    {
        for (Popup p: PopupLoader.POPS)
        {
            p.update();
        }

    }

    public static void mousePressed(int button, int x, int y) {
        for (Popup p: PopupLoader.POPS)
        {
            p.click(x, y);
        }
    }

    public static void activate(int i )
    {
        PopupLoader.POPS.get(i).activate();
        Game.pause();
        //System.out.println("MANAGER PAUSE");
    }


    public static void addPopup(Popup p)
    {
        PopupLoader.POPS.add(p);
    }



}