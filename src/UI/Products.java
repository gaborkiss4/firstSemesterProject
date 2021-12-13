package UI;

import java.util.Scanner;
import java.util.ArrayList;

import Model.Product;
import Model.ProductContainer;
import Controller.ProductController;

public class Products {

public Products() {
		
	}
	
	public void start() {
		Products();
	}
	
	public void Products() {
		Scanner scanner = new Scanner(System.in);
		ProductController cntrl = ProductController.getInstance();

		
		boolean running = true;
        while (running) {
            int choice = writeProducts();
            switch (choice) {
                case 1:
                  System.out.println(" Type the name please");
                  String name = scanner.nextLine();
                  
                  ArrayList<Product> results = cntrl.findByName(name);
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
                    System.out.println(" Type the barcode");
                    while (!scanner.hasNextInt()) {
        	            System.out.println("Input must be a number - please try again");
        	            scanner.nextLine();
        	        }
                    int barcode = scanner.nextInt();
                    Product result = cntrl.findByBarcode(barcode);
                    if(result != null) {
                    	System.out.println(result.toString());
                    	
                    }else {
                    	System.out.println("\n\nProduct has not been found with this barcode '"+barcode+"'\n\n");
                    }
                    
                    
                    break;
                case 3:
                	int index = 0;
                	for(Product product : cntrl.getAllProducts()) {
                		System.out.println("("+index+") - "+ product.toString());
                		index++;
                	}
                	
                	selectMenu(cntrl.getAllProducts());
                    break;
                case 4:
                	System.out.println("Enter the products barcode:");
                	barcode = scanner.nextInt();
                	System.out.println("Enter the product's name: ");
                	String pname = scanner.nextLine();
                	System.out.println("Enter the  product's entry date: ");
                	String entryDate = scanner.nextLine();
                	System.out.println("Enter the product's price: ");
                	double price = scanner.nextDouble();
                	System.out.println("Enter the product quantity: ");
                
                	int quantity = scanner.nextInt();
                	System.out.println("Enter the product's location: ");
                	String location = scanner.nextLine();
                	scanner.nextLine();
                	
                	
                	if(cntrl.createProduct(barcode, pname, entryDate, price, quantity,location)) {
                		System.out.println("Product '"+pname+"' has been succesfully added!");
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
	
	 private int writeProducts() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("****** Create Product ******");
	        System.out.println(" (1) Find product by name");
	        System.out.println(" (2) Find product by barcode");
	        System.out.println(" (3) Show all products");
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
