package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Ball 
{
	public BufferedImage kanye;
	private int y = Movie.WINDOW_HEIGHT / 2;
    private int x = Movie.WINDOW_WIDTH / 2;
    private int yVelocity = 0;
    private int xVelocity = 0;
    private int width = 10;
    private int height = 40;
    private int size = 20;
    int point = 0;
    int highscore = 0;

    
   
    
    public Ball() {
    	URL resource = getClass().getResource("kanye.png");
		try {
			kanye = ImageIO.read(resource);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }

    public void update() {
    	x = x + xVelocity;
        y = y + yVelocity;
    }

    public void paint(Graphics g) {
    	g.drawImage(kanye, x, y, 150, 220, null);
    	g.setColor(Color.white);
        g.drawString(points(), 5, 15);
        g.drawString(highScore(), 5, 35);
    }
    
    public void checkCollisionWith(Object1 object1) 
    {
        if (this.x > object1.getX()-object1.getWidth() && this.x < object1.getX() + object1.getWidth()) {
            if (this.y > object1.getY()-object1.getHeight() && this.y < object1.getY() + object1.getHeight()) {
                point=0;
            }
        }
        else
        {
        	point+=5;
        }
    }
    public void checkCollisionWith(Object2 object2) 
    {
        if (this.x > object2.getX()-object2.getWidth() && this.x < object2.getX() + object2.getWidth()) {
            if (this.y > object2.getY()-object2.getHeight() && this.y < object2.getY() + object2.getHeight()) {
                point=0;
                
            }
        }
        else
        {
        	point+=1;
        }
    }
    
    public void setYVelocity(int speed) {
        yVelocity = speed;
    }
    public void setXVelocity(int speed)
    {
    	xVelocity = speed;
    }
    public String points()
    {
    	String points = "";
    	points = "Points: " + point;
    	return points;
    }
    public String highScore()
    {
    	String highScore = "";
    	if (point > highscore)
    		highscore = point;
    	highScore = "HIGH SCORE: " + highscore;
    	return highScore;
    	
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
