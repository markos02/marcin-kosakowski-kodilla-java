package com.kodilla.good.patterns.food2door;

public class OrderProcessor {

    public boolean process(Order order) {

        boolean isCompleted = order.getProducerService().process(order.getItem(), order.getQuantity());

        if (isCompleted) {
            System.out.println("Order completed");
        } else {
            System.out.println("Order cancelled");
        }
        return isCompleted;
    }
}
