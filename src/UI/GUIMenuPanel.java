package UI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIMenuPanel extends JPanel{
	private GUI frame;
	
	public GUIMenuPanel(GUI frame) {
		this.frame = frame;
		this.setLayout(new GridLayout(1,0));
		JButton createMenuButton = new JButton("Create");
		JButton contractorsMenuButton = new JButton("Contractors");
		JButton ordersMenuButton = new JButton("Orders");
		JButton productsMenuButton = new JButton("Products");
		JButton customersMenuButton = new JButton("Customers");
		JButton deliveryMenuButton = new JButton("Delivery");
		JButton revenueMenuButton = new JButton("Revenue");
		this.add(createMenuButton);
		this.add(contractorsMenuButton);
		this.add(ordersMenuButton);
		this.add(productsMenuButton);
		this.add(customersMenuButton);
		this.add(deliveryMenuButton);
		this.add(revenueMenuButton);
		this.setBounds(0,0,800,50);
		this.setBackground(new Color(0x808080));
		
		//remove these when the menus are implemented
		productsMenuButton.setEnabled(false);
		customersMenuButton.setEnabled(false);
		deliveryMenuButton.setEnabled(false);
		revenueMenuButton.setEnabled(false);
		
		createMenuButton.addActionListener(e -> new GUICreate(frame));
		contractorsMenuButton.addActionListener(f -> new GUIContractors(frame));
		ordersMenuButton.addActionListener(g -> new GUIOrders(frame));
	}
}
