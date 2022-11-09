package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        // Given
        Library library = new Library("School library");

        Book book1 = new Book("Dylan Murphy", "Wolf of the mountain", LocalDate.of(2003,01,01));
        library.getBooks().add(book1);
        library.getBooks().add(new Book("Phoebe Pearson", "Slaves of dreams", LocalDate.of(2012,01,01)));
        library.getBooks().add(new Book("Morgan Walsh", "Obliteration of heaven", LocalDate.of(2001,01,01)));
        library.getBooks().add(new Book("Aimee Murphy", "Rejecting the night", LocalDate.of(2015,01,01)));
        library.getBooks().add(new Book("Ryan Talley", "Gangsters and kings", LocalDate.of(2007,01,01)));
        library.getBooks().add(new Book("Madelynn Carson", "Unity without duty", LocalDate.of(2007,01,01)));
        library.getBooks().add(new Book("Giancarlo Guerrero", "Enemies of eternity", LocalDate.of(2009,01,01)));

        //When
        Library libraryShallowCopy = null;

        try {
            libraryShallowCopy = library.clone();
            libraryShallowCopy.setName("University library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);;
        }

        Library libraryDeepCopy = null;

        try {
            libraryDeepCopy = library.deepCopy();
            libraryDeepCopy.setName("City library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);;
        }

        library.getBooks().remove(book1);

        //Then
        assertEquals(6, library.getBooks().size());
        assertEquals(6, libraryShallowCopy.getBooks().size());
        assertEquals(7, libraryDeepCopy.getBooks().size());
        assertEquals(libraryShallowCopy.getBooks(), library.getBooks());
        assertNotEquals(libraryDeepCopy.getBooks(), library.getBooks());
    }
}
