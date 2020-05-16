/**
 * The brain of the logic behind the whole solver
 * This class is providing all the needed steps to solve a sudoku
 * the methods for example the 3by3 check are all in encapsulated for later use
 * <p>
 * This class is multiple times refactored.
 *
 * @author Joel Iselin
 * @author Roland Jaggi
 * @version 0.5
 * @since 03.05.2020
 */

package main.java.ch.solverbacktracking;

public class SudokuSolver {
    public int[][] loaderSudoku;
    public int[][] solvedSudoku;
    private int gridSizeSudoku;
    private int row = 0;
    private int col = 0;

    /**
     * This is the method that is used by the gui
     * @param puzzleToSolve
     * @return returns a int array with the solved sudoku
     */
    public int[][] startSolvingSudoku(int[][] puzzleToSolve) {
        loaderSudoku = puzzleToSolve;
        gridSizeSudoku = loaderSudoku.length;
        if (solver()) {
            return solvedSudoku;
        }

        return loaderSudoku;
    }

    /**
     * Checks if all of the fields are filled out
     * @param gridSize size is normaly in a sudoku 9by9 but we can extend or decrease it with that
     * @param loader is the filled out array of the sudoku
     * @return true/false
     */
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

    /**
     * Check if the actual position is valid. It means that not a number can not be twice or more in the same row
     * It checks also all the other rules
     * @return returns the int[][] array with all the correct numbers in it
     */
    public int[] checkAllTheSudokuRulesOfTheEntries() {
        int[] possibilityArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        // Check if the 3x3 Sudoku rule is valid
        possibilityArray = isTheThreeByThreeRuleValid(getTheThreeByThreeGrid(row), getTheThreeByThreeGrid(col), possibilityArray);

        // Check if the horizontal row and if the vertical col is valid
        possibilityArray = checkIfHorizontalIsValid(possibilityArray, gridSizeSudoku);
        possibilityArray = checkIfVerticalIsValid(possibilityArray, gridSizeSudoku);

        // Change the array to the possible numbers
        possibilityArray = changeToPossibleNumbers(possibilityArray);

        return possibilityArray;
    }

    /**
     * This method provides a change if a number is incorrect in this segment of the sudoku
     * @param possibilityArray
     * @return possibilityArray
     */
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

    /**
     * This is one of a kind. It checks if the number 1 to 9 are in and no multipliers in the 3by 3 grid
     * @param threeByThreeRow
     * @param threeByThreeCol
     * @param possibilityArray
     * @return possibilityArray
     */
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

    /**
     * This method provides if the vertical line contains only the number 1 to 9 and no multipliers
     * @param possibilityArray
     * @param gridSize
     * @return possibilityArray
     */
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

    /**
     * This method provides if the horizontal line contains only the number 1 to 9 and no multipliers
     * @param possibilityArray
     * @param gridSize
     * @return possibilityArray
     */
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

    private int getTheThreeByThreeGrid(int number) {
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
                            rowsolver = x;
                            colsolver = y;
                            break search;
                        }
                    }
                }
            }

            row = rowsolver;
            col = colsolver;

            possibilityArraySolver = checkAllTheSudokuRulesOfTheEntries();

            try {
                // It needs to be equal to the size of the Sudoku length otherwise the last field could not be check by all the Sudoku rules
                for (int i = 0; i < 10; i++) {
                    if (isSudokuFullyFilledOut(gridSizeSudoku, loaderSudoku)) {
                        break;
                    }

                    if (i < 9 && possibilityArraySolver[i] != 0) {
                        loaderSudoku[rowsolver][colsolver] = possibilityArraySolver[i];
                        // ToDo get out of the loop when solver returns true
                        solver();

                    } else if (i == 8 || i == 9) {
                        loaderSudoku[rowsolver][colsolver] = 0;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return false;
    }
}