package com.kodilla.good.patterns.airline;

import java.util.ArrayList;
import java.util.List;

public class FlightFinderService {

    private final FlightDatabase flightDatabase;

    public FlightFinderService(FlightDatabase flightDatabase) {
        this.flightDatabase = flightDatabase;
    }

    public FlightListDto findAllFlights(Airport airport, Direction direction) {

        List<Flight> flightList = new ArrayList<>();
        FlightListDto result = new FlightListDto(flightList, false);

        if (!flightDatabase.airportExists(airport)) {
            return result;
        }

        if (direction.equals(Direction.FROM)) {

            flightList = flightDatabase.getConnectionGrid().stream()
                    .filter(flight -> flight.getAirportFrom().equals(airport)).toList();

        } else {

            flightList = flightDatabase.getConnectionGrid().stream()
                    .filter(flight -> flight.getAirportTo().equals(airport)).toList();
        }

        if (flightList.size() == 0) {
            result = new FlightListDto(flightList, false);
        } else {
            result = new FlightListDto(flightList, true);
        }

        return result;
    }

    public FlightListDto findConnectionFlights (Airport airportFrom, Airport airportTo) {

        List<Flight> connectionFlight = new ArrayList<>();
        FlightListDto result = new FlightListDto(connectionFlight, false);

        FlightListDto allFlightsAirportFrom = findAllFlights(airportFrom, Direction.FROM);
        FlightListDto allFlightsAirportTo = findAllFlights(airportTo, Direction.TO);

        if (allFlightsAirportFrom.getIsFound() && allFlightsAirportTo.getIsFound()) {

            for (Flight flight1: allFlightsAirportFrom.getFlightList()) {
                for (Flight flight2: allFlightsAirportTo.getFlightList()) {

                    if (flight1.getAirportTo().equals(flight2.getAirportFrom())) {

                        connectionFlight.add(flight1);
                        connectionFlight.add(flight2);
                        result = new FlightListDto(connectionFlight, true);
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
