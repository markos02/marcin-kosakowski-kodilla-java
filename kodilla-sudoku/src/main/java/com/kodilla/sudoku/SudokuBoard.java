package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype<SudokuBoard> {

    private List<SudokuRow> sudokuRows;

    public SudokuBoard() {
        this.sudokuRows = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            sudokuRows.add(new SudokuRow());
        }
    }

    public SudokuElement getElement(int row, int column) {

        if (row < 0 || row > 8) {
            throw new IllegalArgumentException("Row number must be between 0 and 8");
        }

        if (column < 0 || column > 8) {
            throw new IllegalArgumentException("Column number must be between 0 and 8");
        }

        return sudokuRows.get(row).getSudokuRow().get(column);
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    public boolean isFull() {
        for (SudokuRow row : sudokuRows) {
            for (SudokuElement element : row.getSudokuRow()) {
                if (element.getValue() == SudokuElement.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Coordinates> findEmptyElements() {

        List<Coordinates> emptyElements = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (getElement(row, column).getValue() == SudokuElement.EMPTY) {
                    emptyElements.add(new Coordinates(row, column));
                }
            }
        }

        return emptyElements;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {

        SudokuBoard clonedSudokuBoard = super.clone();

        clonedSudokuBoard.setSudokuRows(new ArrayList<>());

        for (SudokuRow sudokuRow : sudokuRows) {
            SudokuRow clonedSudokuRow = sudokuRow.deepCopy();
            clonedSudokuBoard.getSudokuRows().add(clonedSudokuRow);
        }
        return clonedSudokuBoard;
    }

    public void setSudokuRows(List<SudokuRow> sudokuRows) {
        this.sudokuRows = sudokuRows;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();
        string.append("-------------\n");

        for (int i = 0; i < sudokuRows.size(); i++) {

            string.append(sudokuRows.get(i)).append("\n");

            if ((i % 3) == 2) {
                string.append("-------------\n");
            }
        }

        return string.toString();
    }
}
