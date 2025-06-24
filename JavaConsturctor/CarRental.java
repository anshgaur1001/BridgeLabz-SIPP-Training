package Java_Consturctor;
public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total cost
    public double calculateTotalCost(double costPerDay) {
        return rentalDays * costPerDay;
    }

    public void display() {
        System.out.println("Customer: " + customerName + ", Car Model: " + carModel + ", Rental Days: " + rentalDays);
    }
    
    public static void main(String[] args) {
    	// CarRental
        CarRental rental = new CarRental("Alice", "Toyota Corolla", 5);
        rental.display();
        System.out.println("Total Cost: $" + rental.calculateTotalCost(40.0));
    }
}
