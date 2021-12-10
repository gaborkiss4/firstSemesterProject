package Model;
import java.util.ArrayList;
import java.util.Iterator;
public class ProductContainer {

	private ArrayList<Product> products;
	private static ProductContainer instance;
	
	private ProductContainer() {
		
		products= new ArrayList<>();
		
	}
	public static ProductContainer getInstance() {
		
		if (instance == null) {
			
			instance = new ProductContainer();
		}
		return instance;
	}
	public boolean addProduct(Product product) {
		
		return products.add(product);
	}
	public boolean updateProduct(int proindex,int barcode,String Pname,String entryDate,double price,int quantity,String location) 
	{
		products.get(proindex).setBarcode(barcode);
		products.get(proindex).setPname(Pname);
		products.get(proindex).setEntryDate(entryDate);
		products.get(proindex).setPrice(price);
		products.get(proindex).setQuantity(quantity);
		products.get(proindex).setLocation(location);
		return true;
	}
	public boolean removeProduct(int barcode) {
		Iterator<Product> productIterator = products.iterator();  //--------------------------------------------------
		
		while(productIterator.hasNext()) {
			if(productIterator.next().getBarcode() == barcode) {
				productIterator.remove();
				return true;
			}
		}
		return false;
	}
	public ArrayList<Product> findByPname(String Pname) {      
		ArrayList<Product> results = new ArrayList<>();
		for (Product product : products) {                 //--------------------------------------------------
			if (product.getPname().toLowerCase().contains(Pname.toLowerCase())) {
				results.add(product);
			}
		}
		return results;
	}
	
	public Product findByBarcode(int barcode) {       //--------------------------------------------------
		for (Product product : products) {
			if (product.getBarcode() == barcode) {
				return product;
			}
		}
		return null;
	}
	
	public int getProductIndex(int barcode) { //--------------------------------------------------
		int productProindex = -1;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getBarcode() == barcode)  //gets an index of a person
				productProindex = i;
		}
		return productProindex;
	}
	
	public ArrayList<Product> getAllProducts(){
		return products;
	}
	
	
	
	
	
	
}
