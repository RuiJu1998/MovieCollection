import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Background extends JPanel{
	
public static BufferedImage background; 
	
	static { 
		  try { 
		   background = ImageIO.read(Background.class
		     .getResource("background.jpg")); 
		  } catch (Exception e) { 
		   e.printStackTrace(); 
		  } 
		 } 
	public Background() {
		super();
	}
	
	@Override
	 public void paintComponent(Graphics g) { 
	  super.paintComponent(g);
	  g.drawImage(background, 0, 0, 1200, 720, null);  
	 } 


}
