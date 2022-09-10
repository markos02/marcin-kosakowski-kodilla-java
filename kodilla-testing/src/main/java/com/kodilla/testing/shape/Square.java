package com.kodilla.testing.shape;

public class Square implements Shape{

    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public String getShapeName() {
        return "Square";
    }

    public double getField() {
        return sideLength*sideLength;
    }
}
