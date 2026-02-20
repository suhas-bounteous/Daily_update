import java.util.*;
import java.lang.*;
import java.util.stream.*;

class EmployeeSoln{
    static  void main() {
        List<Employee> employees = List.of(
                new Employee(1, "Alice", "IT", 60000, "alice@mail.com", List.of("Java", "Spring")),
                new Employee(2, "Bob", "HR", 50000, "bob@mail.com", List.of("Communication")),
                new Employee(3, "Charlie", "IT", 70000, "charlie@mail.com", List.of("Java", "AWS")),
                new Employee(4, "David", "Finance", 45000, "david@mail.com", List.of("Excel")),
                new Employee(5, "Eve", "HR", 55000, "eve@mail.com", List.of("Recruitment"))
        );

        //1
        List<String> names = List.of("A", "B", "C");
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println(joined);

        //2
        Map<Integer, String> idNameMap = employees.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println("2. " + idNameMap);

        //3
        Map<String, List<Employee>> namedepmap;
        namedepmap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(namedepmap);

        //4
        Map<String, Long> depcnt = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(depcnt);

        //5
        Map<String, Double> salbydep = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(salbydep);

        //6
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Map<Boolean, List<Integer>> evenOdd =
                numbers.stream()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("6. " + evenOdd);

        //7
//        List<String> salgr50 = employees.stream().filter()












    }
}