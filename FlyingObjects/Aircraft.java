/**
 * Aircraft created by flying object.
 * @author Alvin Nguyen
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class Aircraft implements FlyingObject {

	private int x;
	private int y;
	private File image;
	
	public Aircraft(int x, int y, File image) {
		this.x = x;
		this.y = y;
		this.image = image;
	}
	
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
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

	public void drawFlyingObject(Graphics2D g2) {
		// Import image.
		BufferedImage img = null;
		try {
			img = ImageIO.read(image);
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
