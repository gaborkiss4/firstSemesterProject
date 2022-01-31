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

import Controller.ContractorController;
import Controller.CustomerController;
import Controller.OrderController;
import Controller.ProductController;

public class GUICreate{

	private ProductController productController = ProductController.getInstance();
	private OrderController orderController = OrderController.getInstance();
	private CustomerController customerController = CustomerController.getInstance();
	private ContractorController contractorController = ContractorController.getInstance();
	private GUI frame;
	private GUIOptionPanel optionPanel;
	private Date date = new Date();
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	public GUICreate(GUI frame) {
		this.frame = frame;
		frame.removeCurrentlyActive();
		createOptionPanel();
	}
	private void createOptionPanel() {
		String[] options = {"Add Offer","Add Customer","Add Contractor","Add Product"};
		optionPanel = new GUIOptionPanel(options);
		optionPanel.getButton(0).addActionListener(e -> addOffer());
		optionPanel.getButton(1).addActionListener(f -> addCustomer());
		optionPanel.getButton(2).addActionListener(g -> addContractor());
		optionPanel.getButton(3).addActionListener(h -> addProduct());
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
	
	private void addContractor() {
		JPanel addContractorPanel = new JPanel();
		frame.setCurrentlyActive(addContractorPanel);
		addContractorPanel.setBackground(new Color(0xfdf6d6));
		addContractorPanel.setBounds(0, 80, 800, 520);
		JLabel firmNameText = new JLabel("Firm Name:", SwingConstants.RIGHT);
		JLabel startingDateText = new JLabel("Starting Date:", SwingConstants.RIGHT);
		JLabel directorNameText = new JLabel("Director's Name:", SwingConstants.RIGHT);
		JLabel directorNumberText = new JLabel("Director's Number:", SwingConstants.RIGHT);
		JLabel firmNumberText = new JLabel("Firm's Number:", SwingConstants.RIGHT);
		firmNameText.setBounds(0, 50, 190, 30);
		startingDateText.setBounds(0, 90, 190, 30);
		directorNameText.setBounds(0, 130, 190, 30);
		directorNumberText.setBounds(0, 170, 190, 30);
		firmNumberText.setBounds(0, 210, 190, 30);
		addContractorPanel.add(firmNameText);
		addContractorPanel.add(startingDateText);
		addContractorPanel.add(directorNameText);
		addContractorPanel.add(directorNumberText);
		addContractorPanel.add(firmNumberText);
		JTextField firmName = new JTextField();
		JTextField startingDate = new JTextField();
		JTextField directorName = new JTextField();
		JTextField directorNumber = new JTextField();
		JTextField firmNumber = new JTextField();
		JButton addButton = new JButton("Add");
		firmName.setBounds(200, 50, 500, 30);
		startingDate.setBounds(200, 90, 500, 30);
		directorName.setBounds(200, 130, 500, 30);
		directorNumber.setBounds(200, 170, 500, 30);
		firmNumber.setBounds(200, 210, 500, 30);
		addButton.setBounds(600, 250, 100, 30);
		addContractorPanel.add(firmName);
		addContractorPanel.add(startingDate);
		addContractorPanel.add(directorName);
		addContractorPanel.add(directorNumber);
		addContractorPanel.add(firmNumber);
		addContractorPanel.add(addButton);
		addButton.addActionListener(e -> {
			if(firmName.getText().equals("") || startingDate.getText().equals("") || directorName.getText().equals("") || directorNumber.getText().equals("") || firmNumber.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Contractor could not be added due to missing information.","Empty fields!",JOptionPane.ERROR_MESSAGE);
			} else {
				boolean error = false;
				for(int i = 0; i < directorNumber.getText().length(); i++) {
					if(directorNumber.getText().charAt(i)<48 || directorNumber.getText().charAt(i)>57) error = true;
				}
				for(int i = 0; i < firmNumber.getText().length(); i++) {
					if(firmNumber.getText().charAt(i)<48 || firmNumber.getText().charAt(i)>57) error = true;
				}
				if(error) JOptionPane.showMessageDialog(null,"Invalid information provided!","Invalid input!",JOptionPane.ERROR_MESSAGE);
				else {
					error = false;
					if(startingDate.getText().length() != 10) error = true;
					else {
						for(int i=0; i<10; i++) {  //checks for numbers and dashes in the date
							if(i==2 || i==5) {
								if(startingDate.getText().charAt(i)!=45) error = true;
								i++;
							}
							if(startingDate.getText().charAt(i)<48 || startingDate.getText().charAt(i)>57) error = true;
						}
					}
					if(error) JOptionPane.showMessageDialog(null,"Please enter the date in the correct format (dd-MM-yyyy)!","Invalid date!",JOptionPane.ERROR_MESSAGE);
					else {
						contractorController.createContractor(firmName.getText(), startingDate.getText(), directorName.getText(), Integer.valueOf(directorNumber.getText()), Integer.valueOf(firmNumber.getText()));
						JOptionPane.showMessageDialog(null, "Contractor successfully added.", "Success!", JOptionPane.PLAIN_MESSAGE);
						firmName.setText("");
						startingDate.setText("");
						directorName.setText("");
						directorNumber.setText("");
						firmNumber.setText("");
					}
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
					int dots = 0;
					if(price.getText().charAt(i)=='.' && dots==0) {
						i++;
						dots++;
					}
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
