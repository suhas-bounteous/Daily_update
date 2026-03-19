import java.util.*;
import java.util.stream.*;

public class LogProcessing {

    public static void main(String[] args) {

        List<String> logs = Arrays.asList("123", "", null, "456", "error_404", "789");

        // Filter + safe parsing
        List<Integer> numbers = logs.stream()
                .filter(s -> s != null && !s.isEmpty())
                .map(LogProcessing::parseInteger)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        System.out.println("Valid Numbers: " + numbers);
    }

    // Helper method using Optional
    public static Optional<Integer> parseInteger(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
