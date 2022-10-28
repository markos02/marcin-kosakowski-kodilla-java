package com.kodilla.good.patterns.food2door;

import java.util.Random;

public class ExtraFoodShopProducerService implements ProducerService{

    @Override
    public boolean process(String item, int quantity) {

        Random random = new Random();

        boolean isAvailable = random.nextBoolean();

        if (isAvailable) {
            System.out.println("ExtraFoodShop: Order processed");
            return true;
        } else {
            System.out.println("ExtraFoodShop: Order cancelled, out of stock");
            return false;
        }
    }

    @Override
    public String getName() {
        return "Extra Food Shop";
    }
}
