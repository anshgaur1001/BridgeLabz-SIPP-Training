import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class NthElementFromEnd {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        sc.nextLine();

        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter the elements : ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Input: Nth position from end
        System.out.print("Enter N (position from end) : ");
        int k = sc.nextInt();

        // Two-pointer approach
        ListIterator<String> first = list.listIterator();
        ListIterator<String> second = list.listIterator();

        int count = 0;
        while (count < k && first.hasNext()) {
            first.next();
            count++;
        }

        if (count < k) {
            System.out.println("N is larger than the list size.");
        } else {
            while (first.hasNext()) {
                first.next();
                second.next();
            }
            System.out.println("The " + k + "th element from the end is : " + second.next());
        }
    }
}
