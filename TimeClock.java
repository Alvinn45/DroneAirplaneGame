import java.awt.*;
import java.time.*;
import javax.swing.*;

public class TimeClock{
	private ZonedDateTime start;
	
	public TimeClock() {
		Instant now = Instant.now();
		start = now.atZone(ZoneId.of("America/Los_Angeles"));
	}
	
	
	/*
	 * Get offset of time from start for game to check for winner
	 * Uses getTotalSeconds from superclass and redraws label.
	 */
	public String getTime() {
		return Integer.toString(start.getOffset().getTotalSeconds());					// find how to get time elapsed
	}
	
	
	/*
	 * Reset timer by instantiating new ZonedDateTime and repainting.
	 */
	public void reset() {
		start = Instant.now().atZone(ZoneId.of("America/Los_Angeles"));
	}
}
