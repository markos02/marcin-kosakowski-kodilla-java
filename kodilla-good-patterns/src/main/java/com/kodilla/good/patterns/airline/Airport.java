package com.kodilla.good.patterns.airline;

public class Airport {

    private final String city;

    public Airport(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return city.equals(airport.city);
    }

    @Override
    public int hashCode() {
        return city.hashCode();
    }
}
