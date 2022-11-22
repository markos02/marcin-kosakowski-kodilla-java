package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow extends Prototype<SudokuRow> {

    private List<SudokuElement> sudokuRow;

    public SudokuRow() {
        this.sudokuRow = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            sudokuRow.add(new SudokuElement());
        }
    }

    public SudokuRow deepCopy() throws CloneNotSupportedException {

        SudokuRow clonedSudokuRow = super.clone();
        clonedSudokuRow.sudokuRow = new ArrayList<>();

        for (SudokuElement element : sudokuRow) {
            clonedSudokuRow.getSudokuRow().add(element.deepCopy());
        }

        return clonedSudokuRow;
    }

    public List<SudokuElement> getSudokuRow() {
        return sudokuRow;
    }


    @Override
    public String toString() {

        StringBuilder string = new StringBuilder("|");

        for (int i = 0; i < sudokuRow.size(); i++) {

            string.append(sudokuRow.get(i));

            if ((i % 3) == 2) {
                string.append("|");
            }
        }
        return string.toString();
    }
}
