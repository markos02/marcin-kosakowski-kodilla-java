package com.kodilla.good.patterns.airline;

public class Flight {

    private final Airport airportFrom;
    private final Airport airportTo;

    public Flight(Airport airportFrom, Airport airportTo) {
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
    }

    public Airport getAirportFrom() {
        return airportFrom;
    }

    public Airport getAirportTo() {
        return airportTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!airportFrom.equals(flight.airportFrom)) return false;
        return airportTo.equals(flight.airportTo);
    }

    @Override
    public int hashCode() {
        int result = airportFrom.hashCode();
        result = 31 * result + airportTo.hashCode();
        return result;
    }
}
