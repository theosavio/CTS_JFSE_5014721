public class TaskLinkedList {
    private Node head;

    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Method to add a task at the end of the list
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
    }

    // Method to search for a task by ID
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // Method to traverse and display all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Method to delete a task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        // If the task to be deleted is the head
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        // Traverse the list to find the task to delete
        Node current = head;
        Node previous = null;
        while (current != null && current.task.getTaskId() != taskId) {
            previous = current;
            current = current.next;
        }

        // If the task was not found
        if (current == null) {
            System.out.println("Task not found.");
            return;
        }

        // Delete the task
        previous.next = current.next;
    }
}
