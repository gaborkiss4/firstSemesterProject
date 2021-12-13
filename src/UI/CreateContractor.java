package UI;

import java.util.Scanner;
import java.util.ArrayList;

import Model.Contractor;
import Model.ContractorContainer;
import Controller.ContractorController;

public class CreateContractor {

	public CreateContractor() {
		
	}
	
	public void start() {
		createContractor();
	}
	
	public void createContractor() {
		Scanner scanner = new Scanner(System.in);
		ContractorController cntrl = ContractorController.getInstance();

		
		boolean running = true;
        while (running) {
            int choice = writeCreateContractor();
            switch (choice) {
                case 1:
                  System.out.println(" Type the firm name please");
                  String name = scanner.nextLine();
                  
                  ArrayList<Contractor> results = cntrl.findByName(name);
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
                    System.out.println(" Type the company service number");
                    while (!scanner.hasNextInt()) {
        	            System.out.println("Input must be a number - please try again");
        	            scanner.nextLine();
        	        }
                    int number = scanner.nextInt();
                    Contractor result = cntrl.findByServiceNumber(number);
                    if(result != null) {
                    	System.out.println(result.toString());
                    	editMenu(result);
                    }else {
                    	System.out.println("\n\nContractor has not been found with phone number '"+number+"'\n\n");
                    }
                    
                    
                    break;
                case 3:
                	int index = 0;
                	for(Contractor contractor : cntrl.getAllContractors()) {
                		System.out.println("("+index+") - "+ contractor.toString());
                		index++;
                	}
                	
                	selectMenu(cntrl.getAllContractors());
                    break;
                case 4:
                	System.out.println("Enter the firm's name: ");
                	String contractorName = scanner.nextLine();
                	System.out.println("Enter the starting date of cooperation: ");
                	String startDate = scanner.nextLine();
                	System.out.println("Enter the name of the firm's director : ");
                	String directorName = scanner.nextLine();
                	System.out.println("Enter the director's number: ");
                	int directorNumber = scanner.nextInt();
                	System.out.println("Enter firm's official number: ");
                	int serviceNumber = scanner.nextInt();
                	scanner.nextLine();
                	
                	if(cntrl.createContractor(contractorName, startDate, directorName, directorNumber,serviceNumber)) {
                		System.out.println("Contractor '"+contractorName+"' has been succesfully added!");
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
	
	 private int writeCreateContractor() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("****** Create Contractor ******");
	        System.out.println(" (1) Find contractor by name");
	        System.out.println(" (2) Find contractor by phone number");
	        System.out.println(" (3) Show all contractors");
	        System.out.println(" (4) Add a new contractor");
	        System.out.println(" (0) Back");
	        System.out.print("\n Choice:");
	        int choice = getIntegerFromUser(scanner);
	        return choice;
	 }
	 
	 
	 
	 public void editMenu(Contractor contractor) { //method where we can edit or remove person
		 Scanner scanner = new Scanner(System.in);
	        ContractorController cntrl = ContractorController.getInstance();

			
			boolean running = true;
	        while (running) {
	            int choice = writeEditMenu(contractor);
	            switch (choice) {
	                case 1:
	                	
	                	System.out.println("Enter the firm's name or leave it blank to not make any changes: ");
	                	String contractorName = scanner.nextLine();
	                	System.out.println("Enter the starting date of cooperation or leave it blank to not make any changes: ");
	                	String startDate = scanner.nextLine();
	                	System.out.println("Enter the name of the firm's director or leave it blank to not make any changes : ");
	                	String directorName = scanner.nextLine();
	                	System.out.println("Enter the director's number or leave it blank to not make any changes: ");
	                	int directorNumber = scanner.nextInt();
	                	System.out.println("Enter firm's official number or leave it blank to not make any changes: ");
	                	int serviceNumber = scanner.nextInt();
	                	scanner.nextLine();
	                	
	                	
	                	if(cntrl.updateContractor(contractor.getServiceNumber(),contractorName, startDate, directorName, directorNumber,serviceNumber)) {
	                		System.out.println("Customer has been succesfully edited!");
	                		running = false;
	                	}
	                	else {
	                		System.out.println("Something went wrong!");
	                	}
	                  break;
	                case 2:

	                	if(cntrl.deleteContractor(contractor.getServiceNumber())) {
	                		System.out.println("Contractor has been deleted!");
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
	 
	 private int writeEditMenu(Contractor contractor) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("****** Contractor ******");
	        System.out.println(" (1) Edit "+ contractor.getFirm() +" information");
	        System.out.println(" (2) Remove person "+ contractor.getFirm());
	        System.out.println(" (0) Back");
	        System.out.print("\n Choice:");
	        int choice = getIntegerFromUser(scanner);
	        return choice;
	 }
	 
	 
	 public void selectMenu(ArrayList<Contractor> contractors) { //method where we can edit or remove person
		 Scanner scanner = new Scanner(System.in);
	        ContractorController cntrl = ContractorController.getInstance();

			
			boolean running = true;
	        while (running) {
	            int choice = writeSelectMenu();
	            switch (choice) {
	                case 1:
	                	System.out.println("Select a contractor by typing an index: ");
	                	int index = scanner.nextInt();
	                	scanner.nextLine();
	                	
	                	if(index < 0 || index >= contractors.size()) {
	                		System.out.println("Wrong index!");
	                		break;
	                	}
	                	
	                	editMenu(contractors.get(index));
	                	
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
	        System.out.println("****** Contractor Select Menu ******");
	        System.out.println(" (1) Select a contractor");
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
