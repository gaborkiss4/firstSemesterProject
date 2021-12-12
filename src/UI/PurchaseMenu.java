package UI;

public class PurchaseMenu extends Menu{
	public PurchaseMenu() {
		setName("Purchase Menu");
	}
	public void setActive() {
		displayMenu();
		choices.add(new MainMenu());
		displayChoices();
	}
	public void displayMenu() {
		System.out.println("This is the purchase menu.");
	}
}
