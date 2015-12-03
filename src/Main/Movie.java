package Main;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Movie extends JFrame
{
	final static int WINDOW_WIDTH = 1333;
	final static int WINDOW_HEIGHT = 1000;

	public Movie()
	{
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel());

        setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		
		new Movie();
		
	}
}
