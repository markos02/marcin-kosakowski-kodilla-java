package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    void after() {
        System.out.println("Test Case: end\n");
    }

    @DisplayName("When empty list is the argument, then result should be empty list")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator emptyExterminator = new OddNumbersExterminator();

        //When
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> result = emptyExterminator.exterminate(emptyList);
        List<Integer> expectedResult = new ArrayList<>();

        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("When the argument is a list with numbers, then result should be the same list without odd numbers")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator testExterminator = new OddNumbersExterminator();

        //When
        List<Integer> testList = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = testExterminator.exterminate(testList);
        List<Integer> expectedResult = Arrays.asList(2, 4, 6, 8, 10);

        //Then
        Assertions.assertEquals(expectedResult, result);
    }



}
