import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionAndIntersection {
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

        // Union: Add all elements of set2 into a copy of set1
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // Intersection: Retain only common elements in a copy of set1
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Output
        System.out.println("Union : " + union);
        System.out.println("Intersection : " + intersection);
    }
}
