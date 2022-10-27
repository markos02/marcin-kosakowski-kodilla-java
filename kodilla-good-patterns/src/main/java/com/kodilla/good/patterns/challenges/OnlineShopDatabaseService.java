package com.kodilla.good.patterns.challenges;

public class OnlineShopDatabaseService implements OrderDatabaseService{
    @Override
    public void saveOrder(Order order) {
        System.out.println(order + " saved in database");
    }
}
