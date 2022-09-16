package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int testArray[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4, 5, 6, 8, 3, 1, 6, 5, 7, 3};

        //When
        double result = ArrayOperations.getAverage(testArray);

        //Then
        assertEquals(5.15, result);


    }
}
