/**
 * Flying airplane.
 * @author Alvin Nguyen
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;
 
public class Airplane extends Aircraft {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Airplane(int x, int y, File image) {
		super(x, y, image);
	}
	
	/**
	 * Set new x position.
	 */
	public void setX(int x) {
		this.x = x;
	}
}	
