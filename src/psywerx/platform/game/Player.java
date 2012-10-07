package psywerx.platform.game;

public class Player extends GameObject {

    protected Vector direction = new Vector();
    protected Vector velocity = new Vector();
    protected Vector acceleration = new Vector();

    public Player() {
    }

    public void tick(long delta) {

        double oldX = x;
        double oldY = y;

        x += velocity.x * delta;
        y += velocity.y * delta;

        // Simple collision detection:
        for (GameObject obj : Main.game.objects) {
            if ((x + size) > obj.x && (y + size) > obj.y && x < (obj.x + obj.size)
                    && (y < obj.y + obj.size)) {
                // There is a collision:
                y = oldY;
                x = oldX;

            
            
            }

        }
        if (x > Main.WIDTH - size) {
            x = Main.WIDTH - size;
        }
        if (x < 0) {
            x = 0;
        }
        if (y > Main.HEIGHT) {
            y = 0;
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }

    }
}
