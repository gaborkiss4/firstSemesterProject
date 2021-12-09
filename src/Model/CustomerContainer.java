package Model;
import java.util.ArrayList;
import java.util.Iterator;
public class CustomerContainer {

	private ArrayList<Customer> customers;
	private static CustomerContainer instance;
	
	private CustomerContainer() {
		
		customers= new ArrayList<>();
		
	}
	public static CustomerContainer getInstance() {
		
		if (instance == null) {
			
			instance = new CustomerContainer();
		}
		return instance;
	}
	public boolean addCustomer(Customer customer) {
		
		return customers.add(customer);
	}
	public boolean updateCustomer(int index,String name,String address,int postalCode,int number,String city) 
	{
		customers.get(index).setName(name);
		customers.get(index).setAddress(address);
		customers.get(index).setPostalCode(postalCode);
		customers.get(index).setNumber(number);
		customers.get(index).setCity(city);
		return true;
	}
	public boolean removeCustomer(int number) {
		Iterator<Customer> customerIterator = customers.iterator();  //--------------------------------------------------
		
		while(customerIterator.hasNext()) {
			if(customerIterator.next().getNumber() == number) {
				customerIterator.remove();
				return true;
			}
		}
		return false;
	}
	public ArrayList<Customer> findByName(String name) {      
		ArrayList<Customer> results = new ArrayList<>();
		for (Customer customer : customers) {                 //--------------------------------------------------
			if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
				results.add(customer);
			}
		}
		return results;
	}
	
	public Customer findByNumber(int number) {       //--------------------------------------------------
		for (Customer customer : customers) {
			if (customer.getNumber() == number) {
				return customer;
			}
		}
		return null;
	}
	
	public int getCustomerIndex(int number) { //--------------------------------------------------
		int customerIndex = -1;
		for(int i = 0; i < customers.size(); i++) {
			if(customers.get(i).getNumber() == number)  //gets an index of a person
				customerIndex = i;
		}
		return customerIndex;
	}
	
	public ArrayList<Customer> getAllPeople(){
		return customers;
	}
	
}
