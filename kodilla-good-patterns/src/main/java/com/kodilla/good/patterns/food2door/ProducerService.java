package com.kodilla.good.patterns.food2door;

public interface ProducerService {


    boolean process(String item, int quantity);

    String getName();

}
