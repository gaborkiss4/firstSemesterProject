package UI;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUIOptionPanel extends JPanel{
	private ArrayList<JButton> buttons;
	
	public GUIOptionPanel(String[] options) {
		this.setBounds(0,50,800,30);
		this.setLayout(new GridLayout(1,0));
		buttons = new ArrayList<>();
		for(String i : options) {
			JButton button = new JButton(i);
			this.add(button);
			buttons.add(button);
		}
		this.setBackground(new Color(0xdadada));
	}
	
	public JButton getButton(int n) {
		return buttons.get(n);
	}
}
