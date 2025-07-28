import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CompareSets {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        // Input for Set 1
        System.out.print("Enter number of elements in Set1 : ");
        int n1 = sc.nextInt();
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements for Set1 : ");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        // Input for Set 2
        System.out.print("Enter number of elements in Set2 : ");
        int n2 = sc.nextInt();
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements for Set2 : ");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        // Compare sets using equals()
        boolean areEqual = set1.equals(set2);

        // Output
        System.out.println("Are the two sets equal? " + areEqual);

        sc.close();
    }
}
