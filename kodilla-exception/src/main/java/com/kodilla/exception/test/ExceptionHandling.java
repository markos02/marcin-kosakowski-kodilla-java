package com.kodilla.exception.test;

public class ExceptionHandling {

    SecondChallenge secondChallenge = new SecondChallenge();

    public void process(double x, double y) {
        try {
            secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            System.out.println("Exception was thrown!");
        } finally {
            System.out.println("Program finished");
        }
    }
}
