package Classes_and_Objects;
import java.util.*;
	class MobilePhone{
		int price;
		String brand,model;
		public MobilePhone() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the MobilePhone brand");
			this.brand=sc.next();
			System.out.println("Enter the MobilePhone model");
			this.model=sc.next();
			System.out.println("Enter the MobilePhone Price");
			this.price=sc.nextInt();
		}
		public void display() {
			System.out.println("MobilePhone brand is : "+brand);
			System.out.println("MobilePhone model is : "+model);
			System.out.println("MobilePhone price is : "+price);
		}
	}
	public class Problem5 {
		public static void main(String[] args) {
			System.out.println("Enter the details of 3 mobiles");
			for(int i=0;i<3;i++) {
				MobilePhone Mp=new MobilePhone();
				Mp.display();
			}
		}
	}
