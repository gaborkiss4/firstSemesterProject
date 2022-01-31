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

import Controller.ProductController;

public class GUIProducts {
	private GUI frame;
	private GUIOptionPanel optionPanel;
	private ProductController productController = ProductController.getInstance();
	
	public GUIProducts(GUI frame) {
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
		String[] columnNames = {"Barcode", "Name", "Price", "Quantity", "Location"};
		JTable productTable = new JTable(productController.getTable2(), columnNames);
		JScrollPane table = new JScrollPane(productTable);
		productTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBounds(50, 90, 700, 200);
		databasePanel.add(table);
		JLabel barcodeText = new JLabel("Barcode:");
		JTextField barcodeField = new JTextField();
		JLabel nameText = new JLabel("Name:");
		JTextField nameField = new JTextField();
		JLabel priceText = new JLabel("Price:");
		JTextField priceField = new JTextField();
		JLabel quantityText = new JLabel("Quantity:");
		JTextField quantityField = new JTextField();
		JLabel locationText = new JLabel("Location:");
		JTextField locationField = new JTextField();
		JButton editButton = new JButton("Edit");
		JButton deleteButton = new JButton("Delete");
		barcodeText.setBounds(50, 300, 130, 30);
		barcodeField.setBounds(120, 300, 275, 30);
		nameText.setBounds(405, 300, 130, 30);
		nameField.setBounds(475, 300, 275, 30);
		priceText.setBounds(50, 340, 130, 30);
		priceField.setBounds(120, 340, 275, 30);
		quantityText.setBounds(405, 340, 130, 30);
		quantityField.setBounds(475, 340, 275, 30);
		locationText.setBounds(50, 380, 130, 30);
		locationField.setBounds(120, 380, 275, 30);
		editButton.setBounds(560, 380, 90, 30);
		editButton.setEnabled(false);
		deleteButton.setBounds(660, 380, 90, 30);
		deleteButton.setForeground(new Color(0xff0000));
		deleteButton.setEnabled(false);
		databasePanel.add(barcodeText);
		databasePanel.add(barcodeField);
		databasePanel.add(nameText);
		databasePanel.add(nameField);
		databasePanel.add(priceText);
		databasePanel.add(priceField);
		databasePanel.add(quantityText);
		databasePanel.add(quantityField);
		databasePanel.add(locationText);
		databasePanel.add(locationField);
		databasePanel.add(editButton);
		databasePanel.add(deleteButton);
		productTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				barcodeField.setText((String)productTable.getValueAt(productTable.getSelectedRow(), 0));
				nameField.setText((String)productTable.getValueAt(productTable.getSelectedRow(), 1));
				priceField.setText((String)productTable.getValueAt(productTable.getSelectedRow(), 2));
				quantityField.setText((String)productTable.getValueAt(productTable.getSelectedRow(), 3));
				locationField.setText((String)productTable.getValueAt(productTable.getSelectedRow(), 4));
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
			int oldBarcode = Integer.valueOf((String)productTable.getValueAt(productTable.getSelectedRow(), 0));
			int barcode = Integer.valueOf(barcodeField.getText());
			String name = nameField.getText();
			double price = Double.valueOf(priceField.getText());
			int quantity = Integer.valueOf(quantityField.getText());
			String location = locationField.getText();
			productController.updateProduct(oldBarcode, barcode, name, "", price, quantity, location);
			database(); //very bad solution, but couldn't get the table to refresh any other way
		});
		deleteButton.addActionListener(f -> {
			int oldBarcode = Integer.valueOf((String)productTable.getValueAt(productTable.getSelectedRow(), 0));
			productController.deleteProduct(oldBarcode);
			database(); //same here
		});
	}
}
