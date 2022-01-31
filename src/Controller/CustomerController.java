package Controller;
import java.util.ArrayList;

import Model.CustomerContainer;
import Model.Product;
import Model.ProductContainer;
import Model.Customer;
//import packageName.Cusomer;
//import packagename.CustomerContainer;
public class CustomerController {

	
	private static CustomerController instance = new CustomerController();
	private CustomerContainer customerContainer;
	
	private CustomerController() {
		customerContainer = CustomerContainer.getInstance();
	}
	
	public static CustomerController getInstance() {
		return instance;
	}
	
	public ArrayList<Customer> findByName(String name) {
		
		return CustomerContainer.getInstance().findByName(name); 
	}
	public ArrayList<Customer> getAllCustomers() {
		
		return CustomerContainer.getInstance().getAllCustomers(); 
	}
	
	public String[][] getTable(){
		ArrayList<Customer> customers = CustomerContainer.getInstance().getAllCustomers();
		int n = customers.size();
		String[][] table = new String[n][5];
		for(int i=0; i<n; i++) {
			table[i][0] = customers.get(i).getName();
			table[i][1] = customers.get(i).getAddress();
			table[i][2] = Integer.toString(customers.get(i).getPostalCode());
			table[i][3] = Integer.toString(customers.get(i).getNumber());
			table[i][4] = customers.get(i).getCity();
		}
		return table;
	}
	
	public Customer findByPhone(int number) { 
	
		return CustomerContainer.getInstance().findByNumber(number); 
	}
	
	public boolean createCustomer(String name,String address,int postalCode,int number,String city) {
		
		if(CustomerContainer.getInstance().findByNumber(number) == null)
			return CustomerContainer.getInstance().addCustomer(new Customer(name, address, postalCode, number, city));
		return false;
	}
	
	public boolean updateCustomer(int oldNumber, String name,String address,int postalCode,int number,String city) {
	
		int customerIndex = customerContainer.getCustomerIndex(oldNumber);
		
		String newName = name == "" ? customerContainer.getAllCustomers().get(customerIndex).getName() : name;
		String newAddress = address == "" ? customerContainer.getAllCustomers().get(customerIndex).getAddress() : address;
		int newPostalCode = postalCode == 0 ? customerContainer.getAllCustomers().get(customerIndex).getPostalCode() : postalCode;  
		int newNumber = number == 0 ? customerContainer.getAllCustomers().get(customerIndex).getNumber() : number;
		String newCity = city == "" ? customerContainer.getAllCustomers().get(customerIndex).getCity() : city;                      
		
		
		
	
		if(customerContainer.findByNumber(newNumber)!= null && oldNumber!= newNumber) { 
			return false;
		}
		
		
		return CustomerContainer.getInstance().updateCustomer(customerIndex, newName,newAddress, newPostalCode, newNumber,newCity);
	}
	
	public boolean deleteCustomer(int number) {
		return CustomerContainer.getInstance().removeCustomer(number);
	}
	
	
	
	
}

