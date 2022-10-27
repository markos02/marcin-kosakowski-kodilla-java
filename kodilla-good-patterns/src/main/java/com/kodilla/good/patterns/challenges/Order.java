package com.kodilla.good.patterns.challenges;

public class Order {

    private final String Id;
    private final Item item;
    private final int quantity;

    public Order(String Id, Item item, int quantity) {
        this.Id = Id;
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item.name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order #" + Id;
    }
}
