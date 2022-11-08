package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingsFileEngineTestSuite {

    private static SettingsFileEngine settingsFileEngine;

    @BeforeAll
    public static void openSettingsFile() {
        settingsFileEngine = SettingsFileEngine.INSTANCE;
        settingsFileEngine.open("myapp.settings");
    }

    @AfterAll
    public static void closeSettingsFile() {
        settingsFileEngine.close();
    }

    @Test
    void testGetFileName() {
        //Given
        //When
        //Then
        String expected = "myapp.settings";
        assertEquals(expected, settingsFileEngine.getFileName());
    }

    @Test
    void testLoadSettings() {
        //Given
        //When
        //Then
        assertTrue(settingsFileEngine.loadSettings());
    }

    @Test
    void testSaveSettings() {
        //Given
        //When
        //Then
        assertTrue(settingsFileEngine.saveSettings());
    }


}
