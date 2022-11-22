package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SudokuGame {

    private SudokuBoard sudokuBoard;
    private final List<SudokuBacktrack> backtrack;
    private Scanner scanner = new Scanner(System.in);

    public SudokuGame() {
        this.sudokuBoard = new SudokuBoard();
        this.backtrack = new ArrayList<>();
    }

    public boolean resolveSudoku() {

        fillSudokuBoard();

        solveTheGame();

        System.out.print("Press any key to continue . . . ");
        scanner.nextLine();
        scanner.nextLine();

        System.out.println("Do you want to resolve new Sudoku? [y/n]: ");
        String nextSudoku = scanner.next();

        return nextSudoku.equals("n");
    }

    public void solveTheGame() {

        boolean boardIsFull = false;
        int operationsPerformed;

        while (!boardIsFull) {

            operationsPerformed = 0;

            for (int row = 0; row < 9; row++) {
                for (int column = 0; column < 9; column++) {

                    SudokuElement element = sudokuBoard.getElement(row, column);
                    List<Integer> possibleValues = element.getPossibleValues();


                    int foundValue = 0;

                    if (element.getValue() == SudokuElement.EMPTY) {

                        if (possibleValues.size() == 1) {
                            foundValue = possibleValues.get(0);
                        } else {
                            for (int value : possibleValues) {
                                if (checkOtherElements(row, column, value)) {
                                    foundValue = value;
                                    break;
                                }
                            }
                        }

                        if (foundValue != 0) {
                            if (element.setValue(foundValue)) {
                                updatePossibleValues(row, column, foundValue);
                                operationsPerformed++;
                            }


                        }
                    }
                }
            }

            if (operationsPerformed == 0) {
                guessMove();
            }
            boardIsFull = sudokuBoard.isFull();
        }

        finishSudoku(true);

    }

    private void finishSudoku(boolean solved) {

        if (solved) {
            System.out.println("Sudoku is solved!:\n");
        } else {
            System.out.println("Sudoku is unsolvable:\n");
        }

        System.out.println(sudokuBoard);

    }

    public void guessMove() {

        System.out.println("Trying to guess a move");
        Random random = new Random();

        List<Coordinates> emptyElements = sudokuBoard.findEmptyElements();
        Coordinates randomCoordinates = emptyElements.get(random.nextInt(emptyElements.size()));
        SudokuElement randomElement = sudokuBoard.getElement(randomCoordinates.getRow(), randomCoordinates.getColumn());
        List<Integer> possibleValues = randomElement.getPossibleValues();
        int randomValue = possibleValues.get(random.nextInt(possibleValues.size()));

        try {
            saveBacktrack(sudokuBoard.deepCopy(), randomCoordinates, randomValue);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        randomElement.setValue(randomValue);
        updatePossibleValues(randomCoordinates.getRow(), randomCoordinates.getColumn(), randomValue);

    }

    public void saveBacktrack(SudokuBoard sudokuBoard, Coordinates Coordinates, int Value) throws CloneNotSupportedException {
        backtrack.add(new SudokuBacktrack(sudokuBoard.deepCopy(), Coordinates, Value));
    }

    public void loadBacktrack() {

        if (backtrack.size() == 0) {
            finishSudoku(false);
        }

        SudokuBacktrack lastBacktrack = backtrack.get(backtrack.size() - 1);

        try {
            sudokuBoard = lastBacktrack.getSudokuBoard().deepCopy();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        int removeRow = lastBacktrack.getGuessedValueCoordinates().getRow();
        int removeColumn = lastBacktrack.getGuessedValueCoordinates().getColumn();
        int removeValue = lastBacktrack.getGuessedValue();

        try {
            sudokuBoard.getElement(removeRow, removeColumn).removePossibleValue(removeValue);
        } catch (UnsolvableSudokuException e) {
            finishSudoku(false);
        }

        backtrack.remove(backtrack.size() - 1);

    }

    public boolean checkOtherElements(int row, int column, int value) {

        int counterRows = 0;
        int counterColumns = 0;
        int counterBlock = 0;


        //Check if value is possible in another element in a row
        for (int i = 0; i < 9; i++) {
            if (sudokuBoard.getElement(row, i).getPossibleValues().contains(value)) {
                counterRows++;
            }
        }

        //Check if value is possible in another element in a column
        for (int i = 0; i < 9; i++) {
            if (sudokuBoard.getElement(i, column).getPossibleValues().contains(value)) {
                counterColumns++;
            }
        }

        //Check if value is possible in another element in a block
        SudokuBlock block = findBlock(row, column);

        for (int brow : block.getRows()) {
            for (int bcolumn : block.getColumns()) {
                if (sudokuBoard.getElement(brow, bcolumn).getPossibleValues().contains(value)) {
                    counterBlock++;
                }
            }
        }

        return counterRows == 1 && counterColumns == 1 && counterBlock == 1;

    }

    public void fillSudokuBoard() {

        boolean finishedFilling = false;
        String input;

        while (!finishedFilling) {

            System.out.println(sudokuBoard);

            System.out.println("""

                    Write SUDOKU to solve the game
                    Write [row, column, value] to set value
                    """
            );

            input = scanner.next();

            if (input.equals("SUDOKU") || input.equals("sudoku")) {
                finishedFilling = true;
            } else {
                registerPlayerInput(input);
            }
        }
    }

    public void registerPlayerInput(String input) {

        String[] inputSplit = input.split(",");
        int row = Integer.parseInt(inputSplit[0]);
        int column = Integer.parseInt(inputSplit[1]);
        int value = Integer.parseInt(inputSplit[2]);

        try {
            if (sudokuBoard.getElement(row, column).setValue(value)) {
                updatePossibleValues(row, column, value);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    public void updatePossibleValues(int row, int column, int value) {

        try {

            //Update possible values in a row
            for (int i = 0; i < 9; i++) {
                sudokuBoard.getElement(row, i).removePossibleValue(value);
            }

            //Update possible values in a column
            for (int i = 0; i < 9; i++) {
                sudokuBoard.getElement(i, column).removePossibleValue(value);
            }

            //Update possible values in a block
            SudokuBlock block = findBlock(row, column);

            for (int brow : block.getRows()) {
                for (int bcolumn : block.getColumns()) {
                    sudokuBoard.getElement(brow, bcolumn).removePossibleValue(value);
                }
            }
        } catch (UnsolvableSudokuException e) {
            loadBacktrack();
        } catch (IllegalArgumentException ignored) {
        }
    }

    public SudokuBlock findBlock(int row, int column) {

        if (row < 3) {
            if (column < 3) {
                return SudokuBlock.BLOCK1_1;
            }
            if (column < 6) {
                return SudokuBlock.BLOCK1_2;
            }
            return SudokuBlock.BLOCK1_3;
        }

        if (row < 6) {
            if (column < 3) {
                return SudokuBlock.BLOCK2_1;
            }
            if (column < 6) {
                return SudokuBlock.BLOCK2_2;
            }
            return SudokuBlock.BLOCK2_3;
        }

        if (column < 3) {
            return SudokuBlock.BLOCK3_1;
        }

        if (column < 6) {
            return SudokuBlock.BLOCK3_2;
        }

        return SudokuBlock.BLOCK3_3;

    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public List<SudokuBacktrack> getBacktrack() {
        return backtrack;
    }
}