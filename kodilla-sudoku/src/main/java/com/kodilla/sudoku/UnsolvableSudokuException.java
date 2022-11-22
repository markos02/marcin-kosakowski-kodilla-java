package com.kodilla.sudoku;

public class UnsolvableSudokuException extends Exception{

    public UnsolvableSudokuException() {
        super("Sudoku is unsolvable");
    }
}
