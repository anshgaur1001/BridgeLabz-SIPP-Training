package Java_Consturctor;

public class Vehicle {
	//Instance variable 
	String ownerName, vehicleType;
	
	//class variable
	static double registrationFee=10000;
	
	//constructor
	public Vehicle(String ownerName, String vehicleType) {
		this.ownerName=ownerName;
		this.vehicleType=vehicleType;
	}
	//Instance method
	public void displayVehicleDetails() {
		System.out.println("Name of the owner : "+ownerName);
		System.out.println("Type of the Vehicle : "+vehicleType);
		System.out.println("Registration Fee for the Vehicle : "+registrationFee);
	}
	
	//class Method
	public static void  updateRegistrationFee(double updatedFee) {
		registrationFee=updatedFee;
	}
	public static void main(String[] args) {
		//Creation of the Vehicle
		Vehicle v1=new Vehicle("Aryan","3-Wheeler");
		Vehicle v2=new Vehicle("Aman","2-Wheeler");
		
		//Displaying details of 1st Vehicle
		v1.displayVehicleDetails();
		
		//displaying total number of products
		Vehicle.updateRegistrationFee(7500);
		
		//Displaying details of 2nd Vehicle
		v2.displayVehicleDetails();
	}
}
