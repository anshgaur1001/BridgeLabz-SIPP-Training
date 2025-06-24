package Java_Consturctor;

public class BankAccount {
	//instance variable with public, protected and private access modifiers
	public int accountNumber;
	protected String accountHolder;
	private double balance;
	
	//constructor
	public BankAccount(int accountNumber, String accountHolder, double balance) {
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	//method to access balance
	public double getbalance() {
		return balance;
	}
	
	//method to update balance
	public void setbalance(int balance) {
		this.balance=balance;
	}
	
	public static void main(String[] args) {
		// Creating an Account instance
	     SavingsAccount account = new SavingsAccount(552266,"Ansh",5000);
	     // Displaying the details
	     account.displayAccountDetails();

	     // Updating the balance
	     account.setbalance(10000);
	     System.out.println("After updating the balance:");
	     account.displayAccountDetails();
	}
}
//subclass
class SavingsAccount extends BankAccount{
	public SavingsAccount(int accountNumber, String accountHolder, double balance) {
		super(accountNumber,accountHolder,balance);
	}
	public void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        // Accessing private author via public getter
        System.out.println("balance : " + getbalance());
    }
}
