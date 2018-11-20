import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame {

	private final int FRAME_SIZE = 1400;

	public Frame() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new BorderLayout());
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel top = new JPanel();
		JPanel environment = new JPanel(new FlowLayout());

		// Add title.
		JLabel label = new JLabel("Start");
		top.add(label);

		// Add drone.
		Drone drn = new Drone(FRAME_SIZE / 2, FRAME_SIZE / 2,
			"/drone.png");

		environment.add(drn, BorderLayout.CENTER);

		JButton up = new JButton("Up");
		JButton down = new JButton("Down");

		bottom.add(up);
		bottom.add(down);

		// Add action listeners to UP and DOWN.

		panel.add(top, BorderLayout.NORTH);
		panel.add(bottom, BorderLayout.SOUTH);
		panel.add(environment, BorderLayout.CENTER);

		frame.setSize(FRAME_SIZE, FRAME_SIZE);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
