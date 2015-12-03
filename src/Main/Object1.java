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
public class Object1 {

    public BufferedImage camera1;
	private GamePanel field;
    private int y = 0;    
    private int x = 0;
    private int xVelocity = 0;
    private int yVelocity = 0;
    private int width = 100;
    private int height = 100;

    public Object1(GamePanel game)
    {
    	this.field = game;
    	URL resource = getClass().getResource("camera1.png");
		try {
			camera1 = ImageIO.read(resource);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    public void update() 
    {
   		if (x > (Movie.WINDOW_WIDTH-20))
   			xVelocity = -25;
  		else if (x < 10)
   			xVelocity = 25;
   		x = x + xVelocity;
    	if (y < 10)
   			yVelocity = 25;
   		if (y > (Movie.WINDOW_HEIGHT-10))
   			yVelocity = -25;
        y = y + yVelocity;
    }

    public void paint(Graphics g) {
        g.drawImage(camera1, x, y, 100, 100, null);
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

