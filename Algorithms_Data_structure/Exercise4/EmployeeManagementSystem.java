import java.util.Arrays;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add employee
    void addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Employee array is full. Cannot add more employees.");
            return;
        }
        employees[size++] = employee;
    }

    // Search for an employee by ID
    Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and display all employees
    void displayAllEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    void deleteEmployee(int employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Employee not found.");
            return;
        }

        // Shift elements to the left to remove the employee
        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null;
        size--;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(5);

        // Adding employees
        system.addEmployee(new Employee(1, "Alice", "Developer", 60000));
        system.addEmployee(new Employee(2, "Bob", "Manager", 80000));
        system.addEmployee(new Employee(3, "Charlie", "Analyst", 55000));

        // Displaying all employees
        System.out.println("All Employees:");
        system.displayAllEmployees();

        // Searching for an employee
        Employee employee = system.searchEmployee(2);
        System.out.println("\nSearching for Employee ID 2:");
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        // Deleting an employee
        system.deleteEmployee(1);
        System.out.println("\nEmployees after deletion of ID 1:");
        system.displayAllEmployees();
    }
}
