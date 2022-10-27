package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private final AvailabilityCheckService availabilityCheckService;
    private final InformationService informationService;
    private final ProductOrderService productOrderService;
    private final OrderDatabaseService orderDatabaseService;

    public OrderProcessor(AvailabilityCheckService availabilityCheckService, InformationService informationService, ProductOrderService productOrderService, OrderDatabaseService orderDatabaseService) {
        this.availabilityCheckService = availabilityCheckService;
        this.informationService = informationService;
        this.productOrderService = productOrderService;
        this.orderDatabaseService = orderDatabaseService;
    }

    public OrderDto process(Order order) {

        boolean isAvailable = availabilityCheckService.checkAvailability(order);
        if (isAvailable) {
            informationService.inform();
            productOrderService.process(order);
            orderDatabaseService.saveOrder(order);
            return new OrderDto(order, true);
        } else {
            return new OrderDto(order, false);
        }
    }
}
