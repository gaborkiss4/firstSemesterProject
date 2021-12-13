package UI;
import UI.MainPage;
import java.util.Scanner;
public class Create {
	private Offer offer;
    private CreateCustomer createCustomer;
    private CreateContractor createContractor;
    private CreateProduct createProduct;
    

    
    public Create() {
        
    	 offer = new Offer();
        createCustomer = new CreateCustomer();
        createContractor = new CreateContractor();
        createProduct = new CreateProduct();
        
    }
    
    public void start() {
        create();
    }
    
    private void create() {
        boolean running = true;
        while (running) {
            int choice = writeMainPage();
            switch (choice) {
                case 1:
                	offer.start();
                  break;
                case 2:
                	createCustomer.start();
                  break;
                case 3:
                  createContractor.start();
                  break;
                case 4:
                	createProduct.start();
                	break;
                case 5:
                	running = false;
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
        System.out.println("****** Creative ******");
        System.out.println(" (1) New offer");
        System.out.println(" (2) Create Customer");
        System.out.println(" (3) Create Contractor");
        System.out.println(" (4) Add Products");
        System.out.println(" (5) Go back?");
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choice:");
        
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number - please try again");
            scanner.nextLine();
        }
        int choice = scanner.nextInt();
        return choice;
    }
}
