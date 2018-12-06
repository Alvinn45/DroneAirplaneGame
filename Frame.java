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
		Aircraft drn = new Drone(FRAME_WIDTH / 4, FRAME_HEIGHT / 4,
			"drone.png");
		JLabel dLabel = new JLabel(drn);
		skyField.add(dLabel);
		dLabel.setBounds(drn.getX(), drn.getY(),
				drn.getIconWidth(), drn.getIconHeight());

		// Add enemy planes.
		ArrayList<Aircraft> planes = new ArrayList<>();
		ArrayList<JLabel>  planeLabels = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			int adjust = (int)(Math.random() * FRAME_WIDTH / 2);
			planes.add(new Plane(FRAME_WIDTH + adjust,
					i * 10 + adjust,
					"airplane.png"));
			planeLabels.add(new JLabel(planes.get(i)));
			planeLabels.get(i).setBounds(planes.get(i).getX(),
						planes.get(i).getY(),
						planes.get(i).getIconWidth(),
						planes.get(i).getIconHeight());
		}

		for (JLabel pl : planeLabels) skyField.add(pl);

		// Add buttons.
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton up = new JButton("Up");
		JButton down = new JButton("Down");
		//JButton shoot = new JButton("Shoot/space");

		bottom.add(up);
		bottom.add(down);
		//bottom.add(shoot);

		// Add action listeners to buttons.
		up.addActionListener(eventUp -> {
			drn.setLocation(0, 100);
			dLabel.repaint();
			sop("x: " + drn.getX() + "; y:" + drn.getY());
		});

		down.addActionListener(eventDown -> {
			drn.setLocation(0, -100);
			dLabel.repaint();
			sop("x: " + drn.getX() + "; y:" + drn.getY());
		});

		skyField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_UP) {
					setLocation(0, 5);
				} else if(key == KeyEvent.VK_DOWN) {
					setLocation(0, -5);
				} else if(key == KeyEvent.VK_RIGHT) {
					setLocation(5, 0);
				} else if(key == KeyEvent.VK_LEFT) {
					setLocation(-5, 0);
				}

				sop("x: " + drn.getX() + "; y:" + drn.getY());
				dLabel.revalidate();
				dLabel.repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_UP) {
					setLocation(0, 0);
				} else if(key == KeyEvent.VK_DOWN) {
					setLocation(0, 0);
				} else if(key == KeyEvent.VK_RIGHT) {
					setLocation(0, 0);
				} else if(key == KeyEvent.VK_LEFT) {
					setLocation(0, 0);
				}


				sop("x: " + drn.getX() + "; y:" + drn.getY());
				dLabel.revalidate();
				dLabel.repaint();
			}
		});
		skyField.setFocusable(true);

		// Add timer movement to each enemy plane.
		final int DELAY = 10;
		Timer t = new Timer(DELAY, event -> {
			for (Aircraft pl : planes) {
				if (pl.getX() < 100) pl.setX(FRAME_WIDTH);
				pl.setLocation(-5, 0);
				sop("x: " + drn.getX() + "; y:" + drn.getY());
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
