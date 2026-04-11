import java.util.PriorityQueue;

public class KthLargestStream {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargestStream(int k, int[] nums) {
        this.k = k;
        // Min-heap is the default in Java's PriorityQueue
        this.minHeap = new PriorityQueue<>(k);
        
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        
        // If heap exceeds size k, the smallest is no longer in the "Top K"
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        
        // The root of the min-heap is the kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] initialNums = {4, 5, 8, 2};
        
        KthLargestStream stream = new KthLargestStream(k, initialNums);
        
        System.out.println("Initial k-th largest: " + stream.minHeap.peek()); // Should be 4
        System.out.println("Add 3: " + stream.add(3));   // Returns 4
        System.out.println("Add 5: " + stream.add(5));   // Returns 5
        System.out.println("Add 10: " + stream.add(10)); // Returns 5
        System.out.println("Add 9: " + stream.add(9));   // Returns 8
        System.out.println("Add 4: " + stream.add(4));   // Returns 8
    }
}