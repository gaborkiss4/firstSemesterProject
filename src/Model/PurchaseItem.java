package Model;

public class PurchaseItem {
	private Product product;
	private int amount;
	public PurchaseItem(Product product, int amount) {
		this.product = product;
		this.amount = amount;
	}
	
	public Product getProduct() {
		return product;
	}
	public int getAmount() {
		return amount;
	}
}
