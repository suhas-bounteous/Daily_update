import java.util.*;

public class Main {

    static List<Example> list = new ArrayList<>();
    static Map<String, List<String>> map = new TreeMap<>();

    public static void main(String[] args) {

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        producer.start();
        consumer.start();
    }
}
