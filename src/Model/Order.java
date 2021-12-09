package Model;

public class Order {

	
	private String type;
	private String inPerson = "in person";   //--NOT
	private String delivered = "delivered";  //----GOOD
    private String orderCode;
    private String orderDate;
    private String orderName;
    private boolean paid;

    
    
    public Order(String orderCode,String orderDate,String orderName,String type,boolean paid) {
    	
    	this.orderCode=orderCode;
    	this.orderDate=orderDate;
    	this.orderName=orderName;
    	this.type=type;
    	this.paid = paid;
    	
    }
    public void setPaid(boolean paid) {
    	this.paid = paid;
    }
    
    public boolean getPaid() {
    	return paid;
    }
    
    public void setType(String type) {
    	this.type=type;
    }
    
    public String getType() {
    	return type;
    }
    
    public void getOrderDate(String orderDate) {
    	this.orderDate = orderDate;
    }
    
    public String setOrderDate() {
    	return orderDate;
    }
    
    public void setOrderName(String orderName) {
    	this.orderName = orderName;
    }
    
    public String getOrderName() {
    	return orderName;
    }
    
    public void setOrderCode(String orderCode) {
        this.orderCode=orderCode;
    }
    
    public String getOrderCode() {
    	return orderCode;
    }
    
    
}
