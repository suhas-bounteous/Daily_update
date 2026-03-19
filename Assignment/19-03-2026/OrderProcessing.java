import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderProcessing {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order(1, "Alice", Arrays.asList("Laptop", "Mouse"), 1200, "Electronics"),
                new Order(2, "Bob", Arrays.asList("Book", "Pen"), 50, "Books"),
                new Order(3, "Alice", Arrays.asList("Keyboard"), 100, "Electronics"),
                new Order(4, "Charlie", Arrays.asList("Notebook"), 20, "Stationery")
        );

        // 1. Sum of all order amounts
        double totalAmount = orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();
        System.out.println("Total Amount: " + totalAmount);

        // 2. Unique list of all items
        List<String> uniqueItems = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique Items: " + uniqueItems);

        // 3. Total spent per customer
        Map<String, Double> customerSpending = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        Collectors.summingDouble(Order::getAmount)
                ));
        System.out.println("Customer Spending: " + customerSpending);

        // 4. Category with highest revenue
        String topCategory = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCategory,
                        Collectors.summingDouble(Order::getAmount)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Category");

        System.out.println("Top Category: " + topCategory);
    }
}
