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
	 * Get x position.
	 * @return x
	 */
	public int getX();

	/**
	 * Set new x position.
	 */
	public void setX(int x);

	/**
	 * Return y position.
	 * @return y
	 */
	public int getY();

	/**
	 * Set new y position.
	 */
	public void setY(int y);

	/**
	 * Return width of flying object.
	 * @return width
	 */
	public int getWidth(); 

	/**
	 * Return height of flying object.
	 * @return height
	 */
	public int getHeight();

	/**
	 * Paint the image.
	 */
	public void paint(Graphics g2);
}
