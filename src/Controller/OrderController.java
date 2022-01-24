package Controller;
import java.util.ArrayList;

import Model.Contractor;
import Model.ContractorContainer;
import Model.Order;
import Model.OrderContainer;
public class OrderController {

	private static OrderController instance = new OrderController();
	private OrderContainer orderContainer;
	
	private OrderController() {
		orderContainer = OrderContainer.getInstance();
	}
	
	public static OrderController getInstance() {
		return instance;
	}
	
	public ArrayList<Order> findByName(String orderName) {
		
		return OrderContainer.getInstance().findByOrderName(orderName); 
	}
	public ArrayList<Order> getAllOrders() {
		
		return OrderContainer.getInstance().getAllOrders(); 
	}
	
	public String[][] getTable(){
		ArrayList<Order> orders = OrderContainer.getInstance().getAllOrders();
		int n = orders.size();
		String[][] table = new String[n][5];
		for(int i=0; i<n; i++) {
			table[i][0] = Integer.toString(orders.get(i).getOrderCode());
			table[i][1] = orders.get(i).getOrderDate();
			table[i][2] = orders.get(i).getOrderName();
			table[i][3] = orders.get(i).getType();
			table[i][4] = orders.get(i).getPaid();
		}
		return table;
	}
	
	public Order findByOrderCode(int orderCode) { 
	
		return OrderContainer.getInstance().findByOrderCode(orderCode); 
	}
	
	public boolean createOrder(int orderCode,String orderDate,String orderName,String type,String paid) {
		
		if(OrderContainer.getInstance().findByOrderCode(orderCode) == null)
			return OrderContainer.getInstance().addOrder(new Order(orderCode,orderDate, orderName, type, paid));
		return false;
	}
	
	public boolean updateOrder(int oldOrderCode,int orderCode,String orderDate,String orderName,String type,String paid) {
	
		int OrderIndex= orderContainer.getOrderIndex(oldOrderCode);
		
		 int newOrderCode = orderCode == 0 ? orderContainer.getAllOrders().get(OrderIndex).getOrderCode() : orderCode;
		String newOrderDate = orderDate == "" ? orderContainer.getAllOrders().get(OrderIndex).getOrderDate() : orderDate;
		String newOrderName = orderName == "" ? orderContainer.getAllOrders().get(OrderIndex).getOrderName() : orderName;
		String newType = type == "" ? orderContainer.getAllOrders().get(OrderIndex).getType() : type;  
		String newPaid = paid == "" ? orderContainer.getAllOrders().get(OrderIndex).getPaid() : paid;
		
		
		
	
		
		
		
		return OrderContainer.getInstance().updateOrder(OrderIndex,newOrderCode, newOrderDate,newOrderName, newType, newPaid);
	}
	
	public boolean deleteOrder(int orderCode) {
		return OrderContainer.getInstance().removeOrder(orderCode);
	}
	
	
	
	
}
   
