package UI;

public class PurchaseMenu extends Menu{
	public PurchaseMenu() {
		setName("Purchase Menu");
	}
	public void setActive() {
		displayMenu();
		addChoice(new MainMenu()); //1
		addChoice(new ActivePurchaseMenu());
		displayChoices();
		
	}
	public void displayMenu() {
		System.out.println("This is the purchase menu.");
	}
	
	protected void displayUniqueChoices() {
		//empty
	}
}
