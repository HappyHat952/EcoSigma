package core.setup;

import core.ui.Popup;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PopupLoader {
    public static ArrayList<Popup> POPS;


    static public void loadPopups(int id)
    {
        String name;
        if (POPS != null)
        {
            for (Popup p: POPS)
            {
                p.deactivate();
            }
        }

        POPS = new ArrayList<>();
        if (id == -1)
        {
            name = "lab";
            for (int i= 1; i<= 4; i++)
            {
                POPS.add(loadImagePopup(name,i));
            }
        }
        else if (id == 0)
        {
            name = "arctic";
            for (int i = 1; i<=4; i++)
            {
                POPS.add(loadImagePopup(name,i));
            }
        }
        else if (id == 3)
        {
            //id 3
            name = "farm";
            for (int i= 1; i<= 4; i++)
            {
                POPS.add(loadImagePopup(name, i));
            }
        }
        else if (id == 1)
        {
            name = "coral";
            for (int i= 1; i<= 4; i++)
            {
                POPS.add(loadImagePopup(name, i));
            }
        }
        else if (id == 2)
        {
            name = "forest";
            for (int i= 1; i<= 4; i++)
            {
                POPS.add(loadImagePopup(name, i));
            }
        }

//        POP1 = loadPopup(1);
//        POP2 = loadPopup(2);
//        POP3 = loadPopup(3);
//        POP4 = loadPopup(4);
//        POP5 = loadPopup(5);

    }


    static public Popup loadPopup(String name, int num) {
        try {

            File text = new File("res/text/"+name+"/"+name+num);

            Scanner scan = new Scanner(text);


            // Loop through all the lines
            String title = scan.nextLine();
            String message = "";
            int i=0;

            //for (int i = 1; i < text.size()-1; i++)
            while (scan.hasNextLine()){
//                System.out.println(i);
                i++;
                String row = scan.nextLine();
                message = message +"\n"+ row;
            }
            scan.close();

            return new Popup(title, message);


        }
        catch (FileNotFoundException e) {

            System.out.println("Cannot find file!");

        }
        return new Popup();

    }

    static public Popup loadImagePopup(String name, int num) {
        try {

            Image image = new Image("res/popupImage/"+name+"/"+name+num+".png");

            return new Popup(image);


        }
        catch (SlickException e) {
            throw new RuntimeException(e);
        }


    }
}
