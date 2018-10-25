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
	
	public Drone(int x, int y, File image) {
		super(x, y, image);
	}
	
	/**
	 * Set new y position.
	 */
	public void setY(int y) {
		this.y = y;
	}
 }
