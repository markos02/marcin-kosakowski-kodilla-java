package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawerTestSuite {

    @Test
    void testDoDrawingWithCircle() {
        //Given
        Drawer drawer = new Drawer(new Circle());

        //When
        String result = "This is a circle";

        //Then
        assertEquals(result, drawer.doDrawing());
    }

    @Test
    void testDoDrawingWithTriangle() {
        //Given
        Drawer drawer = new Drawer(new Triangle());

        //When
        String result = "This is a triangle";

        //Then
        assertEquals(result, drawer.doDrawing());
    }
}
