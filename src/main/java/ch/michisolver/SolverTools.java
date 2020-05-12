package main.java.ch.michisolver;

public class SolverTools {
    //TODO: check if different tool classes make sense or rename to Tool ("SudokuInitializer...)
    // This is an array containing an object for every sudoku field
    private final int gridLength = 9; // A sudoku has a grid length of 9 Fields
    private final int noOfFields = 81; // A sudoku has 81 fields
    private int[][] unsolvedSudoku = new int[gridLength][gridLength];
    private Field[] fieldArray = new Field[noOfFields];


    public void configureAllFields(int[][] sudokuArray) {
        // store initial sudoku in case solver has to restart:
        unsolvedSudoku = sudokuArray;
        for (int row = 0; row < gridLength; row++) {
            for (int col = 0; col < gridLength; col++) {

                // Initialize a new object in fieldAsClassArray:
                Field currentField = new Field();

                // Configure current Field:
                currentField.setRowNo(row);
                currentField.setColumnNo(col);
                currentField.setSectorNo(getSector(row, col));

                int currentValue = sudokuArray[row][col];
                if (currentValue != 0) {
                    currentField.setSolved();
                    currentField.setFieldValue(currentValue);
                }
                // Add current field to fieldArray:
                addFieldToFieldArray(row, col, currentField);
            }
        }
    }

    private void addFieldToFieldArray(int row, int col, Field field) {
        int fieldNo = calculateFieldNo(row, col);
        fieldArray[fieldNo] = field;
    }

    private int calculateFieldNo(int row, int col) {
        int fieldNo = row * gridLength + col;
        return fieldNo;
    }

    private int getSector(int row, int col) {
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

    public void removeSolvedNumbersFromOtherFields() {
        // Search solved fields in all fields
        for (int fieldNo = 0; fieldNo < noOfFields; fieldNo++) {
            Field currentField = fieldArray[fieldNo];
            if (fieldIsSolvedAndUnprocessed(currentField)) {
                clearNumberFromRelatedFields(currentField);
                currentField.setProcessed();
            }
        }
    }

    void clearNumberFromRelatedFields(Field solvedField) {
        for (int fieldNo = 0; fieldNo < noOfFields; fieldNo++) {
            Field currentField = fieldArray[fieldNo];
            if (fieldsAreRelated(solvedField, currentField)) {
                removePossibilityFromField(solvedField, currentField);
            }
        }
    }

    boolean fieldsAreRelated(Field fieldA, Field fieldB) {
        if (fieldA.getColumnNo() == fieldB.getColumnNo()) {
            return true;
        }
        if (fieldA.getRowNo() == fieldB.getRowNo()) {
            return true;
        }
        if (fieldA.getSectorNo() == fieldB.getSectorNo()) {
            return true;
        }
        return false;
    }

    void removePossibilityFromField(Field solvedField, Field otherField) {
        otherField.removePossibleNo(solvedField.getFieldValue());
    }

    private boolean fieldIsSolvedAndUnprocessed(Field field) {
        return (field.isSolved() && !field.hasBeenProcessed());
    }

    private boolean findRelatedFields(int rowNo, int rowNo1) {
        if (rowNo == rowNo1) {
            return true;
        }
        return false;
    }

    public void selectNextSolvedField() {
        int fieldWithMinimumPossibilities = 0;
        int minimumNoOfPossibilities = 9; // bigger than 9 is not possible

        // iterate all fields
        for (int i = 0; i < noOfFields; i++) {
            // check unsolved fields only
            if (!fieldArray[i].isSolved()) {
                if (fieldArray[i].countPossibleNumbers() <= minimumNoOfPossibilities) {
                    minimumNoOfPossibilities = fieldArray[i].countPossibleNumbers();
                    fieldWithMinimumPossibilities = i;
                }
            }
        }
        System.out.println("The next field marked as solved is field No " + fieldWithMinimumPossibilities + " with " + minimumNoOfPossibilities + " possible numbers");

        // IF THE SOLVER HAS MOVED TO A DEAD-END AND HAS TO RESTART FROM SCRATCH
        if (minimumNoOfPossibilities == 0) {
            System.out.println("SOLVER HAS HIT A DEAD END! RESTART SOLVER WITH INTIAL SUDOKU");
            configureAllFields(unsolvedSudoku);
        } else {
            // Set a random possibility value as field value
            fieldArray[fieldWithMinimumPossibilities].setFieldValue(fieldArray[fieldWithMinimumPossibilities].getAPossibleValueByRandom());
            // Mark field as solved:
            fieldArray[fieldWithMinimumPossibilities].setSolved();
        }
    }

    public int countNoOfUnsolvedFields() {
        int noOfUnsolvedFields = 0;
        for (int i = 0; i < noOfFields; i++) {
            if (!fieldArray[i].isSolved()) {
                noOfUnsolvedFields++;
            }
        }

        System.out.println(noOfUnsolvedFields + " fields are not solved yet");
        return noOfUnsolvedFields;
    }

    public int[][] getSolvedSudokuArray() {
        int[][] solvedSudoku = new int[9][9];
        for (int row = 0; row < solvedSudoku.length; row++) {
            for (int col = 0; col < solvedSudoku.length; col++) {
                int fieldNumber = row * solvedSudoku.length + col;
                // Assign field values to array
                solvedSudoku[row][col] = fieldArray[fieldNumber].getFieldValue();
            }
        }
        return solvedSudoku;
    }
}
