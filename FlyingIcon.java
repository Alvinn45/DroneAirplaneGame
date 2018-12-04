/**
 * Use a flying object as an image icon.
 * @author Alvin Nguyen
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class FlyingIcon implements Icon {

	private int width;
	private int height;
	private FlyingObject flyer;

	public FlyingIcon(FlyingObject flyer) {
		this.flyer = flyer;
		this.width = flyer.getWidth();
		this.height = flyer.getHeight();
	}  

	public int getIconWidth() {  
		return width;
	}  

	public int getIconHeight() {  
		return height;
	}  

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		flyer.paint(g2);
	}
}
