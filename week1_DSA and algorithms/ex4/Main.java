package emp_management_system;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement empManagement = new EmployeeManagement(5);

        Employee emp1 = new Employee(1, "theo", "Manager", 75000);
        Employee emp2 = new Employee(2, "savio", "Developer", 55000);
        Employee emp3 = new Employee(3, "bob", "Designer", 60000);
        Employee emp4 = new Employee(4, "hamil", "Tester", 50000);
        Employee emp5 = new Employee(5, "seeni", "HR", 45000);

        empManagement.addEmployee(emp1);
        empManagement.addEmployee(emp2);
        empManagement.addEmployee(emp3);
        empManagement.addEmployee(emp4);
        empManagement.addEmployee(emp5);

        System.out.println("Traverse Employees:");
        empManagement.traverseEmployees();

        System.out.println("\nSearch Employee with ID 3:");
        System.out.println(empManagement.searchEmployee(3));

        System.out.println("\nDelete Employee with ID 2:");
        empManagement.deleteEmployee(2);

        System.out.println("\nTraverse Employees after Deletion:");
        empManagement.traverseEmployees();
    }
}
