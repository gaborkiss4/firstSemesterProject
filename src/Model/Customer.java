package Model;

public class Customer {

	private String name;
	private String address;
	private int postalCode;
	private int number;
	private String city;


	public Customer(String name,String address,int postalCode,int number,String city) {
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.number = number;
		this.city = city;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}	
	
	public String getAddress() {
		return address;
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	public int getPostalCode() {
		return postalCode;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
}