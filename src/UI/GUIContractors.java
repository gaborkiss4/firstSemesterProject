package UI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controller.ContractorController;

public class GUIContractors{
	
	private GUI frame;
	private GUIOptionPanel optionPanel;
	private ContractorController contractorController = ContractorController.getInstance();
	
	public GUIContractors(GUI frame) {
		this.frame = frame;
		frame.removeCurrentlyActive();
		createOptionPanel();
		database();
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
		databasePanel.setBackground(new Color(0xfdf6d6));
		databasePanel.setBounds(0, 80, 800, 520);
		JTextField searchField = new JTextField("Type here to search");
		searchField.setBounds(50, 50, 600, 30);
		databasePanel.add(searchField);
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(660, 50, 90, 30);
		databasePanel.add(searchButton);
		String[] columnNames = {"Firm", "Since", "Director", "Director's Phone", "Firm Phone"};
		JTable contractorTable = new JTable(contractorController.getTable(), columnNames);
		JScrollPane table = new JScrollPane(contractorTable);
		contractorTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBounds(50, 90, 700, 200);
		databasePanel.add(table);
		JLabel firmText = new JLabel("Firm:");
		JTextField firmField = new JTextField();
		JLabel sinceText = new JLabel("Since:");
		JTextField sinceField = new JTextField();
		JLabel directorText = new JLabel("Director:");
		JTextField directorField = new JTextField();
		JLabel directorPhoneText = new JLabel("Dir. Phone:");
		JTextField directorPhoneField = new JTextField();
		JLabel firmPhoneText = new JLabel("F. Phone:");
		JTextField firmPhoneField = new JTextField();
		JButton editButton = new JButton("Edit");
		JButton deleteButton = new JButton("Delete");
		firmText.setBounds(50, 300, 130, 30);
		firmField.setBounds(120, 300, 275, 30);
		sinceText.setBounds(405, 300, 130, 30);
		sinceField.setBounds(475, 300, 275, 30);
		directorText.setBounds(50, 340, 130, 30);
		directorField.setBounds(120, 340, 275, 30);
		directorPhoneText.setBounds(405, 340, 130, 30);
		directorPhoneField.setBounds(475, 340, 275, 30);
		firmPhoneText.setBounds(50, 380, 130, 30);
		firmPhoneField.setBounds(120, 380, 275, 30);
		editButton.setBounds(560, 380, 90, 30);
		editButton.setEnabled(false);
		deleteButton.setBounds(660, 380, 90, 30);
		deleteButton.setForeground(new Color(0xff0000));
		deleteButton.setEnabled(false);
		databasePanel.add(firmText);
		databasePanel.add(firmField);
		databasePanel.add(sinceText);
		databasePanel.add(sinceField);
		databasePanel.add(directorText);
		databasePanel.add(directorField);
		databasePanel.add(directorPhoneText);
		databasePanel.add(directorPhoneField);
		databasePanel.add(firmPhoneText);
		databasePanel.add(firmPhoneField);
		databasePanel.add(editButton);
		databasePanel.add(deleteButton);
		contractorTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				firmField.setText((String)contractorTable.getValueAt(contractorTable.getSelectedRow(), 0));
				sinceField.setText((String)contractorTable.getValueAt(contractorTable.getSelectedRow(), 1));
				directorField.setText((String)contractorTable.getValueAt(contractorTable.getSelectedRow(), 2));
				directorPhoneField.setText((String)contractorTable.getValueAt(contractorTable.getSelectedRow(), 3));
				firmPhoneField.setText((String)contractorTable.getValueAt(contractorTable.getSelectedRow(), 4));
				editButton.setEnabled(true);
				deleteButton.setEnabled(true);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		editButton.addActionListener(e -> {
			int oldFirmNumber = Integer.valueOf((String)contractorTable.getValueAt(contractorTable.getSelectedRow(), 4));
			String firm = firmField.getText();
			String since = sinceField.getText();
			String director = directorField.getText();
			int directorPhone = Integer.valueOf(directorPhoneField.getText());
			int firmPhone = Integer.valueOf(firmPhoneField.getText());
			contractorController.updateContractor(oldFirmNumber, firm, since, director, directorPhone, firmPhone);
			database(); //very bad solution, but couldn't get the table to refresh any other way
		});
		deleteButton.addActionListener(f -> {
			int oldFirmNumber = Integer.valueOf((String)contractorTable.getValueAt(contractorTable.getSelectedRow(), 4));
			contractorController.deleteContractor(oldFirmNumber);
			database(); //same here
		});
	}
}
