package UI;

import java.util.Scanner;
import java.util.ArrayList;

import UI.Revenue;
import UI.Products;
import Model.Product;
import Model.ProductContainer;
import Controller.ProductController;

public class Offer {

public Offer() {
		
	}
	
	public void start() {
		offer();
	}
	
	public void offer() {
		Scanner scanner = new Scanner(System.in);
		ProductController cntrl = ProductController.getInstance();

		
		boolean running = true;
        while (running) {
            int choice = writeOffer();
            switch (choice) {
        
                case 1:
                    System.out.println(" Type the product's barcode");
                    while (!scanner.hasNextInt()) {
        	            System.out.println("Input must be a number - please try again");
        	            scanner.nextLine();
        	        }
                    int barcode = scanner.nextInt();
                    Product result = cntrl.findByBarcode(barcode);
                    if(result != null) {
                    	System.out.println(result.toString());
                    	editMenu(result);
                    }else {
                    	System.out.println("\n\nProduct has not been found with this barcode '"+barcode+"'\n\n");
                    }
                    
                    
                    break;
                case 2:
                	System.out.println("Enter the barcode of the product you would like to reserve?");
                	while (!scanner.hasNextInt()) {
        	            System.out.println("Input must be a number - please try again");
        	            scanner.nextLine();
        	        }
                    int barcodes = scanner.nextInt();
                    Product resultss = cntrl.findByBarcode(barcodes);
                    if(resultss != null) {
                    	System.out.println(resultss.toString());
                    	orderMenu(resultss);
                    }else {
                    	System.out.println("\n\nProduct has not been found with this barcode '"+barcodes+"'\n\n");
                    }
                 
                    break;
                	
                    
                
               
                case 0:
                  running = false;
                  break;
                default:
                  System.out.println(" Unknown error occured, choice = " + choice);
                  break;
            }}
        }
        public void orderMenu(Product product) { 
   		 Scanner scanner = new Scanner(System.in);
   	        ProductController cntrl = ProductController.getInstance();
   	        
   	     boolean running = true;
	        while (running) {
	        	
	        	System.out.println("How many units do you want?" + "Available " + product.getQuantity() );
	        	int units = scanner.nextInt();
	        	  int u = product.getQuantity() - units;
	        	  product.setQuantity(u);
	        	
	        	  while(u<0) {
	        		System.out.println("NOT enough in the storage only " +" " + product.getStored() + "left"  );
	        	
	        	  }
	        	  if(u>=0)
	        		  System.out.println("Your order is ready");
	        }
   	        
	        writeOffer();
   	        
   	        
   	        
   	        
	}
	
	 private int writeOffer() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("****** Sell Product ******");
	       
	        System.out.println(" (1) Find product by barcode");
	        System.out.println(" (2) Customer order");
	        System.out.println(" (3) Local conveyance");
	        System.out.println(" (0) Back");
	        System.out.print("\n Choice:");
	        int choice = getIntegerFromUser(scanner);
	        return choice;
	 }
	 
	 
	 
	 public void editMenu(Product product) { //method where we can edit or remove person
		 Scanner scanner = new Scanner(System.in);
	        ProductController cntrl = ProductController.getInstance();

			
			boolean running = true;
	        while (running) {
	            int choice = writeEditMenu(product);
	            switch (choice) {
	                case 1:
	                	System.out.println("The product's price is " + product.getPrice() + " ' per unit" );
	                	System.out.println("How many units would you like to buy?");
	                	int minus = scanner.nextInt();
	                    double price=   product.getPrice()* minus;
	                	
	                	product.setPrice(price);
	                	System.out.println("That would be " + product.getPrice() + " '$" );
	                	
	                	
	                	
	                	
	                	
	                  break;
	                case 2:

	                	if(cntrl.deleteProduct(product.getBarcode())) {
	                		System.out.println("Product has been deleted!");
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
	 
	 private int writeEditMenu(Product product) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("****** Product ******");
	        System.out.println(" (1) Sell "+ product.getPname() +" to the customer");
	        System.out.println(" (2) "+ product.getPname() + " 'discount?");
	        System.out.println(" (0) Back");
	        System.out.print("\n Choice:");
	        int choice = getIntegerFromUser(scanner);
	        return choice;
	 }
	 
	 
	 public void selectMenu(ArrayList<Product> Products) { //method where we can edit or remove person
		 Scanner scanner = new Scanner(System.in);
		 ProductController cntrl = ProductController.getInstance();

			
			boolean running = true;
	        while (running) {
	            int choice = writeSelectMenu();
	            switch (choice) {
	                case 1:
	                	System.out.println("Select a product by typing an index: ");
	                	int index = scanner.nextInt();
	                	scanner.nextLine();
	                	
	                	if(index < 0 || index >= Products.size()) {
	                		System.out.println("Wrong index!");
	                		break;
	                	}
	                	
	                	editMenu(Products.get(index));
	                	
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
	        System.out.println("****** Product Select Menu ******");
	        System.out.println(" (1) Select a product");
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