package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> airportList = new HashMap<>();
        airportList.put("Warszawa", true);
        airportList.put("Wrocław", true);
        airportList.put("Poznań", true);
        airportList.put("Kraków", true);
        airportList.put("Katowice", true);
        airportList.put("Gdynia", false);
        airportList.put("Olsztyn", false);
        airportList.put("Przemyśl", false);
        airportList.put("Zakopane", false);

        try {
            if (airportList.get(flight.getDepartureAirport())) {
                if (airportList.get(flight.getArrivalAirport())) {
                    System.out.println("You can fly from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport());
                } else {
                    System.out.println("You cannot fly to " + flight.getArrivalAirport());
                    throw new RouteNotFoundException();
                }
            } else {
                System.out.println("You cannot fly from " + flight.getDepartureAirport());
                throw new RouteNotFoundException();
            }
        } catch (NullPointerException e) {
            if (airportList.get(flight.getDepartureAirport()) == null) {
                System.out.println("Departure airport (" + flight.getDepartureAirport() + ") does not exist");
            } else {
                System.out.println("Arrival airport (" + flight.getArrivalAirport() + ") does not exist");
            }
            throw new RouteNotFoundException();
        }

    }

    public static void main(String[] args) {

        FlightFinder flightFinder = new FlightFinder();
        List<Flight> flightList = new ArrayList<>();

        flightList.add(new Flight("Warszawa", "Kraków"));
        flightList.add(new Flight("Lublin", "Kraków"));
        flightList.add(new Flight("Warszawa", "Lublin"));
        flightList.add(new Flight("Lublin", "Zamość"));
        flightList.add(new Flight("Warszawa", "Gdynia"));
        flightList.add(new Flight("Gdynia", "Kraków"));
        flightList.add(new Flight("Olsztyn", "Przemyśl"));

        for (Flight flight : flightList) {
            System.out.println();
            try {
                flightFinder.findFlight(flight);
            } catch (RouteNotFoundException e) {
                System.out.println("Exception thrown");
            }
        }
    }
}
