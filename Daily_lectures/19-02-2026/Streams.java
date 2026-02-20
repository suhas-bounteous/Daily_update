import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Streams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        long c;
        c = IntStream.range(1, 1000000)
                .parallel()
                .filter(MyClass::isPrime)
                .count();
        System.out.println(c);

        List<String> list_11 = Arrays.asList("A", null, "B", null, "C");

        List<String> result = list_11.stream()
                .filter(Objects::nonNull) 
                .collect(Collectors.toList());

        System.out.println(result);

        List<Integer> num = Arrays.asList(1, 39, 34, 6, 7, 12, 11, 16, 10, 8, 8, 10, 39, 84);
        long count_num = num.stream().filter(n -> n%3 == 0).count();
        System.out.println(count_num);

        List<Integer> sorted = num.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);

        List<Integer> dis  = num.stream().distinct().toList();
        System.out.println(dis);

    }
}
