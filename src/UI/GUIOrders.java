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

import Controller.OrderController;

public class GUIOrders {
	private GUI frame;
	private GUIOptionPanel optionPanel;
	private OrderController orderController = OrderController.getInstance();
	
	public GUIOrders(GUI frame) {
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
		String[] columnNames = {"Order No.", "Date", "Name", "Type", "Paid"};
		JTable orderTable = new JTable(orderController.getTable(), columnNames);
		JScrollPane table = new JScrollPane(orderTable);
		orderTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBounds(50, 90, 700, 200);
		databasePanel.add(table);
		JLabel orderNoText = new JLabel("Order No.:");
		JTextField orderNoField = new JTextField();
		JLabel dateText = new JLabel("Date:");
		JTextField dateField = new JTextField();
		JLabel nameText = new JLabel("Name:");
		JTextField nameField = new JTextField();
		JLabel typeText = new JLabel("Type:");
		JTextField typeField = new JTextField();
		JLabel paidText = new JLabel("Paid:");
		JTextField paidField = new JTextField();
		JButton editButton = new JButton("Edit");
		JButton deleteButton = new JButton("Delete");
		orderNoText.setBounds(50, 300, 130, 30);
		orderNoField.setBounds(120, 300, 275, 30);
		dateText.setBounds(405, 300, 130, 30);
		dateField.setBounds(475, 300, 275, 30);
		nameText.setBounds(50, 340, 130, 30);
		nameField.setBounds(120, 340, 275, 30);
		typeText.setBounds(405, 340, 130, 30);
		typeField.setBounds(475, 340, 275, 30);
		paidText.setBounds(50, 380, 130, 30);
		paidField.setBounds(120, 380, 275, 30);
		editButton.setBounds(560, 380, 90, 30);
		editButton.setEnabled(false);
		deleteButton.setBounds(660, 380, 90, 30);
		deleteButton.setForeground(new Color(0xff0000));
		deleteButton.setEnabled(false);
		databasePanel.add(orderNoText);
		databasePanel.add(orderNoField);
		databasePanel.add(dateText);
		databasePanel.add(dateField);
		databasePanel.add(nameText);
		databasePanel.add(nameField);
		databasePanel.add(typeText);
		databasePanel.add(typeField);
		databasePanel.add(paidText);
		databasePanel.add(paidField);
		databasePanel.add(editButton);
		databasePanel.add(deleteButton);
		orderTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				orderNoField.setText((String)orderTable.getValueAt(orderTable.getSelectedRow(), 0));
				dateField.setText((String)orderTable.getValueAt(orderTable.getSelectedRow(), 1));
				nameField.setText((String)orderTable.getValueAt(orderTable.getSelectedRow(), 2));
				typeField.setText((String)orderTable.getValueAt(orderTable.getSelectedRow(), 3));
				paidField.setText((String)orderTable.getValueAt(orderTable.getSelectedRow(), 4));
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
			int oldOrderNo = Integer.valueOf((String)orderTable.getValueAt(orderTable.getSelectedRow(), 0));
			int orderNo = Integer.valueOf(orderNoField.getText());
			String date = dateField.getText();
			String name = nameField.getText();
			String type = typeField.getText();
			String paid = paidField.getText();
			orderController.updateOrder(oldOrderNo, orderNo, date, name, type, paid);
			database(); //very bad solution, but couldn't get the table to refresh any other way
		});
		deleteButton.addActionListener(f -> {
			int oldOrderNo = Integer.valueOf((String)orderTable.getValueAt(orderTable.getSelectedRow(), 0));
			orderController.deleteOrder(oldOrderNo);
			database(); //same here
		});
	}
}
