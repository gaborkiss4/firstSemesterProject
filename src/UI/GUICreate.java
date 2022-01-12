package UI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.CustomerController;
import Controller.OrderController;
import Controller.ProductController;

public class GUICreate extends JPanel{

	private ProductController productController = ProductController.getInstance();
	private OrderController orderController = OrderController.getInstance();
	private CustomerController customerController = CustomerController.getInstance();
	private GUI frame;
	private GUIOptionPanel optionPanel;
	private Date date = new Date();
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
	
	public GUICreate(GUI frame) {
		this.frame = frame;
		createOptionPanel();
	}
	private void createOptionPanel() {
		String[] options = {"Add Offer","Add Customer","Add Contractor","Add Product"};
		optionPanel = new GUIOptionPanel(options);
		optionPanel.getButton(0).addActionListener(e -> addOffer());
		optionPanel.getButton(1).addActionListener(f -> addCustomer());
		optionPanel.getButton(3).addActionListener(h -> addProduct());
		//remove when implemented
		optionPanel.getButton(2).setEnabled(false);
		frame.setCurrentOptionBar(optionPanel);
	}
	private void addOffer() {
		JPanel addOfferPanel = new JPanel();
		frame.setCurrentlyActive(addOfferPanel);
		addOfferPanel.setBackground(new Color(0xfdf6d6));
		addOfferPanel.setBounds(0, 80, 800, 520);
		JTextField searchField = new JTextField("Type here to search");
		searchField.setBounds(50, 50, 600, 30);
		addOfferPanel.add(searchField);
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(660, 50, 90, 30);
		addOfferPanel.add(searchButton);
		String[] columnNames = {"Product", "Price", "Quantity", "Barcode"};
		JTable productTable = new JTable(productController.getTable(), columnNames);
		JScrollPane table = new JScrollPane(productTable);
		productTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBounds(50, 90, 700, 200);
		addOfferPanel.add(table);
		JLabel priceText = new JLabel("Price:");
		JTextField priceField = new JTextField();
		JLabel quantityText = new JLabel("Quantity:");
		JTextField quantityField = new JTextField();
		JButton sellButton = new JButton("Sell");
		priceText.setBounds(50, 300, 130, 30);
		priceField.setBounds(85, 300, 240, 30);
		quantityText.setBounds(330, 300, 130, 30);
		quantityField.setBounds(390, 300, 220, 30);
		sellButton.setBounds(610, 300, 140, 30);
		sellButton.setEnabled(false);
		productTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				String selectedPrice = (String)productTable.getValueAt(productTable.getSelectedRow(), 1);
				priceField.setText(selectedPrice);
				quantityField.setText("1");
				sellButton.setEnabled(true);
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
		sellButton.addActionListener(e -> {
			int input = JOptionPane.showConfirmDialog(null,"The total is "+(Double.valueOf(priceField.getText())*Integer.valueOf(quantityField.getText()))+", do you want to continue?", "Confirm?", JOptionPane.OK_CANCEL_OPTION);
			// cancel = 2; ok = 0
			if(input==0) {
				//product sold from the system -- unimplemented
			}
		});
		addOfferPanel.add(priceText);
		addOfferPanel.add(priceField);
		addOfferPanel.add(quantityText);
		addOfferPanel.add(quantityField);
		addOfferPanel.add(sellButton);
	}
	
	private void addCustomer() {
		JPanel addCustomerPanel = new JPanel();
		frame.setCurrentlyActive(addCustomerPanel);
		addCustomerPanel.setBackground(new Color(0xfdf6d6));
		addCustomerPanel.setBounds(0, 80, 800, 520);
		JLabel customerNameText = new JLabel("Name:", SwingConstants.RIGHT);
		JLabel addressText = new JLabel("Address:", SwingConstants.RIGHT);
		JLabel postcodeText = new JLabel("Postcode:", SwingConstants.RIGHT);
		JLabel cityText = new JLabel("City:", SwingConstants.RIGHT);
		JLabel phoneText = new JLabel("Phone Number:", SwingConstants.RIGHT);
		customerNameText.setBounds(0, 50, 190, 30);
		addressText.setBounds(0, 90, 190, 30);
		postcodeText.setBounds(0, 130, 190, 30);
		cityText.setBounds(0, 170, 190, 30);
		phoneText.setBounds(0, 210, 190, 30);
		addCustomerPanel.add(customerNameText);
		addCustomerPanel.add(addressText);
		addCustomerPanel.add(postcodeText);
		addCustomerPanel.add(cityText);
		addCustomerPanel.add(phoneText);
		JTextField customerName = new JTextField();
		JTextField address = new JTextField();
		JTextField postcode = new JTextField();
		JTextField city = new JTextField();
		JTextField phone = new JTextField();
		JButton addButton = new JButton("Add");
		customerName.setBounds(200, 50, 500, 30);
		address.setBounds(200, 90, 500, 30);
		postcode.setBounds(200, 130, 500, 30);
		city.setBounds(200, 170, 500, 30);
		phone.setBounds(200, 210, 500, 30);
		addButton.setBounds(600, 250, 100, 30);
		addCustomerPanel.add(customerName);
		addCustomerPanel.add(address);
		addCustomerPanel.add(postcode);
		addCustomerPanel.add(city);
		addCustomerPanel.add(phone);
		addCustomerPanel.add(addButton);
		addButton.addActionListener(e -> {
			if(customerName.getText().equals("") || address.getText().equals("") || postcode.getText().equals("") || city.getText().equals("") || phone.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Customer could not be added due to missing information.","Empty fields!",JOptionPane.ERROR_MESSAGE);
			} else {
				boolean error = false;
				for(int i = 0; i < postcode.getText().length(); i++) {
					if(postcode.getText().charAt(i)<48 || postcode.getText().charAt(i)>57) error = true;
				}
				for(int i = 0; i < phone.getText().length(); i++) {
					if(phone.getText().charAt(i)<48 || phone.getText().charAt(i)>57) error = true;
				}
				if(error) JOptionPane.showMessageDialog(null,"Invalid information provided!","Invalid input!",JOptionPane.ERROR_MESSAGE);
				else {
					customerController.createCustomer(customerName.getText(), address.getText(), Integer.valueOf(postcode.getText()), Integer.valueOf(phone.getText()), city.getText());
					JOptionPane.showMessageDialog(null, "Product successfully added.", "Success!", JOptionPane.PLAIN_MESSAGE);
					customerName.setText("");
					address.setText("");
					postcode.setText("");
					city.setText("");
					phone.setText("");
				}
			}
		});
	}
	
	private void addProduct() {
		JPanel addProductPanel = new JPanel();
		frame.setCurrentlyActive(addProductPanel);
		addProductPanel.setBackground(new Color(0xfdf6d6));
		addProductPanel.setBounds(0, 80, 800, 520);
		JLabel productNameText = new JLabel("Product Name:", SwingConstants.RIGHT);
		JLabel barcodeText = new JLabel("Barcode:", SwingConstants.RIGHT);
		JLabel priceText = new JLabel("Price:", SwingConstants.RIGHT);
		JLabel quantityText = new JLabel("Quantity:", SwingConstants.RIGHT);
		JLabel locationText = new JLabel("Location:", SwingConstants.RIGHT);
		productNameText.setBounds(0, 50, 190, 30);
		barcodeText.setBounds(0, 90, 190, 30);
		priceText.setBounds(0, 130, 190, 30);
		quantityText.setBounds(0, 170, 190, 30);
		locationText.setBounds(0, 210, 190, 30);
		addProductPanel.add(productNameText);
		addProductPanel.add(barcodeText);
		addProductPanel.add(priceText);
		addProductPanel.add(quantityText);
		addProductPanel.add(locationText);
		JTextField productName = new JTextField();
		JTextField barcode = new JTextField();
		JTextField price = new JTextField();
		JTextField quantity = new JTextField();
		String[] locationOptions = {"Lumber", "DIY", "Both"};
		JComboBox location = new JComboBox(locationOptions);
		JButton addButton = new JButton("Add");
		location.setSelectedItem("choose");
		productName.setBounds(200, 50, 500, 30);
		barcode.setBounds(200, 90, 500, 30);
		price.setBounds(200, 130, 500, 30);
		quantity.setBounds(200, 170, 500, 30);
		location.setBounds(200, 210, 500, 30);
		location.doLayout();
		addButton.setBounds(600, 250, 100, 30);
		addProductPanel.add(productName);
		addProductPanel.add(barcode);
		addProductPanel.add(price);
		addProductPanel.add(quantity);
		addProductPanel.add(location);
		addProductPanel.add(addButton);
		addButton.addActionListener(e -> {
			if(productName.getText().equals("") || barcode.getText().equals("") || price.getText().equals("") || quantity.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Product could not be added due to missing information.","Empty fields!",JOptionPane.ERROR_MESSAGE);
			} else {
				boolean error = false;
				for(int i = 0; i < barcode.getText().length(); i++) {
					if(barcode.getText().charAt(i)<48 || barcode.getText().charAt(i)>57) error = true;
				}
				for(int i = 0; i < price.getText().length(); i++) {
					if(price.getText().charAt(i)<48 || price.getText().charAt(i)>57) error = true;
				}
				for(int i = 0; i < quantity.getText().length(); i++) {
					if(quantity.getText().charAt(i)<48 || quantity.getText().charAt(i)>57) error = true;
				}
				if(error) JOptionPane.showMessageDialog(null,"Invalid information provided!","Invalid input!",JOptionPane.ERROR_MESSAGE);
				else {
					productController.createProduct(Integer.valueOf(barcode.getText()), productName.getText(), formatter.format(date), Double.valueOf(price.getText()), Integer.valueOf(quantity.getText()), String.valueOf(location.getSelectedItem()));
					JOptionPane.showMessageDialog(null, "Product successfully added.", "Success!", JOptionPane.PLAIN_MESSAGE);
					productName.setText("");
					barcode.setText("");
					price.setText("");
					quantity.setText("");
				}
			}
		});
	}
}
