package com.kodilla.testing.shape;

public class Circle implements Shape{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getShapeName() {
        return "Circle";
    }

    public double getField() {
        return Math.PI * radius * radius;
    }
}
