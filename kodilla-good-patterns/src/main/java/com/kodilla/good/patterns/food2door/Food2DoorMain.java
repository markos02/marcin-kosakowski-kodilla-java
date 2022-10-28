package com.kodilla.good.patterns.food2door;

public class Food2DoorMain {

    public static void main(String[] args) {

        OrderRetriever orderRetriever = new OrderRetriever();
        Order order = orderRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.process(order);

    }
}
