/**
 * Flying Drone.
 * @author Alvin Nguyen
 */
 import java.awt.*;
 import java.util.*;
 import javax.swing.*;
 
 public class Drone extends Aircraft {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Drone(int x, int y) {
		super(x, y);
		width = 0;
		height = 0;
	}
	
	/**
	 * Return y position.
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set new y position.
	 */
	public void setY(int y) {
		this.y = y;
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
		// Import drone image.
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("drone.png"));
		} catch (IOException e) {
			System.out.println(e);
		}

		// Create filter for image.
		width = img.getWidth(null);
		height = img.getHeight(null);
		BufferedImage bi = new
			BufferedImage(weight, height,
					BufferedImage.TYPE_INT_RGB);
		
		// Draw image as icon.
		g2.drawImage(img, bi, this.x, this.y);
	}
 }
