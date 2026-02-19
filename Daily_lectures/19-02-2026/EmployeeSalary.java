import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private String department;
    private String mailId;
    private double salary;

    public Employee(String name, String department, String mailId, double salary) {
        this.name = name;
        this.department = department;
        this.mailId = mailId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getMailId() {
        return mailId;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%-7s | %-7s | %-20s | $%8.2f",
                name, department, mailId, salary);
    }
}

public class EmployeeSalary {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", "john@company.com", 55000),
                new Employee("Alice", "HR", "alice@company.com", 75000),
                new Employee("Bob", "IT", "bob@company.com", 45000),
                new Employee("David", "Sales", "david@company.com", 60000),
                new Employee("Eve", "HR", "eve@company.com", 85000),
                new Employee("John Updated", "IT", "john@company.com", 65000),
                new Employee("Alice Updated", "HR", "alice@company.com", 80000)
        );

        //converting to list, if duplicate mailids, keep emps with higher salary
        Map<String, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getMailId,      
                        emp -> emp,               
                        (oldEmp, newEmp) ->       
                                oldEmp.getSalary() > newEmp.getSalary()
                                        ? oldEmp
                                        : newEmp
                ));

        
        List<Employee> uniqueEmployees = new ArrayList<>(employeeMap.values());

        System.out.println("--- Employees After Handling Duplicate Mail IDs ---");
        uniqueEmployees.forEach(System.out::println);

        System.out.println("\n--- Employees Sorted by Salary ---");
        uniqueEmployees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        System.out.println("\n--- Average Salary by Department ---");
        Map<String, Double> avgSalaryByDept = uniqueEmployees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        avgSalaryByDept.forEach((dept, avg) ->
                System.out.printf("Department: %-7s | Average: $%.2f%n", dept, avg));
    }
}
