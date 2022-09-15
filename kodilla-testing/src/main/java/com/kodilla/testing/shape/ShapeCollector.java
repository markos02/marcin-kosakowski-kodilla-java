package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeCollector {

    private List<Shape> shapeList = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapeList.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapeList.remove(shape);
    }

    public Shape getFigure(int n) {
        return shapeList.get(n);
    }

    public String showFigures() {

        String result = getShapeList().stream()
                .map(Shape::getShapeName)
                .collect(Collectors.joining(", "));

        return result;
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }
}
