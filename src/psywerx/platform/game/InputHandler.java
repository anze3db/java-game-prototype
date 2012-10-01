package psywerx.platform.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    
    public InputHandler(){
    }
    
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case(KeyEvent.VK_DOWN):
                Main.game.player.directionD++;
                break;
            case(KeyEvent.VK_UP):
                Main.game.player.directionU++;
                break;
            case(KeyEvent.VK_LEFT):
                Main.game.player.directionL++;
                break;
            case(KeyEvent.VK_RIGHT):
                Main.game.player.directionR++;
                break;
        }
    } 
    
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case(KeyEvent.VK_DOWN):
                Main.game.player.directionD--;
                break;
            case(KeyEvent.VK_UP):
                Main.game.player.directionU--;
                break;
            case(KeyEvent.VK_LEFT):
                Main.game.player.directionL--;
                break;
            case(KeyEvent.VK_RIGHT):
                Main.game.player.directionR--;
                break;
                
                
        }
    }
}
