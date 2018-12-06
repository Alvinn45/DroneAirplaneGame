import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class Frame extends JFrame {

	private final int FRAME_SIZE = 1000;
	private final Color lightblue = new Color(51,204,255);

	public void create() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		// Add title.
		JPanel top = new JPanel();
		JLabel label = new JLabel("Start");
		top.add(label);

		// Add drone.
		JPanel skyfield = new JPanel();
		skyfield.setPreferredSize(new Dimension(FRAME_SIZE, FRAME_SIZE));
		skyfield.setBackground(lightblue);
		Drone drn = new Drone(FRAME_SIZE / 4, FRAME_SIZE / 2,
			"drone.png");
		JLabel dLabel = new JLabel(drn);
		skyfield.add(dLabel);

		// Add enemy planes.
		ArrayList<Aircraft> planes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			planes.add(new Plane(FRAME_SIZE, i * 10,
				"airplane.png"));
		}
		JLabel pLabel_1 = new JLabel(planes.get(0));
		JLabel pLabel_2 = new JLabel(planes.get(1));
		JLabel pLabel_3 = new JLabel(planes.get(2));
		skyfield.add(pLabel_1);
		skyfield.add(pLabel_2);
		skyfield.add(pLabel_3);
		
		TimeClock time = new TimeClock();
		Scoreboard scores = new Scoreboard();
	      JLabel scoreLabel = new JLabel(scores.setScore());
	      
	      String text = time.getTimeFormat();
	      JLabel timeLabel= new JLabel(text);
	      Timer update = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time.addSecond();
				scores.checkScore(time, drn);
				scoreLabel.setText(scores.setScore());
				scoreLabel.repaint();
				if (time.getSeconds() >= 90)
					time.reset();
				timeLabel.setText(time.changeTime());
				timeLabel.repaint();
			}
	      });
	      update.start();
		

		// Add buttons.
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton up = new JButton("Up");
		JButton down = new JButton("Down");
		//JButton shoot = new JButton("Shoot/space");

		bottom.add(timeLabel);
		bottom.add(up);
		bottom.add(down);
		bottom.add(scoreLabel);
		//bottom.add(shoot);

		// Add action listeners to buttons.

		// Combine all panels into single panel.
		panel.add(top);
		panel.add(skyfield);
		panel.add(bottom);

		this.setSize(FRAME_SIZE, FRAME_SIZE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
}
