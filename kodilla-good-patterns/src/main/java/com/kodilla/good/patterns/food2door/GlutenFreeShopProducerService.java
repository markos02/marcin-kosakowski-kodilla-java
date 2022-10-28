package com.kodilla.good.patterns.food2door;

public class GlutenFreeShopProducerService implements ProducerService {

    @Override
    public boolean process(String item, int quantity) {

        if (item.equals("bread")) {
            System.out.println("GlutenFreeShop: Order cancelled, product is not gluten free");
            return false;
        }

        if (quantity > 5) {
            System.out.println("GlutenFreeShop: Order cancelled, product is out of stock");
            return false;
        }

        System.out.println("GlutenFreeShop: Order processed");
        return true;
    }

    @Override
    public String getName() {
        return "Gluten Free Shop";
    }
}




