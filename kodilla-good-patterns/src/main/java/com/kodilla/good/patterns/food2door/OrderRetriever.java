package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderRetriever {

    public Order retrieve() {

        List<Order> orderList = new ArrayList<>();

        orderList.add(new Order(new ExtraFoodShopProducerService(), "bread", 5));
        orderList.add(new Order(new HealthyShopProducerService(), "tomato", 10));
        orderList.add(new Order(new GlutenFreeShopProducerService(), "bread", 1));
        orderList.add(new Order(new ExtraFoodShopProducerService(), "chips", 3));
        orderList.add(new Order(new HealthyShopProducerService(), "beer", 12));
        orderList.add(new Order(new GlutenFreeShopProducerService(), "milk", 1));
        orderList.add(new Order(new GlutenFreeShopProducerService(), "milk", 6));

        Random random = new Random();

        int index = random.nextInt(0,7);

        System.out.println(orderList.get(index));

        return orderList.get(index);
    }
}
