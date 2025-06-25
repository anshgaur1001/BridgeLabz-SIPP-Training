package Static_and_Final_Keyword;

public class BankAccount {
	 // Static variable shared by all
	static String BankName="Apna Bank";
	static int totalAccounts=0;
	
	//Instance variable
	private String accountHolderName;
	
	//final variable for make it fixed
	final int accountNumber;
	
	public BankAccount(String accountHolderName,int accountNumber) {
		//use of this keyword to resolve ambiguity in the constructor
		this.accountHolderName=accountHolderName;
		this.accountNumber=accountNumber;
		//increment of the totalAccounts
		totalAccounts++;
	}
	
	public static void getTotalAccounts() {
		System.out.println("Total number of Accounts : "+totalAccounts);
	}
	
	//Method to display account details
	public void displayDetails(){
		if (this instanceof BankAccount) {
			System.out.println("Bank Name : "+BankName);
			System.out.println("Account Holder name : "+accountHolderName);
			System.out.println("Account Number : "+accountNumber);
		}
		else {
			System.out.println("Invalid account instance.");
		}
	}
	//main method for testing
	public static void main(String[] args) {
		BankAccount acc1=new BankAccount("Aman",123456);
		BankAccount acc2=new BankAccount("Ansh",456789);
		
		acc1.displayDetails();
		acc2.displayDetails();
		
		BankAccount.getTotalAccounts();
		
	}
}