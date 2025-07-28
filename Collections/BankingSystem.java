import java.util.HashMap;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class BankingSystem {
    // Stores Account Number → Balance
    private Map<String, Double> accounts = new HashMap<>();

    // Withdrawal request queue (Account Number, Amount)
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add new account
    public void addAccount(String accNumber, double balance) {
        accounts.put(accNumber, balance);
    }

    // Process withdrawal request
    public void requestWithdrawal(String accNumber, double amount) {
        withdrawalQueue.offer(new WithdrawalRequest(accNumber, amount));
    }

    // Execute queued withdrawals
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            if (accounts.containsKey(request.accNumber)) {
                double balance = accounts.get(request.accNumber);
                if (balance >= request.amount) {
                    accounts.put(request.accNumber, balance - request.amount);
                    System.out.println("Withdrawal of " + request.amount + " from " + request.accNumber + " successful.");
                } else {
                    System.out.println("Insufficient balance for " + request.accNumber);
                }
            } else {
                System.out.println("Account " + request.accNumber + " not found.");
            }
        }
    }

    // Sort accounts by balance
    public void printSortedByBalance() {
        // Invert Map: Balance → List of Account Numbers (to handle duplicate balances)
        TreeMap<Double, List<String>> sorted = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sorted.putIfAbsent(entry.getValue(), new ArrayList<>());
            sorted.get(entry.getValue()).add(entry.getKey());
        }

        System.out.println("Accounts sorted by balance : ");
        for (Map.Entry<Double, List<String>> entry : sorted.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println("Account : " + acc + " → Balance : " + entry.getKey());
            }
        }
    }

    // Show all accounts
    public void printAllAccounts() {
        System.out.println("All Accounts : ");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println("Account : " + entry.getKey() + " → Balance : " + entry.getValue());
        }
    }

    // Helper class for withdrawal requests
    static class WithdrawalRequest {
        String accNumber;
        double amount;

        public WithdrawalRequest(String accNumber, double amount) {
            this.accNumber = accNumber;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        BankingSystem bank = new BankingSystem();

        bank.addAccount("A101", 5000);
        bank.addAccount("B202", 3000);
        bank.addAccount("C303", 7000);
        bank.addAccount("D404", 3000);

        bank.printAllAccounts();

        // Request withdrawals
        bank.requestWithdrawal("A101", 1000);
        bank.requestWithdrawal("B202", 3500);  
        bank.requestWithdrawal("C303", 2000);

        // Process all withdrawal requests
        System.out.println("\nProcessing Withdrawals : ");
        bank.processWithdrawals();

        // Show updated balances
        System.out.println("\nUpdated Accounts : ");
        bank.printAllAccounts();

        // Show sorted accounts by balance
        System.out.println("\nSorted by Balance : ");
        bank.printSortedByBalance();
    }
}
