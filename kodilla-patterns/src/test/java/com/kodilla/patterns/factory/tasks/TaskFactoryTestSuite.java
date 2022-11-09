package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {

    TaskFactory taskFactory = new TaskFactory();

    @Test
    void testShoppingTask() {
        //Given
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPING_TASK);

        //When
        shoppingTask.executeTask();

        //Then
        assertEquals("Grocery's", shoppingTask.getTaskName());
        assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    void testPaintingTask() {
        //Given
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTING_TASK);

        //When
        paintingTask.executeTask();

        //Then
        assertEquals("Dining room", paintingTask.getTaskName());
        assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    void testDrivingTask() {
        //Given
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVING_TASK);

        //When
        drivingTask.executeTask();

        //Then
        assertEquals("Holiday", drivingTask.getTaskName());
        assertTrue(drivingTask.isTaskExecuted());
    }
}
