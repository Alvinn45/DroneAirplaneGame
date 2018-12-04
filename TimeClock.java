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
	 * public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      TimeClock time = new TimeClock();
      time.start();      
      
      Drone drone = new Drone(100,100, "drone.png");
      
      Scoreboard scores = new Scoreboard();
      JLabel scoreLabel = new JLabel(scores.setScore());
      
      String text = time.getTimeFormat();
      JLabel label= new JLabel(text);
      Timer update = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			scores.checkScore(time, drone);
			scoreLabel.setText(scores.setScore());
			scoreLabel.repaint();
			if (time.getSeconds() >= 90)
				time.reset();
			label.setText(time.changeTime());
			label.repaint();
		}
      });
      update.start();
      
      frame.setLayout(new FlowLayout());
      frame.add(scoreLabel);
      frame.add(label);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
	 */
}
