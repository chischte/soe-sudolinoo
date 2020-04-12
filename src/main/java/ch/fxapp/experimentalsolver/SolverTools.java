package main.java.ch.fxapp.experimentalsolver;

public class SolverTools {
    // This is an array containing an object for every sudoku field
    private FieldAsClass[] fieldAsClassArray = new FieldAsClass[81];
    private int[][] unsolvedSudoku = new int[9][9];
    private int sudokuLength = unsolvedSudoku.length;
    private int noOfFields = (unsolvedSudoku.length) ^ 2;


    public void configureAllFields(int[][] sudokuArray) {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {

                // Calculate current field number (0-80)
                int currentFieldNo = row * sudokuLength + col;

                // Initialize a new object in fieldAsClassArray:
                fieldAsClassArray[currentFieldNo] = new FieldAsClass();

                // Get current field parameters
                int currentSector = findOutSector(row, col);
                int currentValue = sudokuArray[row][col];

                // Asign parameters to field:
                fieldAsClassArray[currentFieldNo].setRowNo(row);
                fieldAsClassArray[currentFieldNo].setColumNo(col);
                fieldAsClassArray[currentFieldNo].setSectorNo(currentSector);

                // Mark fields with a number other than 0 as solved
                if (currentValue != 0) {
                    fieldAsClassArray[currentFieldNo].setSolved();
                    fieldAsClassArray[currentFieldNo].setFieldValue(currentValue);
                }
                fieldAsClassArray[currentFieldNo].printFieldInfo();
            }
        }
    }

    public void removeSolvedNumbersFromOtherFields() {
        for (int solvedField = 0; solvedField < noOfFields; solvedField++) {
            if (fieldAsClassArray[solvedField].isSolved()) {
                for (int clearField = 0; clearField < noOfFields; clearField++) {
                    boolean possibilityShouldBeCleared = false;
                    // Check if field is in same row
                    if (fieldAsClassArray[solvedField].getRowNo() == fieldAsClassArray[clearField].getRowNo()) {
                        possibilityShouldBeCleared = true;
                    }
                    // Check if field is in same column
                    else if (fieldAsClassArray[solvedField].getColumnNo() == fieldAsClassArray[clearField].getColumnNo()) {
                        possibilityShouldBeCleared = true;
                    }
                    // Check if field is in same sector
                    else if (fieldAsClassArray[solvedField].getSectorNo() == fieldAsClassArray[clearField].getSectorNo()) {
                        possibilityShouldBeCleared = true;
                    }
                    // If one of the sudoku rules applies, clear possibility from field
                    if (possibilityShouldBeCleared) {
                        fieldAsClassArray[clearField].removePossibleNo(fieldAsClassArray[solvedField].getFieldValue());
                    }
                    fieldAsClassArray[clearField].printFieldInfo();
                }

            }

        }
    }


    private int findOutSector(int row, int col) {
        int sector;
        if (col < 3) {
            sector = 1;
        } else if (col < 6) {
            sector = 2;
        } else {
            sector = 3;
        }
        if (row < 3) {
            sector += 0;
        } else if (row < 6) {
            sector += 3;
        } else {
            sector += 6;
        }

        return sector;
    }


}
