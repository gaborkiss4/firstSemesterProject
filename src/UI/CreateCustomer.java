package UI;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.CustomerController;
import Model.Customer;
import Model.CustomerContainer;

public class CreateCustomer {
	public CreateCustomer() {
		
	}
	
	public void start() {
		createCustomer();
	}
	
	public void createCustomer() {
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
                    System.out.println(" Type the phone number");
                    while (!scanner.hasNextInt()) {
        	            System.out.println("Input must be a number - please try again");
        	            scanner.nextLine();
        	        }
                    int number = scanner.nextInt();
                    Customer result = cntrl.findByPhone(number);
                    if(result != null) {
                    	System.out.println(result.toString());
                    	editMenu(result);
                    }else {
                    	System.out.println("\n\nCustomer has not been found with phone number '"+number+"'\n\n");
                    }
                    
                    
                    break;
                case 3:
                	int index = 0;
                	for(Customer customer : cntrl.getAllCustomers()) {
                		System.out.println("("+index+") - "+ customer.toString());
                		index++;
                	}
                	
                	selectMenu(cntrl.getAllCustomers());
                    break;
                case 4:
                	System.out.println("Enter customer's name: ");
                	String customerName = scanner.nextLine();
                	System.out.println("Enter customer's address: ");
                	String address = scanner.nextLine();
                	System.out.println("Enter customer's postal code: ");
                	int postalCode = scanner.nextInt();
                	System.out.println("Enter customer's city: ");
                	scanner.nextLine();
                	String city = scanner.nextLine();
                	System.out.println("Enter customer's phone number: ");
                	int phonenumber = scanner.nextInt();
                	scanner.nextLine();
                	
                	if(cntrl.createCustomer(customerName, address, postalCode, phonenumber,city)) {
                		System.out.println("Customer '"+customerName+"' has been succesfully added!");
                	}
                	else {
                		System.out.println("Something went wrong!");
                	}
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
	        System.out.println(" (1) Find customer by name");
	        System.out.println(" (2) Find customer by phone number");
	        System.out.println(" (3) Show all customers");
	        System.out.println(" (4) Add a new customer");
	        System.out.println(" (0) Back");
	        System.out.print("\n Choice:");
	        int choice = getIntegerFromUser(scanner);
	        return choice;
	 }
	 
	 
	 
	 public void editMenu(Customer customer) { //method where we can edit or remove person
		 Scanner scanner = new Scanner(System.in);
	        CustomerController cntrl = CustomerController.getInstance();

			
			boolean running = true;
	        while (running) {
	            int choice = writeEditMenu(customer);
	            switch (choice) {
	                case 1:
	                	System.out.println("Enter customer's name or leave it blank to not make any changes: ");
	                	String customerName = scanner.nextLine();
	                	System.out.println("Enter customer's address or leave it blank to not make any changes: ");
	                	String address = scanner.nextLine();
	                	System.out.println("Enter customer's postal code or type '0' to not make any changes: ");
	                	int postalCode = scanner.nextInt();
	                	System.out.println("Enter customer's city or leave it blank to not make any changes: ");
	                	scanner.nextLine();
	                	String city = scanner.nextLine();
	                	System.out.println("Enter person's phone number or type '0' to not make any changes: ");
	                	int number = scanner.nextInt();
	                	scanner.nextLine();
	                	
	                	if(cntrl.updateCustomer(customer.getNumber(),customerName, address, postalCode, number,city)) {
	                		System.out.println("Customer has been succesfully edited!");
	                		running = false;
	                	}
	                	else {
	                		System.out.println("Something went wrong!");
	                	}
	                  break;
	                case 2:

	                	if(cntrl.deleteCustomer(customer.getNumber())) {
	                		System.out.println("Customer has been deleted!");
	                		running = false;
	                	}
	                	else {
	                		System.out.println("Something went wrong!");
	                	}
	                	
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
	 
	 private int writeEditMenu(Customer customer) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("****** Customer ******");
	        System.out.println(" (1) Edit "+ customer.getName() +" information");
	        System.out.println(" (2) Remove person "+ customer.getName());
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
	                	
	                	editMenu(customers.get(index));
	                	
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