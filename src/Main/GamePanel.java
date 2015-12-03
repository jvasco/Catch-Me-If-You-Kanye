package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, KeyListener
{
	Ball ball = new Ball();
	private BufferedImage photo;
	Object1 object1 = new Object1(this);
	Object2 object2 = new Object2(this);
	public GamePanel()
	{
		
		Timer time = new Timer(50, this);
        time.start();
        
	    this.addKeyListener(this);
	    this.setFocusable(true);
	    URL resource = getClass().getResource("photo.jpg");
		try {
			photo = ImageIO.read(resource);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    
    }
	
	private void update()
	{
		ball.update();
		object1.update();
		object2.update();
		
		ball.checkCollisionWith(object1);
        ball.checkCollisionWith(object2);
	}
	public void paintComponent(Graphics g)
	{
		
	    
	     g.setColor(Color.black);
	     g.drawImage(photo, 0, 0, Movie.WINDOW_WIDTH, Movie.WINDOW_HEIGHT, null);
	     ball.paint(g);
	     object1.paint(g);
	     object2.paint(g);
	   }
	
	public Ball getBall()
	{
		return ball;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		update();
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
        if (e.getKeyCode() == KeyEvent.VK_UP) 
        {
            if (ball.getY() < 20) 
            {
                ball.setYVelocity(0);
            }
            else
                ball.setYVelocity(-20);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN) 
        {
           
            if (ball.getY() > Movie.WINDOW_HEIGHT-30) 
            {
                ball.setYVelocity(0);
            }
            else
            	ball.setYVelocity(20);
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
        	if(ball.getX()<20)
        	{
        		ball.setXVelocity(0);
        	}
        	else
            	ball.setXVelocity(-20);
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
        	if(ball.getX()>Movie.WINDOW_WIDTH-20)
        	{
        		ball.setXVelocity(0);
        	}
        	else
            	ball.setXVelocity(20 );
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) 
        {
            ball.setYVelocity(0);
            ball.setXVelocity(0);
        }
    }
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
