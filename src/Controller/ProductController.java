package Controller;
import java.util.ArrayList;
import Model.Product;
import Model.ProductContainer;
public class ProductController {

	private static ProductController instance = new ProductController();
	private ProductContainer productContainer;
	
	private ProductController() {
		productContainer = ProductContainer.getInstance();
	}
	
	public static ProductController getInstance() {
		return instance;
	}
	
	public ArrayList<Product> findByName(String Pname) {
		
		return ProductContainer.getInstance().findByPname(Pname); 
	}
	public ArrayList<Product> getAllProducts() {
		
		return ProductContainer.getInstance().getAllProducts(); 
	}
	
	
	
	public Product findByBarcode(int barcode) { 
	
		return ProductContainer.getInstance().findByBarcode(barcode); 
	}
	
	public boolean createProduct(int barcode,String Pname,String entryDate,double price,int quantity,String location) {
		
		if(ProductContainer.getInstance().findByBarcode(barcode) == null)
			return ProductContainer.getInstance().addProduct(new Product(barcode,Pname, entryDate, price, quantity,location));
		return false;
	}
	
	public boolean updateProduct(int oldBarcode,int barcode, String Pname,String entryDate,double price,int quantity,String location) {
	
		int proindex = productContainer.getProductIndex(oldBarcode);
		
		int newBarcode = barcode == 0 ? productContainer.getAllProducts().get(proindex).getBarcode() : barcode;
		String newPname = Pname == "" ? productContainer.getAllProducts().get(proindex).getPname() : Pname;
		String newEntryDate = entryDate == "" ? productContainer.getAllProducts().get(proindex).getEntryDate() : entryDate;
		double newPrice = price == 0 ? productContainer.getAllProducts().get(proindex).getPrice() : price;  
		int newQuantity = quantity == 0 ? productContainer.getAllProducts().get(proindex).getQuantity() : quantity;
		String newLocation = location == "" ? productContainer.getAllProducts().get(proindex).getLocation() : location;                      
		
		
		
	
		if(productContainer.findByBarcode(newBarcode)!= null && oldBarcode!= newBarcode) { 
			return false;
		}
		
		
		return ProductContainer.getInstance().updateProduct(proindex,newBarcode, newPname,newEntryDate, newPrice, newQuantity,newLocation);
	}
	
	public boolean deleteProduct(int barcode) {
		return ProductContainer.getInstance().removeProduct(barcode);
	}
	
	
	
	
}
   

