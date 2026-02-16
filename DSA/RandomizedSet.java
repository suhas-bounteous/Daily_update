//I have used list and a map, because when I use a set, it does not generate random number, because set does not have index, so I have used list to store the values and map to store the index of the values in the list, so that when I remove a value, I can replace it with the last value in the list and update the index in the map, so that I can remove the last value from the list and remove the value from the map, so that I can achieve O(1) time complexity for insert, remove and getRandom operations.
import java.util.*;

class RandomizedSet {
    private final ArrayList<Integer> list;
    private final Map<Integer, Integer> map;
    private final Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.get(val);
        int lastElement = list.getLast();

        // 1. Move the last element to the index of the element to delete
        list.set(index, lastElement);
        // 2. Update the map with the last element's new index
        map.put(lastElement, index);

        // 3. Delete the last element (which is now a duplicate)
        list.removeLast();
        // 4. Remove the original value from the map
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    // Main method for testing
    static void main() {
        RandomizedSet rs = new RandomizedSet();
        System.out.println("Insert 1: " + rs.insert(1));    // true
        System.out.println("Remove 2: " + rs.remove(2));    // false
        System.out.println("Insert 2: " + rs.insert(2));    // true
        System.out.println("Random: " + rs.getRandom());    // 1 or 2
        System.out.println("Remove 1: " + rs.remove(1));    // true
        System.out.println("Insert 2: " + rs.insert(2));    // false (already exists)
        System.out.println("Random: " + rs.getRandom());    // 2
    }
}