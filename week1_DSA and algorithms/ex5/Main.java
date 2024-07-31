public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        Task task1 = new Task(1, "Design Database", "Pending");
        Task task2 = new Task(2, "Develop API", "In Progress");
        Task task3 = new Task(3, "Create UI", "Pending");
        Task task4 = new Task(4, "Test Application", "Pending");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        taskList.addTask(task4);

        System.out.println("Traverse Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearch Task with ID 2:");
        System.out.println(taskList.searchTask(2));

        System.out.println("\nDelete Task with ID 3:");
        taskList.deleteTask(3);

        System.out.println("\nTraverse Tasks after Deletion:");
        taskList.traverseTasks();
    }
}
