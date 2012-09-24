package psywerx.platform.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    
    private Game game;

    public InputHandler(Game g){
        game = g;
    }
    
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case(KeyEvent.VK_DOWN):
                game.directionD++;
                break;
            case(KeyEvent.VK_UP):
                game.directionU++;
                break;
            case(KeyEvent.VK_LEFT):
                game.directionL++;
                break;
            case(KeyEvent.VK_RIGHT):
                game.directionR++;
                break;
        }
    } 
    
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case(KeyEvent.VK_DOWN):
                game.directionD--;
                break;
            case(KeyEvent.VK_UP):
                game.directionU--;
                break;
            case(KeyEvent.VK_LEFT):
                game.directionL--;
                break;
            case(KeyEvent.VK_RIGHT):
                game.directionR--;
                break;
        }
        
    }
}
