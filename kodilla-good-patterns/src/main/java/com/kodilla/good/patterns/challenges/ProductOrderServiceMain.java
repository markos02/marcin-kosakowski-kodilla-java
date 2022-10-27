package com.kodilla.good.patterns.challenges;

public class ProductOrderServiceMain {

    public static void main(String[] args) {

        OrderRetriever orderRetriever = new OrderRetriever();
        Order order = orderRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new StockStatusService(), new MailService(), new OnlineShopOrderService(), new OnlineShopDatabaseService());
        orderProcessor.process(order);
    }

}
