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
    private int xBuffer;
    private int yBuffer;
    private int textBuffer;
    private int boxWidth;

    private ArrayList<Task> tasks;

    public TaskManager() {
        x = getGridWidth() + Main.getScreenWidth() * (10/1920f);
        y = 0;
        w = Main.getScreenWidth()-x-(10/1920f);
        h = Main.getScreenHeight() * (500/1080f);
        tasks = new ArrayList<>();
        xBuffer = 70;
        yBuffer = 80;
        textBuffer = 50;
        boxWidth = 30;
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
            g.setLineWidth(1);
            g.drawRect(x + xBuffer - (xBuffer-boxWidth), yBuffer + (i * textBuffer), boxWidth, boxWidth);
            g.drawString(tasks.get(i).getName() + ": " + tasks.get(i).getPercentDone() + "%", x + xBuffer, yBuffer + i * textBuffer - 10);
            g.setLineWidth(10);
            if (tasks.get(i).isComplete()) {
                g.drawImage(Images.check, x + xBuffer - (xBuffer-boxWidth), yBuffer + (i * textBuffer));
            }
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(int i) {
        return tasks.get(i);
    }
}
