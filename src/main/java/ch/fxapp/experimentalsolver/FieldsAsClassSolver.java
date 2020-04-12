package main.java.ch.fxapp.experimentalsolver;

public class FieldsAsClassSolver {
    // This is an array containing an object for every sudoku field
    static FieldAsClass[] fieldAsClassArray = new FieldAsClass[81];

    static int puzzle[][] = {
            {8, 0, 1, 0, 0, 3, 9, 0, 6},
            {0, 0, 9, 0, 0, 7, 8, 5, 0},
            {2, 5, 0, 1, 0, 0, 4, 7, 0},
            {5, 0, 0, 0, 6, 1, 7, 0, 4},
            {7, 6, 0, 8, 3, 0, 0, 0, 0},
            {0, 3, 2, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 1, 9, 5, 0, 0},
            {0, 0, 5, 0, 0, 0, 3, 0, 2},
            {0, 0, 0, 4, 5, 2, 1, 9, 7}
    };

    static int[][] unsolvedSudoku = new int[9][9];
    static int sudokuLength = unsolvedSudoku.length;

    public static void main(String[] args) {
        configureAllFields(puzzle);
    }


    // CONFIGURE ALL FIELDS
    public static void configureAllFields(int[][] sudokuArray) {
        int currentSector = 1; //there are 9 sectors
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                if (col < 3) {
                    currentSector = 1;
                } else if (col < 6) {
                    currentSector = 2;
                } else {
                    currentSector = 3;
                }
                if (row < 3) {
                    currentSector += 0;
                } else if (row < 6) {
                    currentSector += 3;
                } else {
                    currentSector += 6;
                }
                int currentValue = sudokuArray[row][col];
                int currentField = row * sudokuLength + col;
                fieldAsClassArray[currentField] = new FieldAsClass();
                fieldAsClassArray[currentField].setSectorNo(currentSector);
                if (currentValue != 0) {
                    fieldAsClassArray[currentField].setSolved(true);
                    fieldAsClassArray[currentField].setFieldValue(currentValue);
                } else {
                    fieldAsClassArray[currentField].setSolved(false);
                }

            }
        }
    }

    //REMOVE POSSIBILITIES IN ROW

    //REMOVE POSSIBILITIES IN COLUMN

    // REMOVE POSSIBILITIES IN SECTOR

    // FIND FIELD WITH THE LEAST POSSIBILITIES
    // ...SELECT A NUMBER
    // ...AND MARE IT "SOLVED"

    // CHECK IF ALL FIELDS ARE SOLVED
    // ...AND REPEAT UNTIL ALL FIELDS ARE SOLVED

    // WRITE ARRAY OF OBJECTS TO SOLVED SUDOKU ARRAY
    // ...RETURN THE SOLVED SUDOK ARRAY


}
