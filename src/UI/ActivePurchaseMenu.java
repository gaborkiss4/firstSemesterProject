package UI;

import java.util.Scanner;
import Controller.ProductController;
import Model.Purchase; //this is supposed to go through a controller, but it doesn't exist yet

public class ActivePurchaseMenu extends Menu{
	private ProductController productCntrl;
	private Purchase purchase;
	public ActivePurchaseMenu() {
		setName("New Purchase");
		productCntrl = ProductController.getInstance();
	}
	public void setActive() {
		displayMenu();
		addChoice(new PurchaseMenu()); //1
		int c = displayChoices();
		switch(c) {
			case 2:
				addItem();
				break;
			default:
				break;
		}
	}
	protected void displayMenu() {
		System.out.println("Active Purchase");
		System.out.println("Please input customer ID: (unimplemented -- skipped)");
	}
	protected void displayUniqueChoices() {
		System.out.println("2 Add Item");
	}
	private void addItem() {
		if(purchase==null) {
			purchase = new Purchase(null, null, null);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input item ID: ");
		int itemId = sc.nextInt();
		productCntrl.findByBarcode(itemId);
		System.out.println("(unimplemented)");
	}
	
}
