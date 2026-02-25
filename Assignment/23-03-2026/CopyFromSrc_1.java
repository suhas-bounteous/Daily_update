import java.util.*;
class CopyFromSrc_1<T>{
    public static <T> void copy(List<? super T> destination, List<? extends T> source) {
        destination.addAll(source);
    }

    static void main() {
        List<Integer> integers = List.of(1, 2, 3);
        List<Number> numbers = new ArrayList<>();

        copy(numbers, integers);
        System.out.println(numbers);
    }

}