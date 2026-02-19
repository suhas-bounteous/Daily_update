import java.util.stream.IntStream;

public class MyClass {
    public static void main(String[] args) {
        long count = IntStream.range(1, 1000000)
                .parallel()
                .filter(MyClass::isPrime)
                .count();

        System.out.println("Total primes: " + count);
    }

    // You must define this method for the reference to work
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        // Check divisibility from 2 to the square root of n
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }
}
