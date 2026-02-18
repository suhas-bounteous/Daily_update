import java.util.LinkedList;

public class HashSet_impl {

    private LinkedList<Object>[] table;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    public HashSet_impl() {
        table = new LinkedList[DEFAULT_CAPACITY];
    }

    private int getIndex(Object key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public boolean add(Object element) {

        if ((double) size / table.length >= LOAD_FACTOR) {
            resize();
        }

        int index = getIndex(element);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        if (table[index].contains(element)) {
            return false;
        }

        table[index].add(element);
        size++;
        return true;
    }

    private void resize() {
        int newCapacity = table.length * 2;
        LinkedList<Object>[] oldTable = table;

        table = new LinkedList[newCapacity];
        size = 0;

        for (LinkedList<Object> bucket : oldTable) {
            if (bucket != null) {
                for (Object element : bucket) {
                    this.add(element);
                }
            }
        }
    }

    public boolean contains(Object element) {
        int index = getIndex(element);

        if (table[index] == null)
            return false;

        return table[index].contains(element);
    }

    public boolean remove(Object element) {
        int index = getIndex(element);

        if (table[index] == null)
            return false;

        boolean removed = table[index].remove(element);
        if (removed)
            size--;

        return removed;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        HashSet_impl list = new HashSet_impl();

        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        boolean c1 = list.contains("Apple");
        System.out.println("Is apple present in list? " + c1);
        list.remove(0);
        System.out.println(list.size());
    }
}
