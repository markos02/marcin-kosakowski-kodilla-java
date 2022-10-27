package com.kodilla.good.patterns.challenges;

import java.util.Random;

public class StockStatusService implements AvailabilityCheckService{

    @Override
    public boolean checkAvailability(Order order) {

        Random random = new Random();

        boolean isAvailable = random.nextBoolean();

        if (isAvailable) {
            System.out.println(order.getQuantity() + " x " + order.getItem() + " is available");
        } else {
            System.out.println(order.getQuantity() + " x " + order.getItem() + " is not available");
        }

        return isAvailable;
    }
}
