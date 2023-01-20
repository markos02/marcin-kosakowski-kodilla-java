package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        // Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("Stephen King", "Roland", 1982, "9788365781314"));
        books.add(new Book("Stephen King", "Powołanie trójki", 1987, "9788379855841"));
        books.add(new Book("Stephen King", "Ziemie Jałowe", 2003, "9788379855858"));
        books.add(new Book("Stephen King", "Czarnoksiężnik i kryształ", 2012, "9788379855865"));
        books.add(new Book("Stephen King", "Wiatr przez dziurkę od klucza", 2012, "9788379855902"));
        MedianAdapter medianAdapter = new MedianAdapter();
        // When
        int result = medianAdapter.publicationYearMedian(books);
        // Then
        assertEquals(2003, result);
    }
}
