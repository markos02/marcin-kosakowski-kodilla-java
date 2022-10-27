package com.kodilla.good.patterns.challenges;

public class OrderDto {

    Order order;
    boolean isAccepted;

    public OrderDto(Order order, boolean isAccepted) {
        this.order = order;
        this.isAccepted = isAccepted;
    }
}
