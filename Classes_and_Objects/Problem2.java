package Classes_and_Objects;
import java.util.*;
class Circle{
	float radius;
	public Circle(float radius) {
		this.radius=radius;
	}
	public void details() {
		System.out.println("Area of the circle : "+(3.14*radius*radius));
		System.out.println("Circumference of the circle : "+(2*3.14*radius));
	}
}
public class Problem2 {
	public static void main(String[] args) {
		Circle circle=new Circle(10);
		circle.details();
	}
}
