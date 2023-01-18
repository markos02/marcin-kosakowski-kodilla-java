package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    Calculator calculator;

    @Test
    void testCalculations() {
        //Given
        //When
        double a = 3.5;
        double b = 2.5;

        double addResult = 6.0;
        double subResult = 1.0;
        double mulResult = 8.75;
        double divResult = 1.4;

        //Then
        assertEquals(addResult,calculator.add(a,b));
        assertEquals(subResult,calculator.sub(a,b));
        assertEquals(mulResult,calculator.mul(a,b));
        assertEquals(divResult,calculator.div(a,b));

    }
}
