/**
 * Flying Drone.
 * @author Alvin Nguyen
 */
public class Drone extends Aircraft {
	
	private int lives;

	public Drone(int x, int y, String imgFile) {
		super(x, y, imgFile);
	}

	/**
	 * Set the number of lives for the drone.
	 * @param lives
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}

	/**
	 * Retrieve number of lives from the drone.
	 * @return lives
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * Add a life point to the drone.
	 */
	public void addLife() {
		lives++;
	}

	/**
	 * Subtract a life point from the drone.
	 */
	public void subtractLife() {
		lives--;
	}
}
