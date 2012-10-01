package psywerx.platform.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class Game {

    private int fps;
    private long totalTime;
    private int frames;

    protected Player player = new Player();
    protected LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public Game() {
        player.size = 20;
    }

    public void tick(long delta) {

        player.tick(delta);

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

        // Reset screen:
        g.setColor(Color.black);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        g.setColor(new Color(0, 150, 0));
        player.render(g);

        g.setColor(new Color(150, 0, 0));
        for (GameObject obj : objects) {
            obj.render(g);
        }

        // DRAW FPS:
        g.setFont(new Font("Courier New", Font.PLAIN, 12));
        g.setColor(Color.GREEN);
        g.drawString(String.format("FPS: %s", fps), 20, 20);
    }
}
