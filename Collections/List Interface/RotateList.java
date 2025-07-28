import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateList {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Input: number of positions to rotate
        System.out.print("Enter number of positions to rotate : ");
        int k = sc.nextInt();

        // Normalize rotation (in case k > n)
        k = k % n;

        // Rotate manually
        List<Integer> rotatedList = new ArrayList<>();

        for (int i = k; i < n; i++) {
            rotatedList.add(list.get(i));
        }
        for (int i = 0; i < k; i++) {
            rotatedList.add(list.get(i));
        }
        System.out.println("Rotated List : " + rotatedList);
    }
}
