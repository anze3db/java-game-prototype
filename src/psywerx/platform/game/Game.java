package psywerx.platform.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class Game {

    protected double x, y;
    protected double directionL, directionR, directionD, directionU = 0;
    private int fps;
    private long totalTime;
    private int frames;
    private int size = 20;

    protected LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public Game() {

    }

    public void tick(long delta) {
        double oldX = x;
        double oldY = y;

        x += (delta * (directionR - directionL) * 0.5d);
        y += (delta * (directionD - directionU) * 0.5d);
        
        // Simple colission detection:
        for (GameObject obj : objects) {
            if((x + size) > obj.x && (y + size) > obj.y &&
                x < (obj.x + obj.size) && (y < obj.y + obj.size)  ){
                x = oldX;
                y = oldY;
            }
        }

        if (x > Main.WIDTH - size) {
            x = Main.WIDTH - size;
        }
        if (x < 0) {
            x = 0;
        }
        if (y > Main.HEIGHT - size) {
            y = Main.HEIGHT - size;
        }
        if (y < 0) {
            y = 0;
        }

        // Calculate frame count:
        totalTime += delta;
        if (totalTime > 1000) {
            totalTime -= 1000;
            fps = frames;
            frames = 0;
        }
        frames++;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        g.setColor(new Color(0, 150, 0));
        g.translate(x, y);
        g.fillRect(0, 0, size, size);
        g.translate(-x, -y);

        g.setColor(new Color(150, 0, 0));
        for (GameObject obj : objects) {
            g.translate(obj.x, obj.y);
            g.fillRect(0, 0, obj.size, obj.size);
            g.translate(-obj.x, -obj.y);
        }

        // DRAW FPS:
        g.setFont(new Font("Courier New", Font.PLAIN, 12));
        g.setColor(Color.GREEN);
        g.drawString(String.format("FPS: %s", fps), 20, 20);
    }
}
