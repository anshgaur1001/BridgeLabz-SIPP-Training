import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Superclass
abstract class Vehicle {
    protected String vehicleNumber;
    protected LocalDateTime entryTime;

    public Vehicle(String vehicleNumber, LocalDateTime entryTime) {
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
    }

    // Abstract method → overridden in subclasses
    public abstract double calculateFee(LocalDateTime exitTime);

    public void printTicket(LocalDateTime exitTime) {
        System.out.println("---- Parking Ticket ----");
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + this.getClass().getSimpleName());
        System.out.println("Entry Time: " + entryTime.format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println("Exit Time: " + exitTime.format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println("Total Fee: ₹" + calculateFee(exitTime));
        System.out.println("------------------------\n");
    }

    // Helper to compute hours (round up for partial hours)
    protected long calculateHours(LocalDateTime exitTime) {
        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        return (minutes + 59) / 60; // ceiling division
    }
}

//Subclasses
class Car extends Vehicle {
    public Car(String vehicleNumber, LocalDateTime entryTime) {
        super(vehicleNumber, entryTime);
    }

    @Override
    public double calculateFee(LocalDateTime exitTime) {
        long hours = calculateHours(exitTime);
        return 50 + (hours - 1) * 30; // base + extra
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, LocalDateTime entryTime) {
        super(vehicleNumber, entryTime);
    }

    @Override
    public double calculateFee(LocalDateTime exitTime) {
        long hours = calculateHours(exitTime);
        return 20 + (hours - 1) * 10;
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, LocalDateTime entryTime) {
        super(vehicleNumber, entryTime);
    }

    @Override
    public double calculateFee(LocalDateTime exitTime) {
        long hours = calculateHours(exitTime);
        return 100 + (hours - 1) * 50;
    }
}

//Demo
public class ParkingLotDemo {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");

        Vehicle car = new Car("KA05AB1234", LocalDateTime.parse("10:00", fmt));
        Vehicle bike = new Bike("KA05XY7890", LocalDateTime.parse("11:15", fmt));
        Vehicle truck = new Truck("KA09TR5566", LocalDateTime.parse("09:30", fmt));

        // Evening exits
        car.printTicket(LocalDateTime.parse("13:30", fmt));   // 1:30 PM
        bike.printTicket(LocalDateTime.parse("12:00", fmt));  // 12:00 PM
        truck.printTicket(LocalDateTime.parse("14:00", fmt)); // 2:00 PM
    }
}
