package main.java.ch.controller;

public class SudokuSolver {

    public int[][] loaderSudoku;
    public int[][] solvedSudoku;
    private int gridSizeSudoku;
    private int row = 0;
    private int col = 0;


    // This is the method that is used by the gui
    public int[][] startSolvingSudoku(int[][] puzzleToSolve) {
        loaderSudoku = puzzleToSolve;
        gridSizeSudoku = loaderSudoku.length;
        solver();
        return solvedSudoku;
    }

    private boolean isSudokuFullyFilledOut(int gridSize, int[][] loader) {
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                if (loader[x][y] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // Check if the actual position is Valid
    public int[] possibleEntries() {
        int[] possibilityArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        // Check if the horizontal row and if the vertical col is valid
        possibilityArray = checkIfHorizontalIsValid(possibilityArray, gridSizeSudoku);
        possibilityArray = checkIfVerticalIsValid(possibilityArray, gridSizeSudoku);

        // Check if the 3x3 Sudoku rule is valid
        possibilityArray = isTheThreeByThreeRuleValid(getTheThreeByTreeGrid(row), getTheThreeByTreeGrid(col), possibilityArray);

        // Change the array to the possible numbers
        possibilityArray = changeToPossibleNumbers(possibilityArray);
        return possibilityArray;

    }

    private int[] changeToPossibleNumbers(int[] possibilityArray) {
        int ConversionPossibilityArray = 1;
        for (int i = 0; i < gridSizeSudoku; i++) {
            if (possibilityArray[i] == 1) {
                possibilityArray[i] = 0;
            } else {
                possibilityArray[i] = ConversionPossibilityArray;
            }
            ConversionPossibilityArray++;
        }

        return possibilityArray;
    }

    private int[] isTheThreeByThreeRuleValid(int threeByThreeRow, int threeByThreeCol, int[] possibilityArray) {
        int loader;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                loader = loaderSudoku[threeByThreeRow + row][threeByThreeCol + col];

                if (loader != 0) {
                    for (int a = 1; a < 10; a++) {
                        if (loader == a) {
                            possibilityArray[a - 1] = 1;
                            break;
                        }
                    }
                }
            }
        }
        return possibilityArray;
    }

    private int[] checkIfVerticalIsValid(int[] possibilityArray, int gridSize) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 1; j < 10; j++) {
                if (loaderSudoku[i][col] == j) {
                    possibilityArray[j - 1] = 1;
                }
            }
        }

        return possibilityArray;
    }

    private int[] checkIfHorizontalIsValid(int[] possibilityArray, int gridSize) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 1; j < 10; j++) {
                if (loaderSudoku[row][i] == j) {
                    possibilityArray[j - 1] = 1;
                }
            }
        }

        return possibilityArray;
    }

    private int getTheThreeByTreeGrid(int number) {
        if (number >= 0 && number <= 2) {
            return 0;
        } else if (number >= 3 && number <= 5) {
            return 3;
        } else {
            return 6;
        }
    }

    public boolean solver() {
        int rowsolver = 0;
        int colsolver = 0;
        int[] possibilityArraySolver = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        if (isSudokuFullyFilledOut(gridSizeSudoku, loaderSudoku)) {
            // this is the place where the solved sudoku goes to the Gui
            solvedSudoku = loaderSudoku;
            return true;

        } else {
            search:
            {
                // detect first empty field
                for (int x = 0; x < gridSizeSudoku; x++) {
                    for (int y = 0; y < gridSizeSudoku; y++) {
                        if (loaderSudoku[x][y] == 0) {
                            row = x;
                            col = y;
                            break search;
                        }
                    }
                }
            }

            rowsolver = row;
            colsolver = col;

            possibilityArraySolver = possibleEntries();

            for (int i = 0; i < gridSizeSudoku; i++) {
                if (isSudokuFullyFilledOut(gridSizeSudoku, loaderSudoku)) {
                    break;
                }

                if (possibilityArraySolver[i] != 0) {
                    loaderSudoku[rowsolver][colsolver] = possibilityArraySolver[i];
                    // ToDo get out of the loop when solver returns true
                    solver();

                } else if (i == 8) {
                    loaderSudoku[rowsolver][colsolver] = 0;
                }
            }
        }

        return false;
    }
}