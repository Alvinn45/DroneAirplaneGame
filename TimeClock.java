import java.util.*;

/*
 * TimeClock is responsible for keeping the time of the current game
 * @author Spencer Enriquez
 */
public class TimeClock{
	
	private Timer clock;
	private int secondsCounter = 0;
	private TimerTask task;
	private String timerFormat;
	
	/*
	 * Create TimeClock object starting at String of '0:00'
	 */
	public TimeClock() {
		clock = new Timer();
		timerFormat = "0:00";
		task = new TimerTask() {
			public void run() {
			secondsCounter++;
			}
		};
	}
	
	/*
	 * Starts TimeClock object with a 1 second delay for run method
	 */
	public void start() {
		clock.schedule(task, 1000, 1000);
	}
	
	
	/*
	 * Sets timerFormat to the current time in the "0:00" format
	 * Uses secondsCounter to find values
	 */
	public String changeTime() {
		String seconds = "" + secondsCounter % 60;
		if (seconds.length() < 2) 
			seconds = "0" + seconds;
		timerFormat = secondsCounter / 60 + ":" + seconds;
		return timerFormat;
	}
	
	public String getTime() {
		return timerFormat;
	}
	
	/*
	 * Reset timer by instantiating new ZonedDateTime and repainting.
	 */
	public void reset() {
		secondsCounter = 0;
		clock = new Timer();
	}
	
	
	/* Tester Frame:
	 * 
	 * JFrame frame = new JFrame();
	      TimeClock time = new TimeClock();
	      time.start();      
	      
	      String text = time.getTime();
	      JLabel label= new JLabel(text);
	      Timer update = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(time.changeTime());
				label.repaint();
			}
	      });
	      update.start();

	      frame.setLayout(new FlowLayout());
	      frame.add(label);

	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.pack();
	      frame.setVisible(true);
	 */
}
