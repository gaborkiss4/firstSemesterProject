package UI;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.CustomerController;
import Model.Customer;
import Model.CustomerContainer;

public class Customers {
	public Customers() {
		
	}
	
	public void start() {
		Customers();
	}
	
	public void Customers() {
		Scanner scanner = new Scanner(System.in);
        CustomerController cntrl = CustomerController.getInstance();

		
		boolean running = true;
        while (running) {
            int choice = writeCreateCustomer();
            switch (choice) {
                case 1:
                  System.out.println(" Type the name please");
                  String name = scanner.nextLine();
                  
                  ArrayList<Customer> results = cntrl.findByName(name);
                  if(results.size() == 0) {
                	  System.out.println("No results with keyword '"+ name +"' have been found");
                	  break;
                  }
                  
                  for(int i = 0; i < results.size(); i++) {
                	  System.out.println("("+i+") - "+ results.get(i).toString());
                  }
                  
                  selectMenu(results);
                  break;
                
                case 2:
                	int index = 0;
                	for(Customer customer : cntrl.getAllCustomers()) {
                		System.out.println("("+index+") - "+ customer.toString());
                		index++;
                	}
                	
                	selectMenu(cntrl.getAllCustomers());
                    break;
              
                case 0:
                  running = false;
                  break;
                default:
                  System.out.println(" Unknown error occured, choice = " + choice);
                  break;
            }
        }
	}
	
	 private int writeCreateCustomer() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("****** Create Customer ******");
	        System.out.println(" (1) Find customers by name");
	        
	        System.out.println(" (2) Show all customers");
	        
	        System.out.println(" (0) Back");
	        System.out.print("\n Choice:");
	        int choice = getIntegerFromUser(scanner);
	        return choice;
	 }
	 
	 
	
		

	 
	 public void selectMenu(ArrayList<Customer> customers) { //method where we can edit or remove person
		 Scanner scanner = new Scanner(System.in);
	        CustomerController cntrl = CustomerController.getInstance();

			
			boolean running = true;
	        while (running) {
	            int choice = writeSelectMenu();
	            switch (choice) {
	                case 1:
	                	System.out.println("Select a customer by typing an index: ");
	                	int index = scanner.nextInt();
	                	scanner.nextLine();
	                	
	                	if(index < 0 || index >= customers.size()) {
	                		System.out.println("Wrong index!");
	                		break;
	                	}
	                	
	                	
	                	
	                	running = false;
	                  break;
	                case 0:
	                  running = false;
	                  break;
	                default:
	                  System.out.println(" Unknown error occured, choice = " + choice);
	                  break;
	            }
	        }
	 }
	 
	 private int writeSelectMenu() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("****** Customer Select Menu ******");
	        System.out.println(" (1) Select a customer");
	        System.out.println(" (0) Back");
	        System.out.print("\n Choice:");
	        int choice = getIntegerFromUser(scanner);
	        return choice;
	 }

	 private int getIntegerFromUser(Scanner scanner) {
	        while (!scanner.hasNextInt()) {
	            System.out.println("Input must be a number - please try again");
	            scanner.nextLine();
	        }
	        return scanner.nextInt();
	    }
}