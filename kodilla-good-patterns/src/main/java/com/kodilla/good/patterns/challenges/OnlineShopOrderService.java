package com.kodilla.good.patterns.challenges;

public class OnlineShopOrderService implements ProductOrderService{
    @Override
    public void process(Order order) {
        System.out.println(order + " processed");
    }
}
