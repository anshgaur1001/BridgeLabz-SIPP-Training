import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class SetToSortedList {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in the Set : ");
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        System.out.println("Enter elements : ");
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        // Convert Set to List
        List<Integer> sortedList = new ArrayList<>(set);

        // Sort the list in ascending order
        Collections.sort(sortedList);

        // Output the sorted list
        System.out.println("Sorted List : " + sortedList);
    }
}
