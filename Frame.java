import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame{
	
	public void create() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new BorderLayout());
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel top = new JPanel();
		
		JButton up = new JButton("Up");
		JButton down = new JButton("Down");
		
		bottom.add(up);
		bottom.add(down);
		
		panel.add(top, BorderLayout.NORTH);
		panel.add(bottom, BorderLayout.SOUTH);
		
		JLabel label = new JLabel("Start");
		top.add(label);
		
		frame.setSize(700, 700);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}