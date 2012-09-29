package psywerx.platform.game;

public class GameObject {

    protected double x, y;
    protected int centerX, centerY;
    protected int size = 10;
    
    public GameObject(int x2, int y2) {
        x = (double) ((x2/size)*size);
        y = (double) ((y2/size)*size);
        centerX = (int) (x + size/2);
        centerY = (int) (y + size/2);
    }

}
