package com.kodilla.good.patterns.food2door;

public class Order {

    private final ProducerService producerService;
    private final String item;
    private final int quantity;

    public Order(ProducerService producerService, String item, int quantity) {
        this.producerService = producerService;
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProducerService getProducerService() {
        return producerService;
    }

    @Override
    public String toString() {
        return "Order{" +
                "producer=" + producerService.getName() +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
