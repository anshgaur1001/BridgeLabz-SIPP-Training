package Java_Consturctor;
import java.util.*;
public class Product {
	//Instance variable 
	String productName;
	double price;
	
	//class variable
	static int totalProducts=0;
	
	//constructor
	public Product(String productName, double price) {
		this.productName=productName;
		this.price=price;
		
		//count totalProducts
		totalProducts++;
	}
	//constructor for display product details, Instance method
	public void displayProductDetails() {
		System.out.println("Name of the Product : "+productName);
		System.out.println("Price of the Product : "+price);
	}
	
	//class Method
	public static void  displayTotalProducts() {
		System.out.println("Total number of products are : "+totalProducts);
	}
	public static void main(String[] args) {
		//Creation of the products
		Product p1=new Product("Tea",120);
		Product p2=new Product("Coffee",200);
		
		//Displaying details of each product
		p1.displayProductDetails();
		p2.displayProductDetails();
		
		//displaying total number of products
		Product.displayTotalProducts();
	}
}
