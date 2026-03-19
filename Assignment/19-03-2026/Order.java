import java.util.*;
import java.util.stream.*;

class Order {
    int orderId;
    String customerName;
    List<String> items;
    double amount;
    String category;

    public Order(int orderId, String customerName, List<String> items, double amount, String category) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.amount = amount;
        this.category = category;
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public List<String> getItems() { return items; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
}
