/**
 * Create hitbox boundaries for aircraft.
 * @author Alvin Nguyen
 */
import java.awt.geom.Rectangle2D;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class RectangleHitbox extends Rectangle2D.Double {

	private Aircraft ac;

	public RectangleHitbox(Aircraft ac) {
		super(ac.getX(), ac.getY(),
			ac.getX() + ac.getIconWidth(),
			ac.getY() + ac.getIconHeight());
	}
}
