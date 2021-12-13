package Model;

public class Order {

	
	private String type;
	
    private int orderCode;
    private String orderDate;
    private String orderName;
    private String paid;

    
    
    public Order(int orderCode,String orderDate,String orderName,String type,String paid) {
    	
    	this.orderCode=orderCode;
    	this.orderDate=orderDate;
    	this.orderName=orderName;
    	this.type=type;
    	this.paid = paid;
    	
    }
    public void setPaid(String paid) {
    	
    	this.paid = paid;
    	
    }
    public String getPaid() {
    	
    	return paid;
    }
    public void setType(String type) {
    	
    	this.type=type;
    }
    public String getType() {
    	
    	return type;
    }
    public void setOrderDate(String orderDate) {
    
    	this.orderDate = orderDate;
    }
    
public String getOrderDate() {
    	
    	return orderDate;
}
    public void setOrderName(String orderName) {
    	
    	this.orderName = orderName;
    	
    }
    public String getOrderName() {
    	
    	return orderName;
    	
    }
    
        public void setOrderCode(int orderCode) {
    	
        	this.orderCode=orderCode;
    	
    }
    public int getOrderCode() {
    	
    	
    	return orderCode;
    }
    
    
}
