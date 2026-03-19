import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookProcessing {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("Java Basics", "Alice", 2018, false),
                new Book("Advanced Java", "Bob", 2021, true),
                new Book("Spring Boot Guide", "Alice", 2023, true),
                new Book("Data Structures", "Charlie", 2015, false)
        );

        // 1. Group by author
        Map<String, List<Book>> booksByAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
        System.out.println("Books by Author: " + booksByAuthor);

        // 2. Oldest book
        Book oldestBook = books.stream()
                .min(Comparator.comparingInt(Book::getYear))
                .orElse(new Book("Unknown Book", "Unknown", 0, false));

        System.out.println("Oldest Book: " + oldestBook);

        // 3. Titles after 2020
        String titles = books.stream()
                .filter(book -> book.getYear() > 2020)
                .map(Book::getTitle)
                .collect(Collectors.joining(", "));

        System.out.println("Books after 2020: " + titles);
    }
}
