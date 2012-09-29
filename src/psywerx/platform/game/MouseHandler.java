package psywerx.platform.game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    private Game game;

    public MouseHandler(Game g) {
        game = g;
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        System.out.println("Pressed");
    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {
//        game.x = (double) me.getX();
//        game.y = (double) me.getY();
        
        game.objects.add(new GameObject(me.getX(), me.getY()));

    }
}
