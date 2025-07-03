package Day2;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
} 

public class Task_Scheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    // Add task at the end
    public void addTaskEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add task at the beginning
    public void addTaskBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add task at specific position (1-based index)
    public void addTaskAtPosition(int pos, int taskId, String taskName, int priority, String dueDate) {
        if (pos <= 1) {
            addTaskBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    // Remove task by Task ID
    public void removeTask(int taskId) {
        if (head == null) return;

        Task temp = head;
        Task prev = tail;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                    if (temp == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Task " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task ID not found.");
    }

    // View current task and move to next
    public void viewCurrentAndMoveNext() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            System.out.println("Current Task:");
            displayTask(current);
            current = current.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task temp = head;
        System.out.println("All Tasks:");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search task by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task with priority " + priority + " found.");
        }
    }

    // Helper to display task
    private void displayTask(Task t) {
        System.out.println("ID: " + t.taskId + ", Name: " + t.taskName + ", Priority: " + t.priority + ", Due: " + t.dueDate);
    }
    
    //main class for testing
    public static void main(String[] args) {
    	
    }
}
