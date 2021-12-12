package UI;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
	protected ArrayList<Menu> choices;
	private String name;
	
	protected Menu() {
		choices = new ArrayList<>();
	}
	
	protected abstract void displayMenu();
	
	protected void addChoice(Menu menu) {
		choices.add(menu);
	}
	
	protected void displayChoices() {
		System.out.println("Please enter the number corresponding to your choice:");
		for(int i=0; i<choices.size(); i++) {
			System.out.println((i+1) + " " + choices.get(i).getName());
		}
		choices.get(choice()).setActive();
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
}
