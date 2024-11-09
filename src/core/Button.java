package core;

import org.newdawn.slick.Color;

public class Button {

    private String name;
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;
    private int id;
    public Button(String name, int x, int y, int w, int h, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    public Button(int x, int y, int w, int h, int id) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.id = id;
    }

    public boolean isMouseOver(int mouseX, int mouseY) {
        if (mouseX >= x && mouseX <= x + w && mouseY <= y && mouseY >= y + h) {
            return true;
        }
        return false;
    }

}
