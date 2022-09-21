package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondChallengeTestSuite {

    @Test
    void testDoesNotThrowException() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5,2));
    }

    @Test
    void firstNumberEquals2() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, ()-> secondChallenge.probablyIWillThrowException(2,2));
    }

    @Test
    void firstNumberEquals1() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1,2));
    }

    @Test
    void firstNumberLargerThan2() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, ()-> secondChallenge.probablyIWillThrowException(3,2));
    }

    @Test
    void firstNumberSmallerThan1() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, ()-> secondChallenge.probablyIWillThrowException(0.9999,2));
    }

    @Test
    void secondNumberEqual1_5() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, ()-> secondChallenge.probablyIWillThrowException(1.5,1.5));
    }

    @Test
    void firstNumberSmallerThan1AndSecondNumberEqual1_5() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, ()-> secondChallenge.probablyIWillThrowException(-5,1.5));
    }

}
