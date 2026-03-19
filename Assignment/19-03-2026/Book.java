import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String author;
    int year;
    boolean isDigital;

    public Book(String title, String author, int year, boolean isDigital) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isDigital = isDigital;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public boolean isDigital() { return isDigital; }

    @Override
    public String toString() {
        return title + " (" + year + ")";
    }
}
