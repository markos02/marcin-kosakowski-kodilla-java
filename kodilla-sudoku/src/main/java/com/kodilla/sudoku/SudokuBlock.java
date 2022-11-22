package com.kodilla.sudoku;

import java.util.Arrays;
import java.util.List;

public enum SudokuBlock {

    BLOCK1_1 (Arrays.asList(0,1,2), Arrays.asList(0,1,2)),
    BLOCK1_2 (Arrays.asList(0,1,2), Arrays.asList(3,4,5)),
    BLOCK1_3 (Arrays.asList(0,1,2), Arrays.asList(6,7,8)),
    BLOCK2_1 (Arrays.asList(3,4,5), Arrays.asList(0,1,2)),
    BLOCK2_2 (Arrays.asList(3,4,5), Arrays.asList(3,4,5)),
    BLOCK2_3 (Arrays.asList(3,4,5), Arrays.asList(6,7,8)),
    BLOCK3_1 (Arrays.asList(6,7,8), Arrays.asList(0,1,2)),
    BLOCK3_2 (Arrays.asList(6,7,8), Arrays.asList(3,4,5)),
    BLOCK3_3 (Arrays.asList(6,7,8), Arrays.asList(6,7,8));

    private final List<Integer> rows;
    private final List<Integer> columns;

    SudokuBlock(List<Integer> rows, List<Integer> columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public List<Integer> getRows() {
        return rows;
    }

    public List<Integer> getColumns() {
        return columns;
    }
}
