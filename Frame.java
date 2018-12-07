import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Frame extends JFrame {

	private final Dimension MAX_FRAME = new Dimension(1920, 1080);
	private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 1000;
	private final Color lightblue = new Color(51,204,255);
	//private final int FRAME_SIZE = 1000;
	
	public Frame() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		// Add title.
		JPanel top = new JPanel();
		JLabel label = new JLabel("Start");
		top.add(label);

		// Add drone.
		JPanel skyField = new JPanel();
		skyField.setLayout(null);
		skyField.setPreferredSize(MAX_FRAME);
		skyField.setBackground(lightblue);
		Drone drn = new Drone(FRAME_WIDTH / 4, FRAME_HEIGHT / 4,
			"src/drone.png");
		JLabel dLabel = new JLabel(drn);
		skyField.add(dLabel);
		dLabel.setBounds(drn.getX(), drn.getY(),
				drn.getIconWidth(), drn.getIconHeight());

		// Add enemy planes.
		ArrayList<Aircraft> planes = new ArrayList<>();
		ArrayList<JLabel>  planeLabels = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			int adjust = (int)(Math.random() * FRAME_WIDTH / 2);
			planes.add(new Plane(FRAME_WIDTH + adjust,
					i * 10 + adjust,
					"src/airplane.png"));
			planeLabels.add(new JLabel(planes.get(i)));
			planeLabels.get(i).setBounds(planes.get(i).getX(),
						planes.get(i).getY(),
						planes.get(i).getIconWidth(),
						planes.get(i).getIconHeight());
		}
		Timer updateMovement = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dLabel.setLocation(drn.getX() + 1, drn.getY());
				for (int i = 0; i < planeLabels.size(); i++) {
					planeLabels.get(i).setLocation(planes.get(i).getX() - 1, planes.get(i).getY());
				}
			}
		});
		updateMovement.start();

		
		//add Scoreboard and TimeClock
		 TimeClock time = new TimeClock();	      
	      Scoreboard scores = new Scoreboard();
	      JLabel scoreLabel = new JLabel(scores.setScore());
	      
	      String text = time.getTimeFormat();
	      JLabel timeLabel= new JLabel(text);
	      Timer updateConditions = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time.addSecond();
				scores.checkScore(time, drn);
				scoreLabel.setText(scores.setScore());
				if (time.getSeconds() >= 90)
					time.reset();
				timeLabel.setText(time.changeTime());
			}
	      });
	      updateConditions.start();

		for (JLabel pl : planeLabels) skyField.add(pl);
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));


		bottom.add(timeLabel);
		bottom.add(scoreLabel);

		skyField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_UP) {
					dLabel.setLocation(drn.getX(), drn.getY() - 10);
					
				} else if(key == KeyEvent.VK_DOWN) {
					dLabel.setLocation(drn.getX(), drn.getY() + 10);
				} else if(key == KeyEvent.VK_RIGHT) {
					dLabel.setLocation(drn.getX() + 10, drn.getY());
				} else if(key == KeyEvent.VK_LEFT) {
					dLabel.setLocation(drn.getX() - 10, drn.getY());
				}
				drn.setX(dLabel.getX());
				drn.setY(dLabel.getY());
			}

			
			@Override
			public void keyReleased(KeyEvent e) {
				drn.setX(dLabel.getX());
				drn.setY(dLabel.getY());
			}
		});
		skyField.setFocusable(true);

		// Add timer movement to each enemy plane.
		final int DELAY = 10;
		Timer t = new Timer(DELAY, event -> {
			for (Aircraft pl : planes) {
				if (pl.getX() < 100) pl.setX(FRAME_WIDTH);
				pl.setLocation(-5, 0);
			}
			for (JLabel pl : planeLabels)
				pl.repaint();
		});
		t.start();

		// Combine all panels into single panel.
		panel.add(top);
		panel.add(skyField);
		panel.add(bottom);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(new Dimension(FRAME_SIZE, FRAME_SIZE));
		this.setSize(MAX_FRAME);
		this.getContentPane().add(panel);
		this.setVisible(true);
	}

	public static void sop(Object o) {
		System.out.println(o);
	}
}
