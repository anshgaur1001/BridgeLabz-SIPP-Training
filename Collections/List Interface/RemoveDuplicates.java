import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();

        List<Integer> inputList = new ArrayList<>();
        System.out.println("Enter the elements : ");
        for (int i = 0; i < n; i++) {
            inputList.add(sc.nextInt());
        }

        // Removing duplicates while preserving order
        List<Integer> resultList = new ArrayList<>();
        for (Integer element : inputList) {
            if (!resultList.contains(element)) {
                resultList.add(element);
            }
        }
        System.out.println("List after removing duplicates : " + resultList);
    }
}
