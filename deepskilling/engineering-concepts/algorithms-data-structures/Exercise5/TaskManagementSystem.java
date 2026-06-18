public class TaskManagementSystem {

    private class Node {
        Task data;
        Node next;

        Node(Task data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Add a task (to the end of the list)
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added task: " + task.getTaskName());
    }

    // Search for a task by ID
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.data.getTaskId().equals(taskId)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and display all tasks
    public void traverseTasks() {
        System.out.println("\n--- Task List ---");
        Node current = head;
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("-----------------");
    }

    // Delete a task by ID
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Error: List is empty. Cannot delete " + taskId);
            return;
        }
        if (head.data.getTaskId().equals(taskId)) {
            System.out.println("Deleted task: " + head.data.getTaskName());
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            System.out.println("Deleted task: " + current.next.data.getTaskName());
            current.next = current.next.next;
        } else {
            System.out.println("Error: Task ID " + taskId + " not found.");
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(new Task("T1", "Design Database", "In Progress"));
        tms.addTask(new Task("T2", "Develop API", "Not Started"));
        tms.addTask(new Task("T3", "Write Tests", "Not Started"));

        tms.traverseTasks();

        System.out.println("\nSearching for T2: " + tms.searchTask("T2"));

        System.out.println("\nDeleting T2...");
        tms.deleteTask("T2");

        tms.traverseTasks();
    }
}
