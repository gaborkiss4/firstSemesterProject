package UI;
import java.util.Scanner;
public class MainPage {
	private Create create;
    private Contractors contractors;
    private Orders orders;
    private Products products;
    private Customers customers;
    private Delivery delivery;
    private Revenue revenue;
    
    
    

    
    public MainPage() {
       
        create = new Create();
        contractors = new Contractors();
        orders = new Orders();
        products = new Products();
        customers = new Customers();
        delivery = new Delivery();
        revenue = new Revenue();
        
    }
    
    public void start() {
        mainPage();
    }
    
    private void mainPage() {
        boolean running = true;
        while (running) {
            int choice = writeMainPage();
            switch (choice) {
                case 1:
                	create.start();
                  break;
                case 2:
                	contractors.start();
                  break;
                case 3:
                    orders.start();
                    break;
                  case 4:
                  	products.start();
                  case 5:
                  	customers.start(); 
                  
                  	
                    break;
                    
                case 0:
                  System.out.println(" Thank you and goodbye.");
                  running = false;
                  break;
                default:
                  System.out.println(" Unknown error occured, choice = "+choice);
                  break;
            }
        }
    }

    private int writeMainPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** Main menu ******");
        System.out.println(" (1) Create");
        System.out.println(" (2) Contractors");
        System.out.println(" (3) Orders");
        System.out.println(" (4) Products");
        System.out.println(" (5) Customers");
        System.out.println("(6) Delivery");
        System.out.println("(7) Revenue");
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choice:");
        
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number - please try again");
            scanner.nextInt();
        }
        int choice = scanner.nextInt();
        return choice;
    }
   
}