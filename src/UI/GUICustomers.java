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

import Controller.CustomerController;

public class GUICustomers {
	private GUI frame;
	private GUIOptionPanel optionPanel;
	private CustomerController customerController = CustomerController.getInstance();
	
	public GUICustomers(GUI frame) {
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
		String[] columnNames = {"Name", "Address", "Postal Code", "Phone No.", "City"};
		JTable customerTable = new JTable(customerController.getTable(), columnNames);
		JScrollPane table = new JScrollPane(customerTable);
		customerTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBounds(50, 90, 700, 200);
		databasePanel.add(table);
		JLabel nameText = new JLabel("Barcode:");
		JTextField nameField = new JTextField();
		JLabel addressText = new JLabel("Name:");
		JTextField addressField = new JTextField();
		JLabel postalCodeText = new JLabel("Price:");
		JTextField postalCodeField = new JTextField();
		JLabel phoneText = new JLabel("Quantity:");
		JTextField phoneField = new JTextField();
		JLabel cityText = new JLabel("Location:");
		JTextField cityField = new JTextField();
		JButton editButton = new JButton("Edit");
		JButton deleteButton = new JButton("Delete");
		nameText.setBounds(50, 300, 130, 30);
		nameField.setBounds(120, 300, 275, 30);
		addressText.setBounds(405, 300, 130, 30);
		addressField.setBounds(475, 300, 275, 30);
		postalCodeText.setBounds(50, 340, 130, 30);
		postalCodeField.setBounds(120, 340, 275, 30);
		phoneText.setBounds(405, 340, 130, 30);
		phoneField.setBounds(475, 340, 275, 30);
		cityText.setBounds(50, 380, 130, 30);
		cityField.setBounds(120, 380, 275, 30);
		editButton.setBounds(560, 380, 90, 30);
		editButton.setEnabled(false);
		deleteButton.setBounds(660, 380, 90, 30);
		deleteButton.setForeground(new Color(0xff0000));
		deleteButton.setEnabled(false);
		databasePanel.add(nameText);
		databasePanel.add(nameField);
		databasePanel.add(addressText);
		databasePanel.add(addressField);
		databasePanel.add(postalCodeText);
		databasePanel.add(postalCodeField);
		databasePanel.add(phoneText);
		databasePanel.add(phoneField);
		databasePanel.add(cityText);
		databasePanel.add(cityField);
		databasePanel.add(editButton);
		databasePanel.add(deleteButton);
		customerTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				nameField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(), 0));
				addressField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(), 1));
				postalCodeField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(), 2));
				phoneField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(), 3));
				cityField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(), 4));
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
			int oldPhone = Integer.valueOf((String)customerTable.getValueAt(customerTable.getSelectedRow(), 3));
			String name = nameField.getText();
			String address = addressField.getText();
			int postalCode = Integer.valueOf(postalCodeField.getText());
			int phone = Integer.valueOf(phoneField.getText());
			String city = cityField.getText();
			customerController.updateCustomer(oldPhone, name, address, postalCode, phone, city);
			database(); //very bad solution, but couldn't get the table to refresh any other way
		});
		deleteButton.addActionListener(f -> {
			int oldBarcode = Integer.valueOf((String)customerTable.getValueAt(customerTable.getSelectedRow(), 0));
			customerController.deleteCustomer(oldBarcode);
			database(); //same here
		});
	}
}
