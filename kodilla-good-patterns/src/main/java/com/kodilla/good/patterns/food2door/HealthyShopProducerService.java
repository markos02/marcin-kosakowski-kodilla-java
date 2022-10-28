package com.kodilla.good.patterns.food2door;

public class HealthyShopProducerService implements ProducerService{

    @Override
    public boolean process(String item, int quantity) {

        if (item.equals("beer") || item.equals("chips")) {
            System.out.println("HealthyShop: Order cancelled, ordered food is not healthy");
            return false;
        } else {
            System.out.println("HealthyShop: Order processed");
            return true;
        }
    }

    @Override
    public String getName() {
        return "Healthy Shop";
    }
}
