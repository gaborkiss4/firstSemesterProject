package Model;
import java.util.Scanner;
public class Test {

	public static void main(String[]args ) {
	
	Product product;
	double pr;
	int q,b;
	String p,e;
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("quntity");
	q= scanner.nextInt();
	System.out.println("barcode");
	b=scanner.nextInt();
	System.out.println("pname");
	p=scanner.nextLine();
	System.out.println("entryDate");
	e=scanner.nextLine();
	System.out.println("price");
	pr=scanner.nextDouble();
	
	product = new Product( b, p, e, pr,q);
	product.setQuantity(q);
	
	System.out.println(product.getStored());
	System.out.println(product.getQuantity());
	System.out.println("q");
	q=scanner.nextInt();
	product.setQuantity(q);
	System.out.println(product.getStored());
	
	
	
	
	}
}
