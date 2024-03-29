package psywerx.platform.game;

import java.awt.Color;

public class Player extends GameObject {

    protected Vector direction = new Vector();
    protected Vector velocity = new Vector();
    protected Vector acceleration = new Vector();
    private boolean falling = false;

    public Player() {
        x = Main.WIDTH/2-size/2;
    }

    public void tick(long delta) {

        if (falling) {
            acceleration.y = 0.001;
        } else {
            acceleration.y = 0;
        }
        double oldX = x;
        double oldY = y;
        velocity.y += acceleration.y * delta;
        velocity.x += acceleration.x * delta;
        if(velocity.x > 0.3) velocity.x =   0.3;
        if(velocity.x < -0.3) velocity.x = -0.3;
        if(acceleration.x == 0) velocity.x = 0;
        x += velocity.x * delta;
        y += velocity.y * delta;

        // Simple collision detection:
        falling = true;
        color = Color.BLUE;

        for (GameObject obj : Main.game.objects) {
            if ((x + size) > obj.x && (y + size) > obj.y && x < (obj.x + obj.size)
                    && (y < obj.y + obj.size)) {
                // There is a collision:
                y = oldY;
                x = oldX;

                falling = false;
                velocity.y = 0;
                obj.color = color;

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
            x = Main.WIDTH/2-size/2;
            velocity.y = 0;
            Main.game.resetObjects();
        }
        if (y < 0) {
            y = 0;
        }

    }
}
