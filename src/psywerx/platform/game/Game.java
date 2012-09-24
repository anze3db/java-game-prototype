package psywerx.platform.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Game {

    private double x, y;
    protected double directionL, directionR, directionD, directionU = 0;
    private int fps;
    private long totalTime;
    private int frames;

    public Game() {

    }

    public void tick(long delta) {
        x += delta * (directionR - directionL) * 0.5d;
        y += delta * (directionD - directionU) * 0.5d;
        if (x > Main.WIDTH - 10) {
            x = Main.WIDTH - 10;
        }
        if (x < 0) {
            x = 0;
        }
        if (y > Main.HEIGHT - 10) {
            y = Main.HEIGHT - 10;
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
        g.fillRect(0, 0, 10, 10);
        g.translate(-x, -y);

        // DRAW FPS:
        g.setFont(new Font("Courier New", Font.PLAIN, 12));
        g.setColor(Color.GREEN);
        g.drawString(String.format("FPS: %s", fps), 20, 20);
    }
}
