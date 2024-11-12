package core.ecosystems.tasks;

import core.Main;
import core.setup.Fonts;
import core.setup.Images;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

import static core.ecosystems.Grid.getGridWidth;

public class TaskManager {

    private float x;
    private float y;
    private float w;
    private float h;

    private ArrayList<Task> tasks;

    public TaskManager() {
        x = getGridWidth() + Main.getScreenWidth() * (10/1920f);
        y = 0;
        w = Main.getScreenWidth()-x-(10/1920f);
        h = Main.getScreenHeight() * (500/1080f);
        tasks = new ArrayList<>();
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(x, y, w, h);
        g.setFont(Fonts.big);
        g.drawString("TASKS:", x+w/2-100, y+10);
        renderTasks(g);
    }

    public void renderTasks(Graphics g) {
        g.setFont(Fonts.medium);
        for (int i = 0; i < tasks.size(); i++) {
            g.drawRect(x + 10, y + 50 + i * 10, 15, 15);
            g.drawString(tasks.get(i).getName(), x + 30, y + 50 + i * 10);
        }
    }

    public void addTask(String name) {
        tasks.add(new Task(name));
    }

}
