/**
 * Create hitbox boundaries for aircraft.
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

	// y-axis Measurements
	private int yMin;
	private int yMax;

	public Hitbox(Aircraft ac) {
		// Set aircraft.
		this.ac = ac;
		collided = false;
		setHitbox();
	}
	
	/**
	 * Set hitbox of the aircraft.
	 */
	private void setHitbox() {
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
	}

	/**
	 * Print array with x and y bounds.
	 * @return String bounds 
	 */
	public String printBounds() {
		return "xMin: " + bounds[0] + "\n"
			+ "xMin: " + bounds[0] + "\n"
			+ "yMax: " + bounds[2] + "\n"
			+ "yMax: " + bounds[3];
	}

	/**
	 * Return array with x and y bounds.
	 * @return bounds
	 */
	public int[] getBounds() {
		return bounds;
	}

	/**
	 * Reset bounds of hitbox after movement.
	 */
	public void resetBounds() {
		setHitbox();
	}
	
	/**
	 * Return collided value.
	 * @return collided
	 */
	public boolean getCollided() {
		return collided;
	}

	/**
	 * Set collided to new boolean value.
	 * @param boolean
	 */
	public void setCollided(boolean b) {
		collided = b;
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
		 * compBounds[0] = this.xMin ≤ other.xMax;
		 * compBounds[1] = this.xMax ≤ other.xMin;
		 * compBounds[2] = this.yMin ≤ other.yMax;
		 * compBounds[3] = this.yMax ≥ other.yMin;
		 */
		boolean[] compBounds = new boolean[4];
		compBounds[0] = bounds[0] <= otherBounds[1];
		compBounds[1] = bounds[1] <= otherBounds[0];
		compBounds[2] = bounds[2] <= otherBounds[3];
		compBounds[3] = bounds[3] >= otherBounds[2];
		
		/*
		 * Collision Conditions:
		 * Let the h1 be the current hitbox, and h2 be the other hitbox.
		 * Assume h1 and h2 are moving towards each other.
		 * Let T be the top bound, B be the bottom bound,
		 *    L be the left bound, and R be right bound of the hitbox.
		 *
		 * 1. Hitboxes passed each other.
		 *    If h1.L > h2.R & h1.R < h2.L,
		 *    then no collision.
		 *
		 * 2. Before hitboxes completely pass each other,
		 *    top or bottom bound of each hitboxes converge.
		 *    If h1.L < h2.R & h1.R ≥ h2.L,
		 *    and h1.B ≤ h2.T / h1.T ≥ h2.B,
		 *    then collision.
		 *
		 * 3. Before hitboxes completely pass each other,
		 *    top or bottom bound of each hitboxes do not converge.
		 *    If h1.L < h2.R & h1.R ≥ h2.L,
		 *    and h1.B > h2.T / h1.T < h2.B,
		 *    then no collision.
		 *
		 * 4. Before hitboxes pass each other vertically,
		 *    top or bottom bound of each hitboxes converge.
		 *    If h1.L ≥ h2.R & h1.R ≥ h2.L,
		 *    and h1.B ≤ h2.T / h1.T ≥ h2.B,
		 *    then collision.
		 *
		 * 5. Before hitboxes pass each other vertically,
		 *    top or bottom bound of each hitboxes converge.
		 *    If h1.L ≥ h2.R & h1.R ≥ h2.L,
		 *    and h1.B > h2.T / h1.T < h2.B,
		 *    then no collision.
		 *
		 * 6. While hitboxes has not pass each other in any direction,
		 *    but are in front of each other, then no collision.
		 *    If h1.L < h2.R & h1.R < h2.L,
		 *    and h1.B > h2.T / h1.T < h2.B,
		 *    then no collision.
		 */
		if (compBounds[0] == false && compBounds[1] == false) {
			collided = false; // Condition 1	
			other.setCollided(false);
		} else if (compBounds[0] == false && compBounds[1] == true) {
			if (compBounds[2] == true || compBounds[3] == true) {
				collided = true; // Condition 2
				other.setCollided(true);
			} else {
				collided = false; // Condition 3
				other.setCollided(false);
			}
		} else if (compBounds[0] == true && compBounds[1] == true) {
			if (compBounds[2] == true || compBounds[3] == true) {
				collided = true; // Condition 4
				other.setCollided(true);
			} else {
				collided = false; // Condition 5
				other.setCollided(false);
			}
		} else {
			collided = false; // Condition 6
			other.setCollided(false);
		}
		return collided;
	}
}
