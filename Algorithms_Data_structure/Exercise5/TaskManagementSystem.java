// Define the Task class to represent individual tasks
class Task {
    int taskId;
    String taskName;
    String status;
    Task next; // Reference to the next Task in the linked list

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

// Define the TaskManager class to manage a list of tasks
class TaskManager {
    private Task head; // Head of the linked list

    // Constructor to initialize the TaskManager
    TaskManager() {
        this.head = null;
    }

    // Method to add a new task to the list
    void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    // Method to search for a task by taskId
    Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Method to traverse and display all tasks
    void displayTasks() {
        Task current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Status: " + current.status);
            current = current.next;
        }
    }

    // Method to delete a task by taskId
    void deleteTask(int taskId) {
        if (head == null) return;

        if (head.taskId == taskId) {
            head = head.next;
            return;
        }

        Task current = head;
        while (current.next != null && current.next.taskId != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}

// Main class to test the TaskManager functionality
public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Add some tasks
        manager.addTask(1, "Complete project report", "Pending");
        manager.addTask(2, "Email client", "In Progress");
        manager.addTask(3, "Prepare presentation", "Completed");

        // Display all tasks
        System.out.println("All Tasks:");
        manager.displayTasks();

        // Search for a task
        System.out.println("\nSearching for Task ID 2:");
        Task task = manager.searchTask(2);
        if (task != null) {
            System.out.println("Found Task - ID: " + task.taskId + ", Name: " + task.taskName + ", Status: " + task.status);
        } else {
            System.out.println("Task not found");
        }

        // Delete a task
        manager.deleteTask(2);

        // Display all tasks after deletion
        System.out.println("\nTasks After Deletion:");
        manager.displayTasks();
    }
}
