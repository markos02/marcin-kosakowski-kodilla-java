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


        String departureAirport = flight.getDepartureAirport();
        String arrivalAirport = flight.getArrivalAirport();

        Boolean departureAvailable = airportList.get(departureAirport);
        Boolean arrivalAvailable = airportList.get(arrivalAirport);

        if (departureAvailable == null || arrivalAvailable == null) {
            throw new RouteNotFoundException();
        }

        if (departureAvailable && arrivalAvailable) {
            System.out.println("You can fly from " + departureAirport + " to " + arrivalAirport);
        } else {
            System.out.println("You cant fly from " + departureAirport + " to " + arrivalAirport);
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
