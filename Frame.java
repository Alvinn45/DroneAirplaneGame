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
		
		JLabel label = new JLabel("Start");
		top.add(label);
		
		frame.setSize(700, 700);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(lightblue);
		top.setBackground(lightblue);
		panel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
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
