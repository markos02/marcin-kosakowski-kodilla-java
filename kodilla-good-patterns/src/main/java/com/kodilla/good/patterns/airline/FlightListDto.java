package com.kodilla.good.patterns.airline;

import java.util.List;

public class FlightListDto {

    private final List<Flight> flightList;
    private final boolean isFound;

    public FlightListDto(List<Flight> flightList, boolean isFound) {
        this.flightList = flightList;
        this.isFound = isFound;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public boolean getIsFound() {
        return isFound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightListDto that = (FlightListDto) o;

        if (isFound != that.isFound) return false;
        return flightList.equals(that.flightList);
    }

    @Override
    public int hashCode() {
        int result = flightList.hashCode();
        result = 31 * result + (isFound ? 1 : 0);
        return result;
    }
}
