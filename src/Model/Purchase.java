package Model;
import java.util.ArrayList;

public class Purchase {
	private ArrayList<PurchaseItem> items;
	private Customer customer;
	private Employee employee; //employee making the sale
	private String department;
	
	public Purchase(Customer customer, Employee employee, String department) {
		this.customer = customer;
		this.employee = employee;
		this.department = department;
		items = new ArrayList<>();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public String getDepartment() {
		return department;
	}
	
	private double calculatePrice() {
		double price = 0;
		for(PurchaseItem i : items) {
			double bulkDiscount = 0;
			if(i.getAmount()>=50) bulkDiscount = 0.05;  //50 and 100 are numbers I made
			if(i.getAmount()>=100) bulkDiscount = 0.15; //up for what qualifies as a bulk purchase
			price+=i.getAmount()*i.getProduct().getPrice()*bulkDiscount;
		}
		return price;
	}
	
	public double getPrice() {
		return calculatePrice();
	}
	
	public void addToPurchase(Product product, int quantity) {
		//probably needs some form of checking if the product is available
		items.add(new PurchaseItem(product, quantity));
	}
}
