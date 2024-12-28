package core.ecosystems.rainforest.buildings;

import core.Game;
import core.ecosystems.Grid;
import core.ecosystems.general.Building;
import core.ecosystems.general.Cell;
import core.setup.Images;
import org.newdawn.slick.Color;

import java.util.ArrayList;

public class FireDrone extends Building {
        private int time;
        private int stage;
        private boolean isCompleted;
        private int iceCreated;
        private int lastReportedIce;
        private Grid grid;

        public FireDrone() {
            myImage = Images.lemming;
            name = "Fire Drone";
            info = "help";
            isCompleted = false;
            resizeImage();
        }

        public void update() {

        }



    }
