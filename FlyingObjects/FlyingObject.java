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
	public void drawIcon(Graphics2D g2);
}
