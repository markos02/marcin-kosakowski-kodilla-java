package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {
        //Given
        FileReader fileReader = new FileReader();

        //When & Then
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
    void whenFileDoesntExistsReadFileShouldThrowException() {
        //Given
        FileReader fileReader = new FileReader();
        String fileName = "No_such_file.txt";

        //When & Then
        assertThrows(FileReaderException.class, () -> fileReader.readFileWithFileName(fileName));
    }

    @Test
    void testReadFileWithName() {
        //Given
        FileReader fileReader = new FileReader();

        //When & Then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFileWithFileName("No_such_file.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFileWithFileName(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFileWithFileName("names.txt"))
                );
    }
}
