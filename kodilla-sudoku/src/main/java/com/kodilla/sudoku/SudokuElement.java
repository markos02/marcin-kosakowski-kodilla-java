package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuElement extends Prototype<SudokuElement> {

    public static int EMPTY = -1;
    private int value;
    private List<Integer> possibleValues;

    public SudokuElement() {
        this.value = EMPTY;
        possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public void removePossibleValue(int value) throws UnsolvableSudokuException {
        possibleValues.remove(Integer.valueOf(value));
        if ((getValue() == EMPTY) && (getPossibleValues().size() == 0)) {
            throw new UnsolvableSudokuException();
        }
    }

    public SudokuElement deepCopy() throws CloneNotSupportedException {
        SudokuElement clonedElement = super.clone();
        clonedElement.possibleValues = new ArrayList<>();

        for (Integer value : possibleValues) {
            clonedElement.getPossibleValues().add(value);
        }
        return clonedElement;
    }

    public int getValue() {
        return value;
    }

    public boolean setValue(int value) {

        if (this.value != EMPTY) {
            System.out.println("Element is not empty");
            return false;
        }

        if (value < 1 || value > 9) {
            System.out.println("Value must be a number between 1 and 9");
            return false;
        }

        if (possibleValues.contains(value)) {
            this.value = value;
            this.possibleValues.clear();
            return true;
        } else {
            System.out.println("It is not possible to set " + value + " in this element");
            return false;
        }
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }


    @Override
    public String toString() {
        if (value == EMPTY) {
            return " ";
        }
        return String.valueOf(value);
    }
}
