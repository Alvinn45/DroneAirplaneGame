/**
 * Create hitbox shape for aircraft.
 * @author Alvin Nguyen
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Hitbox {

	private Aircraft obj;
	private boolean collided;
	private int xMin;
	private int xMax;
	private int yMin;
	private int yMax;
	
	public Hitbox(Aircraft obj) {
		this.obj = obj;
		collided = false;
		createHitbox();
	}
	
	/**
	 * Return whether hitbox has collided with another object.
	 * @return boolean
	 */
	public boolean hasCollided(Aircraft o) {
		return collided;
	}

	/**
	 * Create a hitbox for object.
	 */
	public void createHitbox() {
		// Define bounds of hitbox.
		// Use size of image.

		// Build initial hitbox.

		// Initiate hitbox with no color.
	}

	/**
	 * Add additional hitbox to object.
	 */
	public void addHitbox() {

	}
}
