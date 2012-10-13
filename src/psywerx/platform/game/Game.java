package psywerx.platform.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game {

    private int fps;
    private long totalTime;
    private int frames;

    protected Player player = new Player();
    protected CopyOnWriteArrayList<GameObject> objects = new CopyOnWriteArrayList<GameObject>();

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

        g.setColor(Color.gray);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        g.setColor(Color.black);
        g.translate(Main.game.player.velocity.x*10, 0);
        
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        
        player.render(g);

        for (GameObject obj : objects) {
            obj.render(g);
        }

        // DRAW FPS:
        g.setFont(new Font("Courier New", Font.PLAIN, 12));
        g.setColor(Color.GREEN);
        g.drawString(String.format("FPS: %s", fps), 20, 20);
    }

    public void resetObjects() {
        for (GameObject o : objects) {
            o.color = Color.RED;
        }
        
    }
}
