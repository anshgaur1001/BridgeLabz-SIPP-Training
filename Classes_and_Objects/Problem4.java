package Classes_and_Objects;
import java.util.*;
class Item{
	int itemCode,price;
	String itemName;
	public Item(int itemCode,String itemName, int price) {
		this.itemCode=itemCode;
		this.itemName=itemName;
		this.price=price;
	}
	public void display() {
		System.out.println("ItemCode is "+itemCode+", itemName is "+itemName+". The price is : "+price);
	}
}
public class Problem4 {
	public static void main(String[] args) {
		Item item1=new Item(123,"Tea",200);
		Item item2=new Item(456,"Coffee",300);
		Item item3=new Item(789,"Soap",10);
		item1.display();
		item2.display();
		item3.display();
	}
}
