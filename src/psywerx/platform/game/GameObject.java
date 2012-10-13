package psywerx.platform.game;

import java.awt.Color;
import java.awt.Graphics2D;

public class GameObject {

    protected double x, y;
    protected int size = 10;
    protected Color color = new Color(150, 0, 0);

    protected Vector direction = new Vector();
    protected Vector velocity = new Vector();
    protected Vector acceleration = new Vector();
    protected boolean falling = false;

    public GameObject() {

    }

    public GameObject(int startX, int startY) {
        x = (double) ((startX / size) * size);
        y = (double) ((startY / size) * size);
    }

    public void Draw() {

    }
    public void render(Graphics2D g) {
        g.setColor(color);
        g.translate(x, y);
        g.fillRect(0, 0, size, size);
        g.translate(-x, -y);
    }

    public void tick(long delta) {

    }

}
