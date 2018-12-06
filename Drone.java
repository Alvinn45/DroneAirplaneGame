/**
 * Flying Drone.
 * @author Alvin Nguyen
 */
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
 
public class Drone extends Aircraft {
	
	private int lives;

	public Drone(int x, int y, String imgFile) {
		super(x, y, imgFile);
		lives = 2;
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
	
		public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP){
			setLocation(0,getY() + 5);
		}else if(key == KeyEvent.VK_DOWN){
			setLocation(0,getY()-5);
		}else if(key == KeyEvent.VK_RIGHT){
			setLocation(getX() +5,0);
		}else if(key == KeyEvent.VK_LEFT){
			setLocation(getX()-5,0);
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP){
			setLocation(0,0);
		}else if(key == KeyEvent.VK_DOWN){
			setLocation(0,0);
		}else if(key == KeyEvent.VK_RIGHT){
			setLocation(0,0);
		}else if(key == KeyEvent.VK_LEFT){
			setLocation(0,0);
		}
	}
}
