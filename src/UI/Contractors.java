package UI;
import Model.Contractor;
import Model.ContractorContainer;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.ContractorController;
public class Contractors {

public Contractors() {
		
	}
	
	public void start() {
		Contractors();
	}
	
	public void Contractors() {
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
                	int index = 0;
                	for(Contractor contractor : cntrl.getAllContractors()) {
                		System.out.println("("+index+") - "+ contractor.toString());
                		index++;
                	}
                	
                	selectMenu(cntrl.getAllContractors());
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
	        System.out.println(" (1) Search the contractor by name");
	        System.out.println(" (2) Show all contractors");
	        
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