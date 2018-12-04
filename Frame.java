import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame{
	
	public static final Color lightblue = new Color(51,204,255);
	
	public void create() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new BorderLayout());
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel top = new JPanel();
		
		JButton up = new JButton("Up");
		JButton down = new JButton("Down");
		JButton shoot = new JButton("Shoot/space");
		
		bottom.add(up);
		bottom.add(down);
		bottom.add(shoot);
		
		panel.add(top, BorderLayout.NORTH);
		panel.add(bottom, BorderLayout.SOUTH);
		
		JLabel label = new JLabel("Start");
		top.add(label);
		
		frame.setSize(700, 700);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(lightblue);
		frame.setVisible(true);
	}
	
	public void keys(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP){
			drone.y++;
		} else if(key == KeyEvent.VK_DOWN){
			drone.y--;
		}
		drone.repaint();
	}
}
