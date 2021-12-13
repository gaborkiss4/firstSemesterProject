package Model;
import java.util.ArrayList;
import java.util.Iterator;
public class OrderContainer {

	private ArrayList<Order> orders;
	private static OrderContainer instance;
	
	private OrderContainer() {
		
		orders= new ArrayList<>();
		
	}
	public static OrderContainer getInstance() {
		
		if (instance == null) {
			
			instance = new OrderContainer();
		}
		return instance;
	}
	public boolean addOrder(Order order) {
		
		return orders.add(order);
	}
	public boolean updateOrder(int orderindex,int orderCode,String orderDate,String orderName,String type,String paid) 
	{
		orders.get(orderindex).setOrderCode(orderCode);
		orders.get(orderindex).setOrderDate(orderDate);
		orders.get(orderindex).setOrderName(orderName);
		orders.get(orderindex).setType(type);
		orders.get(orderindex).setPaid(paid);
		
		return true;
	}
	public boolean removeOrder(int orderCode) {
		Iterator<Order> orderIterator = orders.iterator();  //--------------------------------------------------
		
		while(orderIterator.hasNext()) {
			if(orderIterator.next().getOrderCode() == orderCode) {
				orderIterator.remove();
				return true;
			}
		}
		return false;
	}
	public ArrayList<Order> findByOrderName(String orderName) {      
		ArrayList<Order> results = new ArrayList<>();
		for (Order order : orders) {                 //--------------------------------------------------
			if (order.getOrderName().toLowerCase().contains(orderName.toLowerCase())) {
				results.add(order);
			}
		}
		return results;
	}
	
	public Order findByOrderCode(int orderCode) {       //--------------------------------------------------
		for (Order order : orders) {
			if (order.getOrderCode() == orderCode) {
				return order;
			}
		}
		return null;
	}
	
	public int getOrderIndex(int orderCode) { //--------------------------------------------------
		int OrderIndex = -1;
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderCode() == orderCode)  //gets an index of a person
				OrderIndex = i;
		}
		return OrderIndex;
	}
	
	public ArrayList<Order> getAllOrders(){
		return orders;
	}
	
	
	
	
	
	
}
