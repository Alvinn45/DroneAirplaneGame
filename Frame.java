import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame {

	private final int FRAME_SIZE = 1000;
	private final Color lightblue = new Color(51,204,255);

	public Frame() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		// Add title.
		JPanel top = new JPanel();
		JLabel label = new JLabel("Start");
		top.add(label);

		// Add drone.
		JPanel environment = new JPanel();
		environment.setPreferredSize(new Dimension(FRAME_SIZE, FRAME_SIZE));
		final Aircraft drn = new Drone(FRAME_SIZE / 2, FRAME_SIZE / 2,
			"drone.png");
		JLabel dLabel = new JLabel(drn);
		environment.add(dLabel);

		// Add plane.
		final Aircraft pln = new Plane(FRAME_SIZE / 2 + FRAME_SIZE / 4,
				FRAME_SIZE / 2, "airplane.png");
		JLabel pLabel = new JLabel(pln);
		environment.add(pLabel);

		// Add buttons.
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton up = new JButton("Up");
		JButton down = new JButton("Down");
		//JButton shoot = new JButton("Shoot/space");

		bottom.add(up);
		bottom.add(down);
		//bottom.add(shoot);

		// Add action listeners to buttons.

		// Combine all panels into single panel.
		panel.setBackground(lightblue);
		//panel.add(top);
		panel.add(environment);
		panel.add(bottom);

		this.setSize(FRAME_SIZE, FRAME_SIZE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
}
