import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return q1.remove();
    }

    // Top operation
    public int top() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return q1.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top : " + stack.top());
        System.out.println("Popped : " + stack.pop());
        System.out.println("Top after pop : " + stack.top());
    }
}
