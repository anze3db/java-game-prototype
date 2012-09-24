package psywerx.platform.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Game {

    private double x;
    private long direction = 1;
    private int fps;
    private long totalTime;
    private int frames;

    public Game() {

    }

    public void tick(long delta) {
        x += delta * direction * 0.2d;
        if (x > Main.WIDTH - 100) {
            direction *= -1;
        }
        if (x < 0) {
            direction *= -1;
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
        g.translate(x, 0);
        g.fillRect(0, 0, 100, Main.HEIGHT);
        g.translate(-x, 0);

        // DRAW FPS:
        g.setFont(new Font("Courier New", Font.PLAIN, 12));
        g.setColor(Color.GREEN);
        g.drawString(String.format("FPS: %s", fps), 20, 20);
    }
}
