import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Frame extends JFrame {

	private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 1000;
	private final Dimension MAX_FRAME = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
	private final Color lightblue = new Color(51,204,255);
	
	public Frame() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		// Add title.
		JPanel top = new JPanel();
		JLabel label = new JLabel("Welcome to the Drone Survival Game!");
		top.add(label);

		// Add drone.
		JPanel skyField = new JPanel();
		skyField.setLayout(null);
		skyField.setPreferredSize(MAX_FRAME);
		skyField.setBackground(lightblue);
		Drone drn = new Drone(FRAME_WIDTH / 4, FRAME_HEIGHT / 4,
			"drone.png");
		JLabel dLabel = new JLabel(drn);
		skyField.add(dLabel);
		dLabel.setBounds(drn.getX(), drn.getY(),
				drn.getIconWidth(), drn.getIconHeight());
		Hitbox dHitbox = new Hitbox(drn);
		//sop(dHitbox.printBounds());

		// Add enemy planes.
		ArrayList<Aircraft> planes = new ArrayList<>();
		ArrayList<JLabel>  planeLabels = new ArrayList<>();
		ArrayList<Hitbox>  planeHitboxes = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			int adjust = (int)(Math.random() * FRAME_WIDTH / 2);
			planes.add(new Plane(FRAME_WIDTH + adjust,
					i * 10 + adjust,
					"airplane.png"));
			planeLabels.add(new JLabel(planes.get(i)));
			planeLabels.get(i).setBounds(planes.get(i).getX(),
						planes.get(i).getY(),
						planes.get(i).getIconWidth(),
						planes.get(i).getIconHeight());
			planeHitboxes.add(new Hitbox(planes.get(i)));
			//for (Hitbox ph : planeHitboxes) sop(ph.printBounds());
		}
		
		// Add Scoreboard and TimeClock
		TimeClock time = new TimeClock();	      
		Scoreboard2 scores = new Scoreboard2();
		JLabel scoreLabel = new JLabel(scores.setScore());
		JLabel timeLabel= new JLabel(time.getTimeFormat());
		Timer updateConditions = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time.addSecond();
				if (time.getSeconds() >= scores.getWinTime())
					time.reset();
				scores.checkScore(time, drn);
				sop("WINS: " + scores.getWins());
				sop("TOTAL: " + scores.getTotalGames());
				scoreLabel.setText(scores.setScore());
				timeLabel.setText(time.changeTime());
			}
		});
		updateConditions.start();
 
		Timer updateMovement = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dLabel.setLocation(drn.getX() + 1, drn.getY());
				drn.setX(dLabel.getX());
				drn.setY(dLabel.getY());
				for (int i = 0; i < planeLabels.size(); i++) {
					planeLabels.get(i).setLocation(planes.get(i).getX() - (int)Math.pow(2, scores.getWins()), planes.get(i).getY());
					planeHitboxes.get(i).resetBounds();
					//sop(planeHitboxes.get(i).printBounds());
				}
			}
		});
		updateMovement.start();

		// For Airplane respawn
		final int DELAY = 10;
		Timer t = new Timer(DELAY, event -> {
			for (int i = 0; i < planes.size(); i++) {
				if (planes.get(i).getX() < 10) {
					planes.get(i).setX(FRAME_WIDTH);	
					planes.get(i).setY(
						(int)(Math.random() * FRAME_HEIGHT));
				}
				planes.get(i).setLocation(-5, 0);
				planeHitboxes.get(i).resetBounds();
				//sop(planeHitboxes.get(i).printBounds());
			}
			/*
			for (Aircraft pl : planes) {
				if (pl.getX() < 10) {
					pl.setX(FRAME_WIDTH);
					pl.setY((int)(Math.random() * FRAME_HEIGHT));
				}
				pl.setLocation(-5, 0);
				pl.resetBounds();
				for (int j : pl.getBounds())
					sop("Next Hitbox\n" + j);
			}
			*/
			for (JLabel pl : planeLabels) {
				pl.repaint();
			}
		});
		t.start();

		// Add enemy planes to JFrame.
		for (JLabel pl : planeLabels) skyField.add(pl);
		
		// Add time and score information for the game.
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottom.add(timeLabel);
		bottom.add(scoreLabel);
		
		// Arrow Key Movement Implementation
		skyField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_UP) {
					if (dLabel.getY() > 20)
						dLabel.setLocation(drn.getX(), drn.getY() - 40);
				} else if(key == KeyEvent.VK_DOWN) {
					if (dLabel.getY() < FRAME_HEIGHT)
						dLabel.setLocation(drn.getX(), drn.getY() + 40);
				} else if(key == KeyEvent.VK_RIGHT) {
					if (dLabel.getX() < FRAME_WIDTH)
						dLabel.setLocation(drn.getX() + 40, drn.getY());
				} else if(key == KeyEvent.VK_LEFT) {
					if (dLabel.getX() > 20)
						dLabel.setLocation(drn.getX() - 40, drn.getY());
				}
				drn.setX(dLabel.getX());
				drn.setY(dLabel.getY());
				dHitbox.resetBounds();
				//sop(dHitbox.printBounds());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		skyField.setFocusable(true);

		// Combine all panels into single panel.
		panel.add(top);
		panel.add(skyField);
		panel.add(bottom);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(MAX_FRAME);
		this.getContentPane().add(panel);
		this.setVisible(true);
	}

	public static void sop(Object o) {
		System.out.println(o);
	}
}
