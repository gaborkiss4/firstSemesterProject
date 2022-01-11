package UI;

import javax.swing.*;
import java.awt.*;

public class GUI {
	private JPanel currentlyActive;
	private GUIOptionPanel currentOptionBar;
	private JFrame frame;
	
	
	public GUI() {
		frame = new JFrame();
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("amogus 2");
		frame.setLayout(null);
		
		JPanel menuPanel = new GUIMenuPanel(this);
		
		frame.add(menuPanel);
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void setCurrentlyActive(JPanel window) {
		if(currentlyActive != null) {
			frame.remove(currentlyActive);
		}
		currentlyActive = window;
		frame.add(currentlyActive);
		frame.setVisible(true);
	}
	
	public void setCurrentOptionBar(GUIOptionPanel optionBar) {
		if(currentOptionBar != null) {
			frame.remove(currentOptionBar);
		}
		currentOptionBar = optionBar;
		frame.add(currentOptionBar);
		frame.setVisible(true);
	}
	
	public JPanel getCurrentlyActive() {
		return this.currentlyActive;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
