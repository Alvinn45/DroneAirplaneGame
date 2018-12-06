/**
 * Aircraft created by flying object.
 * @author Alvin Nguyen
 */
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public abstract class Aircraft extends JComponent implements Icon {

	private int x;
	private int y;
	private int w;
	private int h;
	private int angle;
	private BufferedImage img;
	
	public Aircraft(int x, int y, String imgFile) {
		this.x = x;
		this.y = y;
		try {
			img = ImageIO.read(new File(imgFile));
			w = img.getWidth();
			h = img.getHeight();
		} catch (IOException io) {
			System.out.println(io);
		}

		if (w == h) {
			angle = 90;
		} else {
			// Switch w and h for non-square images.
			int temp = w;
			w = h;
			h = temp;
			angle = 270;
		}
	}
	
	public void setLocation(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getIconWidth() {  
		return w;
	}  

	public int getIconHeight() {  
		return h;
	}  

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(Math.toRadians(angle), w / 2, h / 2);
		g2.drawImage(img, x, y, null);
	}
}
