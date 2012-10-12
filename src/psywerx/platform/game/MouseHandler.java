package psywerx.platform.game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    public MouseHandler() {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Main.game.objects.add(new GameObject(me.getX(), me.getY()));
    }
}
