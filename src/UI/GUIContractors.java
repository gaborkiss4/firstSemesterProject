package UI;

import java.awt.Color;

import javax.swing.JPanel;

public class GUIContractors{
	
	private GUI frame;
	private GUIOptionPanel optionPanel;
	
	public GUIContractors(GUI frame) {
		this.frame = frame;
		frame.removeCurrentlyActive();
		createOptionPanel();
	}
	
	private void createOptionPanel() {
		String[] options = {"Database"};
		optionPanel = new GUIOptionPanel(options);
		optionPanel.getButton(0).addActionListener(e -> database());
		frame.setCurrentOptionBar(optionPanel);
	}
	
	private void database() {
		JPanel databasePanel = new JPanel();
		frame.setCurrentlyActive(databasePanel);
		databasePanel.setBackground(new Color(0xff0000));
		databasePanel.setBounds(0, 80, 800, 520);
	}
}
