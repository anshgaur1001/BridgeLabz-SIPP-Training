import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;

public class InsurancePolicyManagementSystem {
	
	// Comparator for sorting TreeSet by expiry date
    private static Comparator<Policy> expiryDateComparator = new Comparator<Policy>() {
        public int compare(Policy p1, Policy p2) {
            return p1.getExpiryDate().compareTo(p2.getExpiryDate());
        }
    };
	
	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        HashSet<Policy> hashSet = new HashSet<>();
        LinkedHashSet<Policy> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Policy> treeSet = new TreeSet<>(expiryDateComparator);
        HashSet<String> duplicateChecker = new HashSet<>();

        System.out.print("Enter number of policies to add : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for policy " + (i + 1));
            System.out.print("Policy Number : ");
            String number = sc.nextLine();

            System.out.print("Policyholder Name : ");
            String name = sc.nextLine();

            System.out.print("Expiry Date (yyyy-MM-dd) : ");
            String dateStr = sc.nextLine();
            Date expiry = sdf.parse(dateStr);

            System.out.print("Coverage Type (Health, Auto, Home) : ");
            String type = sc.nextLine();

            System.out.print("Premium Amount : ");
            double premium = sc.nextDouble();
            sc.nextLine();

            Policy policy = new Policy(number, name, expiry, type, premium);

            // Add to all sets
            hashSet.add(policy);
            linkedHashSet.add(policy);
            treeSet.add(policy);

            // Check for duplicates
            if (!duplicateChecker.add(number)) {
                System.out.println("❗ Duplicate policy detected : " + number);
            }
        }

        // Retrieve: All Unique Policies
        System.out.println("\n--- All Unique Policies (HashSet) ---");
        for (Policy p : hashSet) {
            System.out.println(p);
        }

        // Retrieve: Insertion Order
        System.out.println("\n--- Policies in Insertion Order (LinkedHashSet) ---");
        for (Policy p : linkedHashSet) {
            System.out.println(p);
        }

        // Retrieve: Sorted by Expiry (TreeSet)
        System.out.println("\n--- Policies Sorted by Expiry Date (TreeSet) ---");
        for (Policy p : treeSet) {
            System.out.println(p);
        }

        // Retrieve: Policies expiring within next 30 days
        System.out.println("\n--- Policies Expiring Within 30 Days ---");
        Date today = new Date();
        long thirtyDaysMillis = 30L * 24 * 60 * 60 * 1000;

        for (Policy p : treeSet) {
            if (p.getExpiryDate().getTime() - today.getTime() <= thirtyDaysMillis &&
                p.getExpiryDate().after(today)) {
                System.out.println(p);
            }
        }

        // Retrieve: By Coverage Type
        System.out.print("\nEnter coverage type to search : ");
        String searchType = sc.nextLine();

        System.out.println("\n--- Policies with coverage type : " + searchType + " ---");
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(searchType)) {
                System.out.println(p);
            }
        }

        // Retrieve: Duplicate Policy Numbers
        System.out.println("\n--- Duplicate Policy Numbers ---");
        HashSet<String> seen = new HashSet<>();
        HashSet<String> duplicates = new HashSet<>();

        for (Policy p : hashSet) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicate policy numbers found.");
        } else {
            for (String dup : duplicates) {
                System.out.println("Duplicate : " + dup);
            }
        }
	}
}
