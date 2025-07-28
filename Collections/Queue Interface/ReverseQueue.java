import java.util.Queue;
import java.util.LinkedList;

public class ReverseQueue {

    // Method to reverse a queue
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        
        // Remove front element
        int front = queue.remove();

        reverseQueue(queue);
        
        queue.add(front);
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue : " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue : " + queue);
    }
}
