package UI;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
	private ArrayList<Menu> choices;
	private String name;
	
	protected Menu() {
		choices = new ArrayList<>();
	}
	
	protected abstract void displayMenu();
	
	protected void addChoice(Menu menu) {
		choices.add(menu);
	}
	
	protected int displayChoices() {
		System.out.println("Please enter the number corresponding to your choice:");
		for(int i=0; i<choices.size(); i++) {
			System.out.println((i+1) + " " + choices.get(i).getName());
		}
		displayUniqueChoices();
		int c = choice();
		if(c<choices.size()) {
			choices.get(c).setActive();
			return 0;
		}
		return c+1;
	}
	
	protected void setName(String name) {
		this.name=name;
	}
	
	protected String getName() {
		return name;
	}
	
	protected int choice() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		return n-1;
	}
	
	public abstract void setActive();
	
	protected abstract void displayUniqueChoices();
}
