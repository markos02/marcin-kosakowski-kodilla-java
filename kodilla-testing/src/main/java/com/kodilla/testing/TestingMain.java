package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //Zadanie: pierwszy test jednostkowy

        Calculator calculator = new Calculator();

        int additionResult = calculator.add(7, 5);
        int substractionResult = calculator.substract(7, 5);

        if (additionResult == 12) {
            System.out.println("Addition test ok");
        } else {
            System.out.println("Addition test failed");
        }

        if (substractionResult == 2) {
            System.out.println("Substraction test ok");
        } else {
            System.out.println("Substraction test failed");
        }
    }
}
