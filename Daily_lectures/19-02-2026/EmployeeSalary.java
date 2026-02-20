import java.util.*;
import java.util.stream.*;

class Employee_sal {
    private String name;
    private String department;
    private String mailId;
    private double salary;

    public Employee_sal(String name, String department, String mailId, double salary) {
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

        List<Employee_sal> employeeSals = Arrays.asList(
                new Employee_sal("John", "IT", "john@company.com", 55000),
                new Employee_sal("Alice", "HR", "alice@company.com", 75000),
                new Employee_sal("Bob", "IT", "bob@company.com", 45000),
                new Employee_sal("David", "Sales", "david@company.com", 60000),
                new Employee_sal("Eve", "HR", "eve@company.com", 85000),
                new Employee_sal("John Updated", "IT", "john@company.com", 65000),
                new Employee_sal("Alice Updated", "HR", "alice@company.com", 80000)
        );

        //converting to list, if duplicate mailids, keep emps with higher salary
        Map<String, Employee_sal> employeeMap = employeeSals.stream()
                .collect(Collectors.toMap(
                        Employee_sal::getMailId,
                        emp -> emp,
                        (oldEmp, newEmp) ->
                                oldEmp.getSalary() > newEmp.getSalary()
                                        ? oldEmp
                                        : newEmp
                ));


        List<Employee_sal> uniqueEmployeeSals = new ArrayList<>(employeeMap.values());

        System.out.println("--- Employees After Handling Duplicate Mail IDs ---");
        uniqueEmployeeSals.forEach(System.out::println);

        System.out.println("\n--- Employees Sorted by Salary ---");
        uniqueEmployeeSals.stream()
                .sorted(Comparator.comparing(Employee_sal::getSalary))
                .forEach(System.out::println);

        System.out.println("\n--- Average Salary by Department ---");
        Map<String, Double> avgSalaryByDept = uniqueEmployeeSals.stream()
                .collect(Collectors.groupingBy(
                        Employee_sal::getDepartment,
                        Collectors.averagingDouble(Employee_sal::getSalary)));

        avgSalaryByDept.forEach((dept, avg) ->
                System.out.printf("Department: %-7s | Average: $%.2f%n", dept, avg));
    }
}
