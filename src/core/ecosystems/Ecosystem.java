package core.ecosystems;

import org.newdawn.slick.Graphics;

//manages everything regarding a single ecosystem - contains the shop, lab, and grid
abstract public class Ecosystem {
    protected Grid grid;
    protected Shop shop;

    public Ecosystem(){
        grid = new Grid();
        shop = new Shop();
        shop.setItems(0);
    }

    public void render(Graphics g){
        grid.render(g);
        shop.render(g);
    }

    public void update()
    {
        grid.update();
        shop.update();
    }

    public void mousePressed(int x, int y)
    {
        shop.mousePressed(x,y);
    }
}
