/**
 * Flying object interface.
 * @author Alvin
 */
import java.awt.*;
import java.util.*;
import javax.swing.*; 

public interface FlyingObject {
	
	/**
	 * Moves the flying object by x and y units.
	 */
	public void move(int x, int y);
	
	/**
	 * Draws the flying object.
	 */
	public void drawFlyingObject(Graphics2D g2);

	/**
	 * Get x position.
	 * @return x
	 */
	public int getX();
	
	/**
	 * Return y position.
	 * @return y
	 */
	public int getY();

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
	
}
