/**
 * Flying airplane.
 * @author Alvin Nguyen
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;
 
public class Airplane extends Aircraft {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Airplane(int x, int y) {
		super(x, y);
		width = 0;
		height = 0;
	}
	
	/**
	 * Get x position.
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Set new x position.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Return width of drone.
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Return height of drone.
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	public void drawIcon(Graphics2D g2) {
		// Import Airplane image
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("plane.png"));
		} catch (IOException e) {
			System.out.println(e);
		}
		
		// Create filter for image.
		width = img.getWidth(null);
		height = img.getHeight(null);
		BufferedImage bi = new
			BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
		
		// Draw image as icon.
		g2.drawImage(img, bi, this.x, this.y);
	}
 }
