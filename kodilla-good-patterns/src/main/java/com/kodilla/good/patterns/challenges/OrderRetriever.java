package com.kodilla.good.patterns.challenges;

public class OrderRetriever {

    public Order retrieve() {

        String id = "99874";
        Item item = new Item("TV", 3.99);
        int quantity = 1;

        return new Order(id, item, quantity);

    }
}
