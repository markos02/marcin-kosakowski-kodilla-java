package com.kodilla.good.patterns.airline;

import java.util.ArrayList;
import java.util.List;

public class FlightDatabase {

    private final List<Flight> connectionGrid = new ArrayList<>();

    public boolean addFlight(Flight flight) {

        if (connectionGrid.contains(flight)) {
            System.out.println("Flight already exists");
            return false;
        } else {
            connectionGrid.add(flight);
            return true;
        }
    }

    public boolean airportExists(Airport airport) {

        for (Flight flight : connectionGrid) {
            if (flight.getAirportFrom() == airport || flight.getAirportTo() == airport) {
                return true;
            }
        }
        return false;
    }

    public List<Flight> getConnectionGrid() {
        return connectionGrid;
    }
}
