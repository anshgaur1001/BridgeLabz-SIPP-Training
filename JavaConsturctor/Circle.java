package Java_Consturctor;
public class Circle {
    double radius;

    // Default constructor
    public Circle() {
        this(1.0); // Chain to parameterized constructor
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    public void display() {
        System.out.println("Circle Radius: " + radius);
    }
    
    public static void main(String[] args) {
    	  // Circle
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.5);
        circle1.display();
        circle2.display();
    }
}
