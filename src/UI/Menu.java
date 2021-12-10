package UI;

import java.util.ArrayList;

public abstract class Menu {
	private ArrayList<Menu> choices;
	private String name;
	
	public Menu() {
		choices = new ArrayList<>();
	}
	
	public abstract void displayMenu();
	
	public void addChoice(Menu menu) {
		choices.add(menu);
	}
	
	public void displayChoices() {
		System.out.println("Please enter the number corresponding to your choice:");
		for(int i=0; i<choices.size(); i++) {
			System.out.println((i+1) + " " + choices.get(i).getName());
		}
	}
	
	protected void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
}
