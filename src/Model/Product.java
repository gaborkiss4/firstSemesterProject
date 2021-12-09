package Model;

public class Product {

	
	private int barcode;
	private String Pname;
	private String entryDate;
	private double price;
	private int stored;
	private int quantity;
	private String location; // in which building the product is located
	
	public Product(int barcode,String Pname,String entryDate,double price,int quantity) {
		
		this.barcode = barcode;
		this.Pname = Pname;
		this.entryDate = entryDate;
		this.price = price;
		this.quantity = quantity;
		
		
	}
	public void setQuantity(int quantity) {
		getStored();
		this.quantity=quantity;
		stored= quantity +stored;
			setStored(stored);
	}
	public int getQuantity() {
	
		return quantity;
	}
	public void setStored(int stored) {
		this.stored=stored;
		
	}
	
	public int getStored() {
		return  stored;
	}
	
	public void setPrice(double price) {
		this.price= price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setBarcode(int barcode) {
		this.barcode= barcode;	
	}
	
	public int getBarcode() {
		return barcode;	
	}
	
	public void setPname(String Pname) {
		this.Pname= Pname;
	}
	
	public String getPname() {
		return Pname;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate= entryDate;
	}
	
	public String getEntryDate() {
		return entryDate;	
	}
	
	public void setLocation(String location) {
		// valid options should be lumber, diy, both
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
	
}
