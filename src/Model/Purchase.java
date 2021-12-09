package Model;
import java.util.HashMap;

public class Purchase {
	private HashMap<Product,Integer> items;
	private Customer customer;
	private Employee employee; //employee making the sale
	private String department;
}
