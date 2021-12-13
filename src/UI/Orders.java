package UI;

import java.util.Scanner;
import java.util.ArrayList;

import Model.Order;
import Model.OrderContainer;
import Controller.OrderController;

public class Orders {

public Orders() {
		
	}
	
	public void start() {
		Orders();
	}
	
	public void Orders() {
		Scanner scanner = new Scanner(System.in);
		OrderController cntrl = OrderController.getInstance();

		
		boolean running = true;
        while (running) {
            int choice = writeOrders();
            switch (choice) {
                case 1:
                  System.out.println(" Type the name please");
                  String orderName = scanner.nextLine();
                  
                  ArrayList<Order> results = cntrl.findByName(orderName);
                  if(results.size() == 0) {
                	  System.out.println("No results with keyword '"+ orderName +"' have been found");
                	  break;
                  }
                  
                  for(int i = 0; i < results.size(); i++) {
                	  System.out.println("("+i+") - "+ results.get(i).toString());
                  }
                  
                  selectMenu(results);
                  break;
                case 2:
                    System.out.println(" Type the ordercode");
                    while (!scanner.hasNextInt()) {
        	            System.out.println("Input must be a number - please try again");
        	            scanner.nextLine();
        	        }
                    int orderCode = scanner.nextInt();
                    Order result = cntrl.findByOrderCode(orderCode);
                    if(result != null) {
                    	System.out.println(result.toString());
                    	
                    }else {
                    	System.out.println("\n\nProduct has not been found with this barcode '"+orderCode+"'\n\n");
                    }
                    
                    
                    break;
                case 3:
                	int index = 0;
                	for(Order order : cntrl.getAllOrders()) {
                		System.out.println("("+index+") - "+ order.toString());
                		index++;
                	}
                	
                	selectMenu(cntrl.getAllOrders());
                    break;
                
                default:
                  System.out.println(" Unknown error occured, choice = " + choice);
                  break;
            }
        }
	}
	
	 private int writeOrders() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("****** Orders ******");
	        System.out.println(" (1) Find order by name");
	        System.out.println(" (2) Find order by barcode");
	        System.out.println(" (3) Show all orders");
	        System.out.println(" (0) Back");
	        System.out.print("\n Choice:");
	        int choice = getIntegerFromUser(scanner);
	        return choice;
	 }
	 
	 
	 
	
	 
	 public void selectMenu(ArrayList<Order> Orders) { //method where we can edit or remove person
		 Scanner scanner = new Scanner(System.in);
		 OrderController cntrl = OrderController.getInstance();

			
			boolean running = true;
	        while (running) {
	            int choice = writeSelectMenu();
	            switch (choice) {
	                case 1:
	                	System.out.println("Select an order by typing an index: ");
	                	int index = scanner.nextInt();
	                	scanner.nextLine();
	                	
	                	if(index < 0 || index >= Orders.size()) {
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
	        System.out.println("****** Order Select Menu ******");
	        System.out.println(" (1) Select an order");
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
