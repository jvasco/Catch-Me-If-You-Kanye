package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 *
 * @author Max
 */
public class Object2 {

	public BufferedImage camera2;
    private GamePanel field;
    private int x = Movie.WINDOW_WIDTH;
    private int y = 0;
    private int yVelocity = 0;
    private int xVelocity = 0;
    private int width = 100;
    private int height = 100;

    public Object2(GamePanel game)
    {
    	this.field = game;
    	URL resource = getClass().getResource("camera2.png");
		try {
			camera2 = ImageIO.read(resource);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    public void update() {
    	if (x > (Movie.WINDOW_WIDTH-20))
   			xVelocity = -27;
  		else if (x < 10)
   			xVelocity = 27;
   		x = x + xVelocity;
    	if (y < 10)
   			yVelocity = 27;
   		if (y > (Movie.WINDOW_HEIGHT-10))
   			yVelocity = -27;
        y = y + yVelocity;
        
    }

    public void paint(Graphics g) {
        g.drawImage(camera2, x, y, 100, 100, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

