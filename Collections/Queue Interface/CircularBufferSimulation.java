public class CircularBufferSimulation {
    private int[] buffer;
    private int size;
    private int front = 0;
    private int rear = 0;
    private boolean isFull = false;

    CircularBufferSimulation(int size) {
        this.size = size;
        buffer = new int[size];
    }

    // Add element (overwrite if full)
    public void enqueue(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size;

        if (isFull) {
            front = (front + 1) % size;
        }

        if (rear == front) {
            isFull = true;
        }
    }

    // Display buffer contents
    public void display() {
        System.out.print("Buffer : [");
        int count = isFull ? size : (rear - front + size) % size;
        for (int i = 0; i < count; i++) {
            int index = (front + i) % size;
            System.out.print(buffer[index]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        CircularBufferSimulation cb = new CircularBufferSimulation(3);

        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        cb.display();

        cb.enqueue(4); 
        cb.display();
    }
}
