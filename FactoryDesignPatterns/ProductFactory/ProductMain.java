import java.util.Scanner;

public class ProductMain{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Product Name: ");
		String str = scan.nextLine();

		System.out.println("Enter Product Price: ");
		int price = scan.nextInt();

		Product product = new ProductFactory().createProduct(str, price);

		if (product != null) {
			product.ShowProductDetials();
			System.out.println("Enter Quantity : ");
			int quantity = scan.nextInt();

			Order order = new Order(product, quantity);
			order.checkout();
		}
		else{
			System.err.println("Enter Valid Product Name");
		}
	}
}

class Order{
	int quantity;
	Product product;
	public Order(Product pro, int quantity){
		this.product = pro;
		this.quantity = quantity;
	}

	public void checkout(){
		System.out.println("Product : Name -> " + product.Name + " Price -> " + product.Price + " Total -> " + quantity * product.Price);
	}
}

abstract class Product{
	String Name;
	int Price;
	abstract void ShowProductDetials();
}


class ISA_Product extends Product{
	String Type_;
	public ISA_Product(String Name, int price, String type_){
		this.Name = Name;
		this.Price = price;
		Type_ = type_;
	}

	@Override
	void ShowProductDetials(){
		System.out.println("ISA Product: Price -> " + this.Price + " Name -> " + this.Name + " Type -> " + Type_);
	}
}


class SecondProduct extends Product{
	Boolean MYGrousa;

	public SecondProduct(String Name, int price, Boolean MYGrousa){
		this.Name = Name;
		this.Price = price;
		this.MYGrousa = MYGrousa;
	}

	@Override
	void ShowProductDetials(){
		System.out.println("Second Product: Price -> " + this.Price + " Name -> " + this.Name + " MYGrousa -> " + MYGrousa);
	}
}

interface IProductFactory{
	Product createProduct(String str, int price);
}

class ProductFactory implements IProductFactory{
	@Override
	public Product createProduct(String productName, int price){
		Product pro = null;
		Scanner scan = new Scanner(System.in);

		if (productName.equals("isa")) {
			System.out.println("Please Enter Type Of ISA Product : ");
			String type = scan.nextLine();
			pro = new ISA_Product(productName, price, type);
		}

		else if (productName.equals("second")) {
			System.out.println("Please Enter Grousa Of Second Product if yes enter y, else enter n: ");
			String MYGrousa = scan.nextLine();
			
			Boolean m;

			if (MYGrousa.equals("y")) {
				m = true;
			}else{
				m = false;
			}
			pro = new SecondProduct(productName, price, m);
		}

		return pro;
	}
}
