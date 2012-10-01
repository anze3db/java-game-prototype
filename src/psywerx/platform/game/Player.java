package psywerx.platform.game;

public class Player extends GameObject {

    protected double directionL, directionR, directionD, directionU = 0;

    public Player() {
    }

    public void tick(long delta) {

        double oldX = x;
        double oldY = y;

        x += (delta * (directionR - directionL) * 0.5d);
        y += (delta * (directionD - directionU) * 0.5d);

        // Simple colission detection:
        for (GameObject obj : Main.game.objects) {
            if ((x + size) > obj.x && (y + size) > obj.y && x < (obj.x + obj.size)
                    && (y < obj.y + obj.size)) {
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

    }
}
