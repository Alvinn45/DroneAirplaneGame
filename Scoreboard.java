import java.util.*;

public class Scoreboard {
	
	private ArrayList<Boolean> games;
	private String scoreFormat;
	public static final int  WIN_TIME = 90;
	public static final int WIN_LIVES_LEFT = 0;

	public Scoreboard() {
		games = new ArrayList<Boolean>();
		scoreFormat = "Score: 0 out of 0";
	}
	
	
	/*
	 * Returns number of wins within arraylist to help format
	 */
	public int getWins() {
		int counter = 0;
		for (boolean game : games) {
			if (game == true)
				counter++;
		}
		return counter;
	}
	
	
	/*
	 * Sets score to current score format
	 */
	public void setScore() {
		scoreFormat = "Score: " + this.getWins() + " out of " + games.size();
	}
	
	
	/*
	 * Checks for win conditions or time and lives left
	 * Meant to be checked every second or every time drone is hit
	 */
	public boolean addScore(TimeClock time, Drone drone) {
		if (time.getSeconds() == WIN_TIME || drone.getLives() > WIN_LIVES_LEFT) {
			games.add(true);
			return true;
		}
		else if (time.getSeconds() < WIN_TIME && drone.getLives() <= WIN_LIVES_LEFT) {
			games.add(false);
		}
		return false;
	}
}
