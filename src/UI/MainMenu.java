package UI;

public class MainMenu extends Menu{
	public MainMenu() {
		setName("Main Menu");
	}
	public void setActive() {
		displayMenu();
		choices.add(new PurchaseMenu());
		displayChoices();
	}
	
	public void displayMenu() {
		System.out.println("This is the main menu.");
	}
}
