package com.kodilla.stream.array;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        System.out.println(
                IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .mapToObj(i -> ((Integer) i).toString())
                .collect(Collectors.joining(", "))
        );
        double result = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average().getAsDouble();
        return result;
    }

}
