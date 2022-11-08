package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @Test
    void testGetLastLogEmptyLog() {
        //Given
        logger = Logger.INSTANCE;
        //When
        //Then
        String expected = "";
        assertEquals(expected, logger.getLastLog());
    }

    @Test
    void testGetLastLog() {
        //Given
        logger = Logger.INSTANCE;
        //When
        logger.log("Log1");
        //Then
        String expected = "Log1";
        assertEquals(expected, logger.getLastLog());
    }

}
