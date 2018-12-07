/**
 * Count wins and total games.
 * @author Spencer Enriquez 
 * @author Alvin Nguyen 
 */
import java.util.*;

public class Scoreboard2 {
	
	private int wonGames;
	private int totalGames;
	private String scoreFormat;
	public final int WIN_TIME = 5;
	public final int WIN_LIVES_LEFT = 0;

	public Scoreboard2() {
		wonGames = 0;
		totalGames = 0;
		scoreFormat = setScore();
	}
	
	
	/**
	 * Return number of won games.
	 * @return wonGames
	 */
	public int getWins() {
		return wonGames;
	}
	
	/**
	 * Return number of total games played.
	 * @return totalGames
	 */
	public int getTotalGames() {
		return totalGames;
	}

	/**
	 * Return number of loss games.
	 * @return totalGames - wonGames
	 */
	public int getLosses() {
		return totalGames - wonGames;
	}

	/**
	 * Return time to win a game.
	 * @return WIN_TIME
	 */
	public int getWinTime() {
		return WIN_TIME;
	}

	/**
	 * Return number of lives before game over.
	 * @return WIN_LIVES_LEFT 
	 */
	public int getWinLivesLeft() {
		return WIN_LIVES_LEFT;
	}	
	
	/**
	 * Sets score to current score format
	 * @return scoreFormat
	 */
	public String setScore() {
		scoreFormat = "Score: " + wonGames
			 + " out of " + totalGames;
		return scoreFormat;
	}
	
	/**
	 * Checks for win conditions or time and lives left every second
	 * Meant to be checked every second or every time drone is hit
	 * Assumed that Drone starts with positive amount of lives.
	 * @param time
	 * @param drone
	 */
	public void checkScore(TimeClock time, Drone drone) {
		if (time.getSeconds() == WIN_TIME
				&& drone.getLives() > WIN_LIVES_LEFT) {
			totalGames++;
			wonGames++;
		} else if (time.getSeconds() < WIN_TIME
				&& drone.getLives() <= WIN_LIVES_LEFT) {
			totalGames++;
		}
	}
}
