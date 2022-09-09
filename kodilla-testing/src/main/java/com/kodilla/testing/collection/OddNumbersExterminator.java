package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {

        List<Integer> resultList = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                resultList.add(number);
            }
        }

        return resultList;

    }
}
