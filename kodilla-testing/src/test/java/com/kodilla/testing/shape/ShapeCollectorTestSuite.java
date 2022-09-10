package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAlTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for adding a figure")
    class testAddingAFigure {

        @Test
        void testAddSquare() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(1);

            //When
            shapeCollector.addFigure(square);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeList().size());
        }

        @Test
        void testAddCircle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(1);

            //When
            shapeCollector.addFigure(circle);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeList().size());
        }

        @Test
        void testAddTriangle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle(1, 2);

            //When
            shapeCollector.addFigure(triangle);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeList().size());
        }

        @Test
        void testAddMultipleFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(1);
            Circle circle = new Circle(1);
            Triangle triangle = new Triangle(1, 2);

            //When
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);

            //Then
            Assertions.assertEquals(3, shapeCollector.getShapeList().size());
        }

    }

    @Nested
    @DisplayName("Tests for removing a figure")
    class testRemovingFigure {
        @Test
        void testRemoveSquare() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(1);
            Circle circle = new Circle(1);
            Triangle triangle = new Triangle(1, 2);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);

            //When
            shapeCollector.removeFigure(square);

            //Then
            Assertions.assertFalse(shapeCollector.getShapeList().contains(square));
            Assertions.assertEquals(2, shapeCollector.getShapeList().size());
        }

        @Test
        void testRemoveCircle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(1);
            Circle circle = new Circle(1);
            Triangle triangle = new Triangle(1, 2);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);

            //When
            shapeCollector.removeFigure(circle);

            //Then
            Assertions.assertFalse(shapeCollector.getShapeList().contains(circle));
            Assertions.assertEquals(2, shapeCollector.getShapeList().size());
        }

        @Test
        void testRemoveTriangle() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(1);
            Circle circle = new Circle(1);
            Triangle triangle = new Triangle(1, 2);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);

            //When
            shapeCollector.removeFigure(triangle);

            //Then
            Assertions.assertFalse(shapeCollector.getShapeList().contains(triangle));
            Assertions.assertEquals(2, shapeCollector.getShapeList().size());
        }


    }

    @Nested
    @DisplayName("Tests for getting figures")
    class testGettingFigures {
        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(1);
            Circle circle = new Circle(1);
            Triangle triangle = new Triangle(1, 2);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);

            //When
            Square retrievedSquare = (Square) shapeCollector.getFigure(0);
            Circle retrievedCircle = (Circle) shapeCollector.getFigure(1);
            Triangle retrievedTriangle = (Triangle) shapeCollector.getFigure(2);


            //Then
            Assertions.assertEquals(square, retrievedSquare);
            Assertions.assertEquals(circle, retrievedCircle);
            Assertions.assertEquals(triangle, retrievedTriangle);

        }
    }

    @Nested
    @DisplayName("Test for showing figures")
    class testShowFigures {

        @Test
        void testShowFiguresEmptyCollection() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            String retrievedFigures = shapeCollector.showFigures();
            String expectedResult = "";

            //Then
            Assertions.assertEquals(expectedResult, retrievedFigures);
        }

        @Test
        void testShowFiguresDifferentElementCollection() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(1);
            Circle circle = new Circle(1);
            Triangle triangle = new Triangle(1, 2);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);

            //When
            String retrievedFigures = shapeCollector.showFigures();
            String expectedResult = "Square, Circle, Triangle";


            //Then
            Assertions.assertEquals(expectedResult, retrievedFigures);
        }

        @Test
        void testShowFiguresSameElementTypeCollection() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square1 = new Square(1);
            Square square2 = new Square(2);
            Square square3 = new Square(3);
            shapeCollector.addFigure(square1);
            shapeCollector.addFigure(square2);
            shapeCollector.addFigure(square3);

            //When
            String retrievedFigures = shapeCollector.showFigures();
            String expectedResult = "Square, Square, Square";


            //Then
            Assertions.assertEquals(expectedResult, retrievedFigures);
        }
    }
}
