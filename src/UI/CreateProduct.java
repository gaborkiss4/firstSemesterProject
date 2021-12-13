package UI;

import java.util.Scanner;
import java.util.ArrayList;

import Model.Product;
import Model.ProductContainer;
import Controller.ProductController;

public class CreateProduct {

public CreateProduct() {
		
	}
	
	public void start() {
		createProduct();
	}
	
	public void createProduct() {
		Scanner scanner = new Scanner(System.in);
		ProductController cntrl = ProductController.getInstance();

		
		boolean running = true;
        while (running) {
            int choice = writeCreateProduct();
            switch (choice) {
                case 1:
                  System.out.println(" Type the name please");
                  String name = scanner.nextLine();
                  
                  ArrayList<Product> resul = cntrl.findByName(name);
                  if(resul.size() == 0) {
                	  System.out.println("No results with keyword '"+ name +"' have been found");
                	  break;
                  }
                  
                  for(int i = 0; i < resul.size(); i++) {
                	  System.out.println("("+i+") - "+ resul.get(i).toString());
                  }
                  
                  selectMenu(resul);
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
                    	editMenu(result);
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
                	String ame = scanner.nextLine();
                	scanner.nextLine();
                	
                	System.out.println("Enter the  product's entry date: ");
                	String entryDate = scanner.nextLine();
                	System.out.println("Enter the product's price: ");
                	double price = scanner.nextDouble();
                	System.out.println("Enter the product quantity: ");
                
                	int quantity = scanner.nextInt();
                	System.out.println("Enter the product's location: ");
                	String location = scanner.nextLine();
                	scanner.nextLine();
                	
                	ProductContainer.getInstance().addProduct(new Product(barcode,ame, entryDate, price, quantity,location));
                		
                	
                	
                	
                	if(cntrl.createProduct(barcode,ame, entryDate, price, quantity,location)) {
                		System.out.println("Product '"+ame+"' has been succesfully added!");
                	}
                	else {
                		System.out.println("Success");
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
	
	 private void product(int barcode, String ame, String entryDate, double price, int quantity, String location) {
		// TODO Auto-generated method stub
		
	}

	private int writeCreateProduct() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("****** Create Product ******");
	        System.out.println(" (1) Find product by name");
	        System.out.println(" (2) Find product by barcode");
	        System.out.println(" (3) Show all products");
	        System.out.println(" (4) Add a new product");
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
	                	System.out.println("Enter the products barcode or leave it blank to not make any changes:");
	                	int barcod= scanner.nextInt();
	                	System.out.println("Enter the product's name or leave it blank to not make any changes: ");
	                	String pname = scanner.nextLine();
	                	System.out.println("Enter the  product's entry date or leave it blank to not make any changes: ");
	                	String entryDate = scanner.nextLine();
	                	System.out.println("Enter the product's price or leave it blank to not make any changes: ");
	                	double price = scanner.nextDouble();
	                	System.out.println("Enter the product quantity or leave it blank to not make any changes: ");
	                
	                	int quantity = scanner.nextInt();
	                	System.out.println("Enter the product's location or leave it blank to not make any changes: ");
	                	String location = scanner.nextLine();
	                	scanner.nextLine();
	                	
	                	
	                	
	                	if(cntrl.updateProduct(product.getBarcode(),barcod,pname, entryDate, price, quantity,location)) {
	                		System.out.println("The product has been succesfully edited!");
	                		running = false;
	                	}
	                	else {
	                		System.out.println("Something went wrong!");
	                	}
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
	        System.out.println(" (1) Edit "+ product.getPname() +" information");
	        System.out.println(" (2) Remove product "+ product.getPname());
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
