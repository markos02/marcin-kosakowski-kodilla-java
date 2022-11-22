package com.kodilla.sudoku;

public class SudokuBacktrack {

    private final SudokuBoard sudokuBoard;
    private final Coordinates guessedValueCoordinates;
    private final int guessedValue;

    public SudokuBacktrack(SudokuBoard sudokuBoard, Coordinates coordinates, int guessedValue) {
        this.sudokuBoard = sudokuBoard;
        this.guessedValueCoordinates = coordinates;
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public Coordinates getGuessedValueCoordinates() {
        return guessedValueCoordinates;
    }

    public int getGuessedValue() {
        return guessedValue;
    }
}
