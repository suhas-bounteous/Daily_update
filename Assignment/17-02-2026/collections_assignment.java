import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class OrderEvent {
    String orderId;
    String userId;
    String productId;
    String category;
    String region;
    long timestamp;

    public OrderEvent(String orderId, String userId,
            String productId, String category,
            String region, long timestamp) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.category = category;
        this.region = region;
        this.timestamp = timestamp;
    }
}

class FlashSaleTrendingEngine {

    private static final long WINDOW_SIZE = 10 * 60 * 1000;

    private final ConcurrentLinkedDeque<OrderEvent> eventQueue = new ConcurrentLinkedDeque<>();
    private final ConcurrentHashMap<String, AtomicInteger> productCount = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, AtomicInteger>> regionCategoryCount = new ConcurrentHashMap<>();

    public void processEvent(OrderEvent event) {
        long now = System.currentTimeMillis();

        eventQueue.addLast(event);

        productCount
                .computeIfAbsent(event.productId, k -> new AtomicInteger(0))
                .incrementAndGet();

        regionCategoryCount
                .computeIfAbsent(event.region, r -> new ConcurrentHashMap<>())
                .computeIfAbsent(event.category, c -> new AtomicInteger(0))
                .incrementAndGet();

        evictExpired(now);
    }

    private void evictExpired(long currentTime) {
        while (!eventQueue.isEmpty()) {
            OrderEvent oldest = eventQueue.peekFirst();

            if (currentTime - oldest.timestamp > WINDOW_SIZE) {
                eventQueue.pollFirst();

                AtomicInteger prodCounter = productCount.get(oldest.productId);
                if (prodCounter != null && prodCounter.decrementAndGet() == 0) {
                    productCount.remove(oldest.productId);
                }

                ConcurrentHashMap<String, AtomicInteger> categoryMap = regionCategoryCount.get(oldest.region);

                if (categoryMap != null) {
                    AtomicInteger catCounter = categoryMap.get(oldest.category);
                    if (catCounter != null && catCounter.decrementAndGet() == 0) {
                        categoryMap.remove(oldest.category);
                    }
                }
            } else {
                break;
            }
        }
    }

    public List<String> getTop5Products() {
        return getTopK(productCount, 5);
    }

    public Map<String, List<String>> getTop3CategoriesPerRegion() {
        Map<String, List<String>> result = new HashMap<>();

        for (Map.Entry<String, ConcurrentHashMap<String, AtomicInteger>> entry : regionCategoryCount.entrySet()) {

            result.put(entry.getKey(),
                    getTopK(entry.getValue(), 3));
        }

        return result;
    }

    private List<String> getTopK(Map<String, AtomicInteger> map, int k) {
        PriorityQueue<Map.Entry<String, AtomicInteger>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.getValue().get()));

        for (Map.Entry<String, AtomicInteger> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        Collections.reverse(result);
        return result;
    }
}

public class collections_assignment {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FlashSaleTrendingEngine engine = new FlashSaleTrendingEngine();

        System.out.println("Flash Sale Trending Engine Started");
        System.out.println("Commands:");
        System.out.println("ORDER orderId userId productId category region");
        System.out.println("TOP_PRODUCTS");
        System.out.println("TOP_CATEGORIES");
        System.out.println("EXIT");

        while (true) {

            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts[0].equalsIgnoreCase("ORDER")) {

                if (parts.length != 6) {
                    System.out.println("Invalid ORDER format");
                    continue;
                }

                OrderEvent event = new OrderEvent(
                        parts[1],
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5],
                        System.currentTimeMillis());

                engine.processEvent(event);
                System.out.println("Order Processed");

            } else if (parts[0].equalsIgnoreCase("TOP_PRODUCTS")) {

                List<String> topProducts = engine.getTop5Products();
                System.out.println("Top 5 Products: " + topProducts);

            } else if (parts[0].equalsIgnoreCase("TOP_CATEGORIES")) {

                Map<String, List<String>> result = engine.getTop3CategoriesPerRegion();
                System.out.println("Top 3 Categories Per Region:");
                for (String region : result.keySet()) {
                    System.out.println(region + " -> " + result.get(region));
                }

            } else if (parts[0].equalsIgnoreCase("EXIT")) {

                System.out.println("Exiting...");
                break;

            } else {

                System.out.println("Unknown command");
            }
        }

        scanner.close();
    }
}
