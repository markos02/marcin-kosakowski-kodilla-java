package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public final static String SHOPPING_TASK = "Shopping task";
    public final static String PAINTING_TASK = "Painting task";
    public final static String DRIVING_TASK = "Driving task";

    public Task createTask(String taskType) {
        return switch (taskType) {
            case SHOPPING_TASK -> new ShoppingTask("Grocery's", "Milk", 2.0);
            case PAINTING_TASK -> new PaintingTask("Dining room", "Grey", "Walls");
            case DRIVING_TASK -> new DrivingTask("Holiday", "Italy", "Car");
            default -> null;
        };
    }

}
