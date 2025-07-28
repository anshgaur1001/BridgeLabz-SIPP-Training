import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ReverseAList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of elements : ");
		int n = sc.nextInt();
		
		//ArrayList
		List<Integer> arrayList = new ArrayList<>();
		System.out.println("Enter elements for ArrayList : ");
		for(int i = 0; i < n; i++) {
			arrayList.add(sc.nextInt());
		}
		
		//LinkedList
		LinkedList<Integer> linkedList = new LinkedList<>();
		System.out.println("Enter elements for LinkedList : ");
		for(int i = 0; i < n; i++) {
			linkedList.add(sc.nextInt());
		}
		
		//Reverse ArrayList
		List<Integer> reversedArrayList = new ArrayList<>();
		for(int i = arrayList.size() - 1; i >= 0; i--) {
			reversedArrayList.add(arrayList.get(i));
		}
		
		//Reverse LinkedList using ListIterator from the end
		List<Integer> reversedLinkedList = new LinkedList<>();
		ListIterator<Integer> iterator = linkedList.listIterator(linkedList.size());
		while(iterator.hasPrevious()) {
			reversedLinkedList.add(iterator.previous());
		}
		
		System.out.println("Reversed ArrayList : " + reversedArrayList);
		System.out.println("Reversed LinkedList : " + reversedLinkedList);
	}
}
