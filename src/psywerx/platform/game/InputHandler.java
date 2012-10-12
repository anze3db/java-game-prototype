package psywerx.platform.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {

    public InputHandler() {
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_DOWN):
//                Main.game.player.velocity.y += 0.3;
                break;
            case (KeyEvent.VK_UP):
//                Main.game.player.velocity.y += -0.3;
                break;
            case (KeyEvent.VK_LEFT):
                Main.game.player.velocity.x += -0.3;
                break;
            case (KeyEvent.VK_RIGHT):
                Main.game.player.velocity.x += 0.3;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_DOWN):
//                Main.game.player.velocity.y -= 0.3;
                break;
            case (KeyEvent.VK_UP):
//                Main.game.player.velocity.y -= -0.3;
                break;
            case (KeyEvent.VK_LEFT):
                Main.game.player.velocity.x -= -0.3;
                break;
            case (KeyEvent.VK_RIGHT):
                Main.game.player.velocity.x -= 0.3;
                break;

        }
    }
}
