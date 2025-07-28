import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in Set1 : ");
        int n1 = sc.nextInt();
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements for Set1 : ");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        System.out.print("Enter number of elements in Set2 : ");
        int n2 = sc.nextInt();
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements for Set2 : ");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        // Symmetric Difference = (set1 ∪ set2) - (set1 ∩ set2)
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2); 

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); 

        union.removeAll(intersection);

        System.out.println("Symmetric Difference: " + union);
    }
}
