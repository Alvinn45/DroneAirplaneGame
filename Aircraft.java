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

public abstract class Aircraft implements FlyingObject {

	private int x;
	private int y;
	private int w;
	private int h;
	private String imgFile;
	private BufferedImage img;
	
	public Aircraft(int x, int y, String imgFile) {
		this.x = x;
		this.y = y;
		this.imgFile = imgFile;
		img = null;
		try {
			img = ImageIO.read(new File(imgFile));
			w = img.getWidth();
			h = img.getHeight();
		} catch (IOException io) {
			System.out.println(io);
		}
	}
	
	public void move(int x, int y) {
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

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public void paint(Graphics g2) {
		g2.drawImage(img, x, y, null);
	}
}
