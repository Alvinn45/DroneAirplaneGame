/**
 * Aircraft created by flying object.
 * @author Alvin Nguyen
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class Aircraft implements FlyingObject {

	private int x;
	private int y;
	
	public Aircraft(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void drawIcon(Graphics2D g2);
}
