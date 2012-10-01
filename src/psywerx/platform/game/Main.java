package psywerx.platform.game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Main {

    protected static final int WIDTH = 800;
    protected static final int HEIGHT = 250;
    protected static Game game;

    public static void main(String[] args) {

        game = new Game();

        // Create game window...
        JFrame frame = new JFrame();
        frame.setIgnoreRepaint(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create canvas for painting...
        Canvas canvas = new Canvas();
        canvas.setIgnoreRepaint(true);
        canvas.setSize(WIDTH, HEIGHT);

        canvas.addKeyListener(new InputHandler());
        canvas.addMouseListener(new MouseHandler());

        // Add canvas to game window...
        frame.add(canvas);

        frame.pack();
        frame.setVisible(true);

        // Create BackBuffer...
        canvas.createBufferStrategy(2);
        BufferStrategy buffer = canvas.getBufferStrategy();

        // Get graphics configuration...
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();

        // Create off-screen drawing surface
        BufferedImage bi = gc.createCompatibleImage(WIDTH, HEIGHT);
        // Objects needed for rendering...
        Graphics graphics = null;
        Graphics2D g = null;

        // Variables for counting frames per seconds
        long delta = 0;
        long curTime = System.currentTimeMillis();
        long lastTime = curTime;

        // Main game loop
        while (true) {
            try {
                lastTime = curTime;
                curTime = System.currentTimeMillis();
                delta = curTime - lastTime;

                // clear back buffer...
                g = bi.createGraphics();

                game.tick(delta);
                game.render(g);

                // Blit image and flip...
                graphics = buffer.getDrawGraphics();
                graphics.drawImage(bi, 0, 0, null);
                if (!buffer.contentsLost()) buffer.show();

                // Let the OS have a little time...
                Thread.yield();
            } finally {
                // release resources
                if (graphics != null) graphics.dispose();
                if (g != null) g.dispose();
            }
        }
    }
}
