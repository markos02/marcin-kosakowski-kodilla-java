package com.kodilla.testing.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {

        List<Book> resultList = new ArrayList<>();
        for (int i = 1; i <= booksQuantity; i++) {
            resultList.add(new Book("Title " + i, "Author " + i, 1970 + i));
        }

        return resultList;
    }

    @Nested
    @DisplayName("Tests for getting a list og books with condition")
    class testListBooksWithCondition {

        @Test
        void testListBooksWithConditionReturnList() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            // Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testListBooksWithConditionMoreThan20() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = generateListOfNBooks(0);
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("AnyTitle");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

            // Then
            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());

        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("An");

            // Then
            assertEquals(0, theListOfBooks.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("Tests for getting a list og books in hands of library user")
    class listBooksInHandsOf {

        @Test
        void testListBooksInHandsOfNoBooks() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUserNoBooks = new LibraryUser("John", "Smith", "12345");
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUserNoBooks)).thenReturn(generateListOfNBooks(0));

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(libraryUserNoBooks);

            // Then
            assertEquals(0, theListOfBooks.size());
        }

        @Test
        void testListBooksInHandsOsReturnList() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser1Book = new LibraryUser("User1Book", "Smith", "12345");
            LibraryUser libraryUser5Books = new LibraryUser("User5Books", "Smith", "12345");
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1Book)).thenReturn(generateListOfNBooks(1));
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser5Books)).thenReturn(generateListOfNBooks(5));

            // When
            List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUser1Book);
            List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUser5Books);

            // Then
            assertEquals(1, theListOfBooks1.size());
            assertEquals(5, theListOfBooks5.size());
        }
    }
}


