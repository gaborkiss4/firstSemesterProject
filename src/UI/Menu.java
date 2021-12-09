package UI;

import java.util.ArrayList;

public abstract class Menu {
	private ArrayList<Menu> subMenu;
	
	public Menu() {
		subMenu = new ArrayList<>();
	}
	
	public abstract void displayMenu();
	
	
}
