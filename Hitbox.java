/**
 * Create hitbox shape for aircraft.
 * @author Alvin Nguyen
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Hitbox {

	private Aircraft ac;
	private boolean collided;

	// 0 = xMin, 1 = xMax, 2 = yMin, 3 = yMax.
	private int[] bounds = new int[4];

	// x-axis Measurements 
	private int xMin;
	private int xMax;
	private double xUnit;

	// y-axis Measurements
	private int yMin;
	private int yMax;
	private double yUnit;

	public Hitbox(Aircraft ac) {
		// Set aircraft.
		this.ac = ac;
		collided = false;

		// Define bounds of hitbox.
		xMin = ac.getX();
		yMin = ac.getY();
		xMax = ac.getIconWidth();
		yMax = ac.getIconHeight();

		// Store bounds into an array.
		bounds[0] = xMin;
		bounds[1] = xMax; 
		bounds[2] = yMin; 
		bounds[3] = yMax; 

		// Create units.
		// xUnit = xMax / 16;
		// yUnit = yMax / 16;

		// Use measurements to create hitbox.
		// drawHitbox();
	}
	
	/**
	 * Return array with x and y bounds.
	 * @return bounds measurements
	 */
	public int[] getBounds() {
		return bounds;
	}

	/**
	 * Return whether hitbox has collided with another aircraft.
	 * @return boolean
	 */
	public boolean hasCollided(Hitbox other) {
		// Create arrays that store the measurements of other's hitboxes.
		int[] otherBounds = other.getBounds();

		/*
		 * Compare each x and y bounds.
		 * Collision occurs when comparisons are true.
		 * compBounds[0] = this.xMin ≥ other.xMax;
		 * compBounds[1] = this.xMax ≥ other.xMin;
		 * compBounds[2] = this.yMin ≤ other.yMax;
		 * compBounds[3] = this.yMax ≥ other.yMin;
		 */
		boolean[] compBounds = new boolean[4];
		compBounds[0] = bounds[0] >= otherBounds[1];
		compBounds[1] = bounds[1] >= otherBounds[0];
		compBounds[2] = bounds[2] <= otherBounds[3];
		compBounds[3] = bounds[3] >= otherBounds[4];
		
		/*
		 * Collision Conditions:
		 * Let the h1 be the current hitbox, and h2 be the other hitbox.
		 * Assume h1 and h2 are moving towards each other.
		 * Let T be the top bound, B be the bottom bound,
		 *    L be the left bound, and R be right bound of the hitbox.
		 * 1. If h1.L < h2.R & h1.R < h2.L,
		 *    then no collision.
		 * 2. If h1.L < h2.R & h1.R ≥ h2.L,
		 *    and h1.B ≤ h2.T / h1.T ≥ h2.B,
		 *    then collision.
		 * 3. If h1.L < h2.R & h1.R ≥ h2.L,
		 *    and h1.B > h2.T / h1.T < h2.B,
		 *    then no collision.
		 * 4. If h1.L ≥ h2.R & h1.R ≥ h2.L,
		 *    and h1.B ≤ h2.T / h1.T ≥ h2.B,
		 *    then collision.
		 * 5. If h1.L ≥ h2.R & h1.R ≥ h2.L,
		 *    and h1.B > h2.T / h1.T < h2.B,
		 *    then no collision.
		 * 6. Since h1 and h2 cannot move in reverse,
		 *    h1.L ≥ h2.R & h1.R < h2.L can never be true,
		 *    so there is no collision for this condition.
		 */
		if (compBounds[0] == false && compBounds[1] == false) {
			return false; // Condition 1	
		} else if (compBounds[0] == false && compBounds[1] == true) {
			if (compBounds[2] == true || compBounds[3] == true) {
				return true; // Condition 2
			} else {
				return false; // Condition 3
			}
		} else if (compBounds[0] == true && compBounds[1] == true) {
			if (compBounds[2] == true || compBounds[3] == true) {
				return true; // Condition 4
			} else {
				return false; // Condition 5
			}
		} else {
			return false; // Condition 6
		}
	}

	/**
	 * Choose hitbox to draw depending on aircraft.
	 */
	public void drawHitbox() {
		if (xMax != yMax) {
			//planeHitbox();
		} else {
			//droneHitbox();
		}
	}

	/**
	 * Square hitbox for drone.
	 */
	public void droneHitbox(Graphics2D g2) {
		Rectangle.Double body =
			new Rectangle.Double(xMin, yMin, xMax, yMax);
		g2.draw(body);
	}

	/**
	 * Airplane Hitbox Reference:
	 *  _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|*|*|*|*|*|*|*|*|*|*|*|*|*|*|
	 * |_|_|*|*|*|*|*|*|*|*|*|*|*|*|*|*|
	 * |_|_|*|*|*|*|*|*|*|*|*|*|*|*|*|*|
	 * |_|_|*|*|*|*|*|*|*|*|*|*|*|*|*|*|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 * |_|_|_|_|*|*|*|*|_|_|_|_|_|_|_|_|
	 *
	 * Composite hitbox in 16 x 16 grid.
	 * @param Graphics2D
	 */
	private void planeHitbox(Graphics2D g2) {
		Rectangle.Double wing =
			new Rectangle.Double(xMin, yMin, xMax / 2, yMax);
		Rectangle.Double tail =
			new Rectangle.Double(xMin, yMin, xMax, yMax / 2);
		g2.draw(wing);
		g2.draw(tail);
	}
}
