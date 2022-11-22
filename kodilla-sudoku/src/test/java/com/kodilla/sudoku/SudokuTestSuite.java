package com.kodilla.sudoku;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuTestSuite {

    @Nested
    class testSudokuElement {

        @Test
        void testNewElement() {
            //Given
            //When
            SudokuElement sudokuElement = new SudokuElement();

            //Then
            assertNotNull(sudokuElement);
            assertEquals(SudokuElement.EMPTY, sudokuElement.getValue());
            assertEquals(9, sudokuElement.getPossibleValues().size());
        }

        @Test
        void testSetValue() {
            //Given
            SudokuElement sudokuElement = new SudokuElement();

            //When
            sudokuElement.setValue(5);

            //Then
            assertEquals(5, sudokuElement.getValue());
            assertEquals(0, sudokuElement.getPossibleValues().size());
        }

        @Test
        void testRemovePossibleValue() throws UnsolvableSudokuException {
            //Given
            SudokuElement sudokuElement = new SudokuElement();

            //When
            sudokuElement.removePossibleValue(3);

            //Then
            assertEquals(SudokuElement.EMPTY, sudokuElement.getValue());
            assertEquals(8, sudokuElement.getPossibleValues().size());
            assertFalse(sudokuElement.getPossibleValues().contains(3));
        }

        @Test
        void testRemovePossibleValueLastValue() throws UnsolvableSudokuException {
            //Given
            SudokuElement sudokuElement = new SudokuElement();

            //When
            sudokuElement.removePossibleValue(1);
            sudokuElement.removePossibleValue(2);
            sudokuElement.removePossibleValue(4);
            sudokuElement.removePossibleValue(5);
            sudokuElement.removePossibleValue(6);
            sudokuElement.removePossibleValue(7);
            sudokuElement.removePossibleValue(8);
            sudokuElement.removePossibleValue(9);

            //Then
            assertEquals(1, sudokuElement.getPossibleValues().size());
            assertEquals(3, sudokuElement.getPossibleValues().get(0));
        }

        @Test
        void testRemovePossibleValueALlValues() throws UnsolvableSudokuException {
            //Given
            SudokuElement sudokuElement = new SudokuElement();

            //When
            sudokuElement.removePossibleValue(1);
            sudokuElement.removePossibleValue(2);
            sudokuElement.removePossibleValue(3);
            sudokuElement.removePossibleValue(4);
            sudokuElement.removePossibleValue(5);
            sudokuElement.removePossibleValue(6);
            sudokuElement.removePossibleValue(7);
            sudokuElement.removePossibleValue(8);

            //Then
            assertThrows(UnsolvableSudokuException.class, () -> sudokuElement.removePossibleValue(9));
        }

        @Test
        void testDeepCopyEmptyElement() throws CloneNotSupportedException {
            //Given
            SudokuElement sudokuElement1 = new SudokuElement();

            //When
            SudokuElement sudokuElement2 = sudokuElement1.deepCopy();

            //Then
            assertNotNull(sudokuElement2);
        }

        @Test
        void testDeepCopyWithValue() throws CloneNotSupportedException {
            //Given
            SudokuElement sudokuElement1 = new SudokuElement();

            //When
            sudokuElement1.setValue(3);
            SudokuElement sudokuElement2 = sudokuElement1.deepCopy();

            //Then
            assertEquals(3, sudokuElement2.getValue());
            assertEquals(0, sudokuElement2.getPossibleValues().size());
        }

        @Test
        void testDeepCopyAdvanced() throws CloneNotSupportedException, UnsolvableSudokuException {
            //Given
            SudokuElement sudokuElement1 = new SudokuElement();

            //When
            sudokuElement1.removePossibleValue(2);
            SudokuElement sudokuElement2 = sudokuElement1.deepCopy();
            sudokuElement1.removePossibleValue(3);

            //Then
            assertFalse(sudokuElement1.getPossibleValues().contains(2));
            assertFalse(sudokuElement2.getPossibleValues().contains(2));
            assertFalse(sudokuElement1.getPossibleValues().contains(3));
            assertTrue(sudokuElement2.getPossibleValues().contains(3));
        }
    }

    @Nested
    class testSudokuRow {

        @Test
        void testDeepCopyEmpty() throws CloneNotSupportedException {
            //Given
            SudokuRow sudokuRow1 = new SudokuRow();

            //When
            SudokuRow sudokuRow2 = sudokuRow1.deepCopy();

            //Then
            assertNotNull(sudokuRow2);
        }

        @Test
        void testDeepCopyAdvanced() throws CloneNotSupportedException {
            //Given
            SudokuRow sudokuRow1 = new SudokuRow();

            //When
            sudokuRow1.getSudokuRow().get(0).setValue(3);
            SudokuRow sudokuRow2 = sudokuRow1.deepCopy();
            sudokuRow1.getSudokuRow().get(2).setValue(5);

            //Then
            assertEquals(3, sudokuRow1.getSudokuRow().get(0).getValue());
            assertEquals(3, sudokuRow2.getSudokuRow().get(0).getValue());
            assertEquals(5, sudokuRow1.getSudokuRow().get(2).getValue());
            assertEquals(SudokuElement.EMPTY, sudokuRow2.getSudokuRow().get(2).getValue());
        }
    }

    @Nested
    class testSudokuBoard {

        @Test
        void testCreateNewSudokuBoard() {
            //Given
            SudokuBoard sudokuBoard = new SudokuBoard();

            //When
            int numberRows = sudokuBoard.getSudokuRows().size();
            int numberColumns = sudokuBoard.getSudokuRows().get(0).getSudokuRow().size();
            int value = sudokuBoard.getElement(0, 0).getValue();
            int numberPossibilities = sudokuBoard.getElement(0, 0).getPossibleValues().size();

            //Then
            assertEquals(9, numberRows);
            assertEquals(9, numberColumns);
            assertEquals(-1, value);
            assertEquals(9, numberPossibilities);
        }

        @Test
        void testSetValueIllegalValue() {
            //Given
            SudokuBoard sudokuBoard = new SudokuBoard();

            //When

            //Then
            assertThrows(IllegalArgumentException.class, () -> sudokuBoard.getElement(-2, 0).setValue(3));
            assertThrows(IllegalArgumentException.class, () -> sudokuBoard.getElement(3, 10).setValue(3));
        }

        @Test
        void testIsFull() {
            //Given
            SudokuBoard sudokuBoard1 = new SudokuBoard();
            SudokuBoard sudokuBoard2 = new SudokuBoard();
            SudokuBoard sudokuBoard3 = new SudokuBoard();

            //When
            sudokuBoard2.getElement(3, 3).setValue(5);
            fillBoard(sudokuBoard3);

            //Then
            assertFalse(sudokuBoard1.isFull());
            assertFalse(sudokuBoard2.isFull());
            assertTrue(sudokuBoard3.isFull());
        }

        @Test
        void testFindEmptyElements() {
            //Given
            SudokuBoard sudokuBoard1 = new SudokuBoard();
            SudokuBoard sudokuBoard2 = new SudokuBoard();
            SudokuBoard sudokuBoard3 = new SudokuBoard();

            //When
            fillBoard(sudokuBoard2);

            sudokuBoard3.getElement(0, 0).setValue(1);
            sudokuBoard3.getElement(1, 1).setValue(2);
            sudokuBoard3.getElement(2, 2).setValue(3);
            sudokuBoard3.getElement(3, 3).setValue(4);
            sudokuBoard3.getElement(4, 4).setValue(5);
            sudokuBoard3.getElement(5, 5).setValue(6);
            sudokuBoard3.getElement(6, 6).setValue(7);
            sudokuBoard3.getElement(7, 7).setValue(8);

            Coordinates expectedEmptyElement1 = new Coordinates(0, 1);
            Coordinates expectedEmptyElement2 = new Coordinates(8, 8);
            Coordinates expectedNotEmptyElement1 = new Coordinates(1, 1);
            Coordinates expectedNotEmptyElement2 = new Coordinates(7, 7);

            //Then
            assertEquals(81, sudokuBoard1.findEmptyElements().size());
            assertEquals(0, sudokuBoard2.findEmptyElements().size());
            assertEquals(73, sudokuBoard3.findEmptyElements().size());
            assertTrue(sudokuBoard3.findEmptyElements().contains(expectedEmptyElement1));
            assertTrue(sudokuBoard3.findEmptyElements().contains(expectedEmptyElement2));
            assertFalse(sudokuBoard3.findEmptyElements().contains(expectedNotEmptyElement1));
            assertFalse(sudokuBoard3.findEmptyElements().contains(expectedNotEmptyElement2));
        }

        @Test
        void testDeepCopySimple() throws CloneNotSupportedException {
            //Given
            SudokuBoard sudokuBoard1 = new SudokuBoard();

            //When
            SudokuBoard sudokuBoard2 = sudokuBoard1.deepCopy();

            //Then
            assertNotNull(sudokuBoard2);
        }

        @Test
        void testDeepCopyAdvanced() throws CloneNotSupportedException {
            //Given
            SudokuBoard sudokuBoard1 = new SudokuBoard();

            //When
            sudokuBoard1.getElement(1, 1).setValue(2);
            SudokuBoard sudokuBoard2 = sudokuBoard1.deepCopy();
            sudokuBoard1.getElement(2, 2).setValue(3);

            //Then
            assertEquals(2, sudokuBoard1.getElement(1, 1).getValue());
            assertEquals(2, sudokuBoard2.getElement(1, 1).getValue());
            assertEquals(3, sudokuBoard1.getElement(2, 2).getValue());
            assertEquals(SudokuElement.EMPTY, sudokuBoard2.getElement(2, 2).getValue());
        }

        private void fillBoard(SudokuBoard sudokuBoard) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudokuBoard.getElement(i, j).setValue(1);
                }
            }
        }
    }

    @Nested
    class testSudokuGame {

        @Test
        void testRegisterPlayerInput() {
            //Given
            SudokuGame sudokuGame = new SudokuGame();

            //When
            String playerInput1 = "1,2,3";
            String playerInput2 = "5,5,9";

            sudokuGame.registerPlayerInput(playerInput1);
            sudokuGame.registerPlayerInput(playerInput2);

            //Then
            assertEquals(3, sudokuGame.getSudokuBoard().getElement(1, 2).getValue());
            assertEquals(9, sudokuGame.getSudokuBoard().getElement(5, 5).getValue());

        }

        @Test
        void testFindBlock() {
            //Given
            SudokuGame sudokuGame = new SudokuGame();

            //When
            SudokuBlock block1 = sudokuGame.findBlock(0, 1);
            SudokuBlock block2 = sudokuGame.findBlock(1, 4);
            SudokuBlock block3 = sudokuGame.findBlock(2, 8);
            SudokuBlock block4 = sudokuGame.findBlock(3, 0);
            SudokuBlock block5 = sudokuGame.findBlock(4, 5);
            SudokuBlock block6 = sudokuGame.findBlock(5, 6);
            SudokuBlock block7 = sudokuGame.findBlock(6, 2);
            SudokuBlock block8 = sudokuGame.findBlock(7, 3);
            SudokuBlock block9 = sudokuGame.findBlock(8, 7);

            //Then
            assertEquals(SudokuBlock.BLOCK1_1, block1);
            assertEquals(SudokuBlock.BLOCK1_2, block2);
            assertEquals(SudokuBlock.BLOCK1_3, block3);
            assertEquals(SudokuBlock.BLOCK2_1, block4);
            assertEquals(SudokuBlock.BLOCK2_2, block5);
            assertEquals(SudokuBlock.BLOCK2_3, block6);
            assertEquals(SudokuBlock.BLOCK3_1, block7);
            assertEquals(SudokuBlock.BLOCK3_2, block8);
            assertEquals(SudokuBlock.BLOCK3_3, block9);
        }

        @Test
        void testUpdatePossibleValuesRow() {
            //Given
            SudokuGame sudokuGame = new SudokuGame();

            //When
            String playerInput = "3,4,5";
            sudokuGame.registerPlayerInput(playerInput);
            int numberPossibilities1 = sudokuGame.getSudokuBoard().getElement(3, 7).getPossibleValues().size();
            boolean possibleValueRemoved1 = !sudokuGame.getSudokuBoard().getElement(3, 5).getPossibleValues().contains(5);
            int numberPossibilities2 = sudokuGame.getSudokuBoard().getElement(3, 0).getPossibleValues().size();
            boolean possibleValueRemoved2 = !sudokuGame.getSudokuBoard().getElement(3, 0).getPossibleValues().contains(5);

            //Then
            assertEquals(8, numberPossibilities1);
            assertTrue(possibleValueRemoved1);
            assertEquals(8, numberPossibilities2);
            assertTrue(possibleValueRemoved2);
        }

        @Test
        void testUpdatePossibleValuesColumn() {
            //Given
            SudokuGame sudokuGame = new SudokuGame();

            //When
            String playerInput = "3,4,5";
            sudokuGame.registerPlayerInput(playerInput);
            int numberPossibilities1 = sudokuGame.getSudokuBoard().getElement(2, 4).getPossibleValues().size();
            boolean possibleValueRemoved1 = !sudokuGame.getSudokuBoard().getElement(2, 4).getPossibleValues().contains(5);
            int numberPossibilities2 = sudokuGame.getSudokuBoard().getElement(8, 4).getPossibleValues().size();
            boolean possibleValueRemoved2 = !sudokuGame.getSudokuBoard().getElement(8, 4).getPossibleValues().contains(5);

            //Then
            assertEquals(8, numberPossibilities1);
            assertTrue(possibleValueRemoved1);
            assertEquals(8, numberPossibilities2);
            assertTrue(possibleValueRemoved2);
        }

        @Test
        void testUpdatePossibleValuesBlock() {
            //Given
            SudokuGame sudokuGame = new SudokuGame();

            //When
            String playerInput = "3,4,5";
            sudokuGame.registerPlayerInput(playerInput);
            int numberPossibilities1 = sudokuGame.getSudokuBoard().getElement(3, 5).getPossibleValues().size();
            boolean possibleValueRemoved1 = !sudokuGame.getSudokuBoard().getElement(3, 5).getPossibleValues().contains(5);
            int numberPossibilities2 = sudokuGame.getSudokuBoard().getElement(5, 5).getPossibleValues().size();
            boolean possibleValueRemoved2 = !sudokuGame.getSudokuBoard().getElement(5, 5).getPossibleValues().contains(5);

            //Then
            assertEquals(8, numberPossibilities1);
            assertTrue(possibleValueRemoved1);
            assertEquals(8, numberPossibilities2);
            assertTrue(possibleValueRemoved2);
        }

        @Test
        void testCheckOtherElements() {
            //Given
            SudokuGame sudokuGame = new SudokuGame();

            //When
            sudokuGame.registerPlayerInput("0,8,3");
            sudokuGame.registerPlayerInput("1,5,3");
            sudokuGame.registerPlayerInput("4,1,3");
            sudokuGame.registerPlayerInput("8,0,3");

            //Then
            assertTrue(sudokuGame.checkOtherElements(2, 2, 3));
        }

        @Test
        void testGuessMove() {
            //Given
            SudokuGame sudokuGame = new SudokuGame();

            //When
            sudokuGame.guessMove();

            //Then
            assertEquals(80, sudokuGame.getSudokuBoard().findEmptyElements().size());
            assertEquals(1, sudokuGame.getBacktrack().size());
        }

        @Test
        void testSaveBacktrack() throws CloneNotSupportedException {
            //Given
            SudokuGame sudokuGame = new SudokuGame();

            //When
            sudokuGame.registerPlayerInput("1,1,2");
            sudokuGame.saveBacktrack(sudokuGame.getSudokuBoard(), new Coordinates(5, 5), 7);
            sudokuGame.registerPlayerInput("8,8,9");

            int value1 = sudokuGame.getBacktrack().get(0).getSudokuBoard().getElement(1, 1).getValue();
            int value2 = sudokuGame.getSudokuBoard().getElement(8, 8).getValue();
            Coordinates savedCoordinates = sudokuGame.getBacktrack().get(0).getGuessedValueCoordinates();
            int guessedValue = sudokuGame.getBacktrack().get(0).getGuessedValue();
            int expectedEmpty = sudokuGame.getBacktrack().get(0).getSudokuBoard().getElement(8, 8).getValue();

            //Then
            assertEquals(1, sudokuGame.getBacktrack().size());
            assertEquals(2, value1);
            assertEquals(new Coordinates(5, 5), savedCoordinates);
            assertEquals(7, guessedValue);
            assertEquals(9, value2);
            assertEquals(SudokuElement.EMPTY, expectedEmpty);
        }

        @Test
        void testLoadBacktrack() throws CloneNotSupportedException {
            //Given
            SudokuGame sudokuGame = new SudokuGame();

            //When
            sudokuGame.registerPlayerInput("1,1,2");
            sudokuGame.saveBacktrack(sudokuGame.getSudokuBoard(), new Coordinates(5, 5), 7);
            sudokuGame.registerPlayerInput("8,8,9");
            sudokuGame.loadBacktrack();

            int expectedValue = sudokuGame.getSudokuBoard().getElement(1, 1).getValue();
            int expectedEmpty = sudokuGame.getSudokuBoard().getElement(8, 8).getValue();

            //Then
            assertEquals(2, expectedValue);
            assertEquals(SudokuElement.EMPTY, expectedEmpty);
            assertFalse(sudokuGame.getSudokuBoard().getElement(5, 5).getPossibleValues().contains(7));
            assertEquals(0, sudokuGame.getBacktrack().size());
        }

        @Test
        void testSolveTheGameNoGuessing() {
            //Given
            SudokuGame sudokuGame = generateSolvableSudokuEasy();

            //When
            List<Integer> possibleValues1 = sudokuGame.getSudokuBoard().getElement(3,3).getPossibleValues();
            List<Integer> expectedList1 = new ArrayList<>();
            expectedList1.add(5);
            expectedList1.add(8);
            expectedList1.add(9);

            List<Integer> possibleValues2= sudokuGame.getSudokuBoard().getElement(4,7).getPossibleValues();
            List<Integer> expectedList2 = new ArrayList<>();
            expectedList2.add(6);
            expectedList2.add(8);
            expectedList2.add(9);

            List<Integer> possibleValues3= sudokuGame.getSudokuBoard().getElement(7,4).getPossibleValues();
            List<Integer> expectedList3 = new ArrayList<>();
            expectedList3.add(1);


            //Then
            assertEquals(expectedList1, possibleValues1);
            assertEquals(expectedList2, possibleValues2);
            assertEquals(expectedList3, possibleValues3);
            sudokuGame.solveTheGame();
        }

        @Test
        void testSolveSudokuWithGuessing() {
            //Given
            SudokuGame sudokuGame = generateSolvableSudokuHard();

            //When
            //Then
            sudokuGame.solveTheGame();
        }

        private SudokuGame generateSolvableSudokuEasy() {

            SudokuGame sudokuGame = new SudokuGame();

            sudokuGame.registerPlayerInput("1,0,9");
            sudokuGame.registerPlayerInput("1,1,8");
            sudokuGame.registerPlayerInput("2,1,1");
            sudokuGame.registerPlayerInput("2,2,3");

            sudokuGame.registerPlayerInput("0,3,4");
            sudokuGame.registerPlayerInput("0,4,6");
            sudokuGame.registerPlayerInput("1,4,5");
            sudokuGame.registerPlayerInput("1,5,1");
            sudokuGame.registerPlayerInput("2,3,2");
            sudokuGame.registerPlayerInput("2,4,8");

            sudokuGame.registerPlayerInput("0,7,3");
            sudokuGame.registerPlayerInput("1,6,6");
            sudokuGame.registerPlayerInput("1,7,7");
            sudokuGame.registerPlayerInput("1,8,2");

            sudokuGame.registerPlayerInput("3,0,1");
            sudokuGame.registerPlayerInput("4,2,5");
            sudokuGame.registerPlayerInput("5,0,8");

            sudokuGame.registerPlayerInput("3,5,3");
            sudokuGame.registerPlayerInput("4,3,1");
            sudokuGame.registerPlayerInput("4,4,2");
            sudokuGame.registerPlayerInput("5,4,4");

            sudokuGame.registerPlayerInput("3,6,2");
            sudokuGame.registerPlayerInput("3,8,4");
            sudokuGame.registerPlayerInput("4,6,3");
            sudokuGame.registerPlayerInput("5,7,5");
            sudokuGame.registerPlayerInput("5,8,7");

            sudokuGame.registerPlayerInput("7,0,4");
            sudokuGame.registerPlayerInput("7,1,2");
            sudokuGame.registerPlayerInput("7,2,9");
            sudokuGame.registerPlayerInput("8,1,6");
            sudokuGame.registerPlayerInput("8,2,1");

            sudokuGame.registerPlayerInput("6,3,6");
            sudokuGame.registerPlayerInput("6,4,9");
            sudokuGame.registerPlayerInput("8,3,7");
            sudokuGame.registerPlayerInput("8,5,4");

            sudokuGame.registerPlayerInput("6,6,4");
            sudokuGame.registerPlayerInput("6,7,1");
            sudokuGame.registerPlayerInput("7,8,3");

            return sudokuGame;
        }

        private SudokuGame generateSolvableSudokuHard() {

            SudokuGame sudokuGame = new SudokuGame();

            sudokuGame.registerPlayerInput("0,2,4");
            sudokuGame.registerPlayerInput("1,1,1");
            sudokuGame.registerPlayerInput("2,0,5");

            sudokuGame.registerPlayerInput("2,3,4");
            sudokuGame.registerPlayerInput("0,4,1");
            sudokuGame.registerPlayerInput("1,4,2");
            sudokuGame.registerPlayerInput("2,5,3");

            sudokuGame.registerPlayerInput("0,6,5");
            sudokuGame.registerPlayerInput("1,7,3");
            sudokuGame.registerPlayerInput("2,8,2");

            sudokuGame.registerPlayerInput("3,2,2");
            sudokuGame.registerPlayerInput("4,0,7");
            sudokuGame.registerPlayerInput("4,1,8");
            sudokuGame.registerPlayerInput("5,2,5");

            sudokuGame.registerPlayerInput("4,4,9");

            sudokuGame.registerPlayerInput("3,6,6");
            sudokuGame.registerPlayerInput("4,7,4");
            sudokuGame.registerPlayerInput("4,8,5");
            sudokuGame.registerPlayerInput("5,6,7");

            sudokuGame.registerPlayerInput("6,0,9");
            sudokuGame.registerPlayerInput("7,1,7");
            sudokuGame.registerPlayerInput("8,2,8");

            sudokuGame.registerPlayerInput("6,3,8");
            sudokuGame.registerPlayerInput("6,5,1");
            sudokuGame.registerPlayerInput("7,4,6");
            sudokuGame.registerPlayerInput("8,4,4");

            sudokuGame.registerPlayerInput("6,8,6");
            sudokuGame.registerPlayerInput("7,7,5");
            sudokuGame.registerPlayerInput("8,6,9");

            return sudokuGame;
        }

    }
}

