public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size] = emp;
            size++;
            System.out.println("Added: " + emp.getName());
        } else {
            System.out.println("Error: Array is full. Cannot add " + emp.getName());
        }
    }

    // Search for an employee by ID
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and display all employees
    public void traverseEmployees() {
        System.out.println("\n--- Employee List ---");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
        System.out.println("---------------------");
    }

    // Delete an employee by ID
    public void deleteEmployee(String employeeId) {
        int indexToDelete = -1;

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete != -1) {
            System.out.println("Deleted Employee ID: " + employeeId);
            for (int i = indexToDelete; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null;
            size--;
        } else {
            System.out.println("Error: Employee ID " + employeeId + " not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        // Add
        ems.addEmployee(new Employee("E01", "Alice", "Manager", 80000));
        ems.addEmployee(new Employee("E02", "Bob", "Developer", 60000));
        ems.addEmployee(new Employee("E03", "Charlie", "Analyst", 55000));

        ems.traverseEmployees();

        System.out.println("\nSearching for E02: " + ems.searchEmployee("E02"));

        System.out.println("\nDeleting E02...");
        ems.deleteEmployee("E02");

        ems.traverseEmployees();
    }
}
