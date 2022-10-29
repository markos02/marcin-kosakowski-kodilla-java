package com.kodilla.good.patterns.airline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightDatabaseTestSuite {

    @Test
    void testAddFlightToDatabase() {
        //Given
        Flight flight1 = new Flight(new Airport("Krakow"), new Airport("Warszawa"));
        FlightDatabase flightDatabase = new FlightDatabase();

        //When
        flightDatabase.addFlight(flight1);

        //Then
        assertTrue(flightDatabase.getConnectionGrid().contains(flight1));
    }

    @Test
    void testAddExistingFlightToDatabase() {
        //Given
        Flight flight1 = new Flight(new Airport("Krakow"), new Airport("Warszawa"));
        FlightDatabase flightDatabase = new FlightDatabase();

        //When
        flightDatabase.addFlight(flight1);

        //Then
        assertFalse(flightDatabase.addFlight(flight1));
    }


}
