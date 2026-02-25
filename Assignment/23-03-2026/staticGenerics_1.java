public class staticGenerics_1 {

    public static class Container<T> {
        private final T value;
        public Container(T value) { this.value = value; }
        public T getValue() { return value; }
    }

    public static <T> void displayInfo(T item) {
        System.out.println("Type: " + item.getClass().getSimpleName() + " | Value: " + item);
    }

    static void main(String[] args) {
        displayInfo("Hello Java");
        displayInfo(42);

        Container<Double> piContainer = new Container<>(3.14159);
        System.out.println("Stored Value: " + piContainer.getValue());
    }
}
