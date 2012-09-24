package psywerx.platform.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    
    private Game game;
    private int pressedKeys = 0;

    public InputHandler(Game g){
        game = g;
    }
    
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case(KeyEvent.VK_LEFT):
                pressedKeys++;
                game.direction = -1;
                break;
            case(KeyEvent.VK_RIGHT):
                pressedKeys++;
                game.direction = 1;
                break;
        }
    } 
    
    public void keyReleased(KeyEvent e) {
        if(pressedKeys-- == 0);
            game.direction = 0;
    }
}
