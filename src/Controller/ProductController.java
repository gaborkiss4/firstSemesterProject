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
	
	public String[][] getTable(){
		ArrayList<Product> products = ProductContainer.getInstance().getAllProducts();
		int n = products.size();
		String[][] table = new String[n][4];
		for(int i=0; i<n; i++) {
			table[i][0] = products.get(i).getPname();
			table[i][1] = Double.toString(products.get(i).getPrice());
			table[i][2] = Integer.toString(products.get(i).getStored());
			table[i][3] = Integer.toString(products.get(i).getBarcode());
		}
		return table;
	}
	
	public String[][] getTable2(){
		ArrayList<Product> products = ProductContainer.getInstance().getAllProducts();
		int n = products.size();
		String[][] table = new String[n][5];
		for(int i=0; i<n; i++) {
			table[i][0] = Integer.toString(products.get(i).getBarcode());
			table[i][1] = products.get(i).getPname();
			table[i][2] = Double.toString(products.get(i).getPrice());
			table[i][3] = Integer.toString(products.get(i).getQuantity());
			table[i][4] = products.get(i).getLocation();
		}
		return table;
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
   

