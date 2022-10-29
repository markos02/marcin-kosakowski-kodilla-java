package com.kodilla.good.patterns.airline;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFinderServiceTestSuite {

    private static FlightDatabase flightDatabase;
    private static final Airport krakowAirport = new Airport("Kraków");
    private static final Airport warszawaAirport = new Airport("Warszawa");
    private static final Airport wroclawAirport = new Airport("Wrocław");
    private static final Airport gdanskAirport = new Airport("Gdańsk");
    private static final Airport rzeszowAirport = new Airport("Rzeszów");
    private static final Airport poznanAirport = new Airport("Poznań");
    private static final Airport olsztynAirport = new Airport("Olsztyn");

    private static FlightDatabase generateConnectionGrid() {

        FlightDatabase flightDatabase = new FlightDatabase();

        flightDatabase.addFlight(new Flight(krakowAirport, warszawaAirport));
        flightDatabase.addFlight(new Flight(warszawaAirport, krakowAirport));
        flightDatabase.addFlight(new Flight(krakowAirport, wroclawAirport));
        flightDatabase.addFlight(new Flight(wroclawAirport, krakowAirport));
        flightDatabase.addFlight(new Flight(warszawaAirport, wroclawAirport));
        flightDatabase.addFlight(new Flight(wroclawAirport, warszawaAirport));
        flightDatabase.addFlight(new Flight(warszawaAirport, gdanskAirport));
        flightDatabase.addFlight(new Flight(gdanskAirport, warszawaAirport));
        flightDatabase.addFlight(new Flight(warszawaAirport, rzeszowAirport));
        flightDatabase.addFlight(new Flight(rzeszowAirport, warszawaAirport));
        flightDatabase.addFlight(new Flight(gdanskAirport, poznanAirport));
        flightDatabase.addFlight(new Flight(poznanAirport, gdanskAirport));
        flightDatabase.addFlight(new Flight(olsztynAirport, rzeszowAirport));
        flightDatabase.addFlight(new Flight(rzeszowAirport, olsztynAirport));

        return flightDatabase;
    }

    @BeforeAll
    public static void beforeEach() {
        flightDatabase = FlightFinderServiceTestSuite.generateConnectionGrid();
    }

    @Nested
    @DisplayName("Tests for finding all flights from an airport")
    class testFindAllFlightsFrom {

        @Test
        void testFindAllFlightsFromOneFlightExists() {
            //Given
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            expectedFlightList.add(new Flight(poznanAirport, gdanskAirport));
            FlightListDto expected = new FlightListDto(expectedFlightList, true);

            assertEquals(expected, flightFinderService.findAllFlights(poznanAirport, Direction.FROM));
        }

        @Test
        void testFindAllFlightsFromSeveralFlightExists() {
            //Given
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            expectedFlightList.add(new Flight(krakowAirport, warszawaAirport));
            expectedFlightList.add(new Flight(krakowAirport, wroclawAirport));
            FlightListDto expected = new FlightListDto(expectedFlightList, true);

            assertEquals(expected, flightFinderService.findAllFlights(krakowAirport, Direction.FROM));
        }

        @Test
        void testFindAllFlightsFromNoFlightExists() {
            //Given
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            FlightListDto expected = new FlightListDto(expectedFlightList, false);

            assertEquals(expected, flightFinderService.findAllFlights(new Airport("Szczecin"), Direction.FROM));
        }

        @Test
        void testFindAllFlightsFromEmptyConnectionGrid() {
            //Given
            FlightDatabase flightDatabase1 = new FlightDatabase();
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase1);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            FlightListDto expected = new FlightListDto(expectedFlightList, false);

            assertEquals(expected, flightFinderService.findAllFlights(krakowAirport, Direction.FROM));
        }
    }

    @Nested
    @DisplayName("Tests for finding all flights to an airport")
    class testFindAllFlightsTo {

        @Test
        void testFindAllFlightsToOneFlightExists() {
            //Given
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            expectedFlightList.add(new Flight(gdanskAirport, poznanAirport));
            FlightListDto expected = new FlightListDto(expectedFlightList, true);

            assertEquals(expected, flightFinderService.findAllFlights(poznanAirport, Direction.TO));
        }

        @Test
        void testFindAllFlightsToSeveralFlightExists() {
            //Given
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            expectedFlightList.add(new Flight(warszawaAirport, krakowAirport));
            expectedFlightList.add(new Flight(wroclawAirport, krakowAirport));
            FlightListDto expected = new FlightListDto(expectedFlightList, true);

            assertEquals(expected, flightFinderService.findAllFlights(krakowAirport, Direction.TO));
        }

        @Test
        void testFindAllFlightsFromNoFlightExists() {
            //Given
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            FlightListDto expected = new FlightListDto(expectedFlightList, false);

            assertEquals(expected, flightFinderService.findAllFlights(new Airport("Szczecin"), Direction.TO));
        }

        @Test
        void testFindAllFlightsFromEmptyConnectionGrid() {
            //Given
            FlightDatabase flightDatabase1 = new FlightDatabase();
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase1);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            FlightListDto expected = new FlightListDto(expectedFlightList, false);

            assertEquals(expected, flightFinderService.findAllFlights(krakowAirport, Direction.TO));
        }
    }

    @Nested
    @DisplayName("Tests for finding connection flights")
    class testFindConnectionFlights {

        @Test
        void testFindConnectionFlightsExists() {
            //Given
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase);

            //When & Then
            List<Flight> expectedFlightList1 = new ArrayList<>();
            expectedFlightList1.add(new Flight(krakowAirport, warszawaAirport));
            expectedFlightList1.add(new Flight(warszawaAirport, gdanskAirport));
            FlightListDto expected1 = new FlightListDto(expectedFlightList1, true);

            List<Flight> expectedFlightList2 = new ArrayList<>();
            expectedFlightList2.add(new Flight(warszawaAirport, rzeszowAirport));
            expectedFlightList2.add(new Flight(rzeszowAirport, olsztynAirport));
            FlightListDto expected2 = new FlightListDto(expectedFlightList2, true);

            List<Flight> expectedFlightList3 = new ArrayList<>();
            expectedFlightList3.add(new Flight(olsztynAirport, rzeszowAirport));
            expectedFlightList3.add(new Flight(rzeszowAirport, warszawaAirport));
            FlightListDto expected3 = new FlightListDto(expectedFlightList3, true);

            assertEquals(expected1, flightFinderService.findConnectionFlights(krakowAirport, gdanskAirport));
            assertEquals(expected2, flightFinderService.findConnectionFlights(warszawaAirport, olsztynAirport));
            assertEquals(expected3, flightFinderService.findConnectionFlights(olsztynAirport, warszawaAirport));
        }

        @Test
        void testFindConnectionFlightsNoConnectionFlight() {
            //Given
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            FlightListDto expected = new FlightListDto(expectedFlightList, false);

            assertEquals(expected, flightFinderService.findConnectionFlights(krakowAirport, olsztynAirport));
        }

        @Test
        void testFindConnectionFlightsAirportDoesNotExist() {
            //Given
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            FlightListDto expected = new FlightListDto(expectedFlightList, false);

            assertEquals(expected, flightFinderService.findConnectionFlights(new Airport("Szczecin"), olsztynAirport));
        }

        @Test
        void testFindConnectionEmptyConnectionGrid() {
            //Given
            FlightDatabase flightDatabase1 = new FlightDatabase();
            FlightFinderService flightFinderService = new FlightFinderService(flightDatabase1);

            //When & Then
            List<Flight> expectedFlightList = new ArrayList<>();
            FlightListDto expected = new FlightListDto(expectedFlightList, false);

            assertEquals(expected, flightFinderService.findConnectionFlights(krakowAirport, gdanskAirport));
        }
    }
}
