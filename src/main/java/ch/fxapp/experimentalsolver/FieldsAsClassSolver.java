package main.java.ch.fxapp.experimentalsolver;

public class FieldsAsClassSolver {
    // This is an array containing an object for every sudoku field
    private FieldAsClass[] fieldAsClassArray = new FieldAsClass[81];
    private int[][] unsolvedSudoku = new int[9][9];
    private int sudokuLength = unsolvedSudoku.length;
    private int noOfFields =(unsolvedSudoku.length)^2;



    public void configureAllFields(int[][] sudokuArray) {
        int currentSector = 1; //there are 9 sectors
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                int sector=findOutSector(row,col);

                int currentValue = sudokuArray[row][col];
                int currentFieldNo = row * sudokuLength + col;
                // Initialize a new object in fieldAsClassArray:
                fieldAsClassArray[currentFieldNo] = new FieldAsClass();
                FieldAsClass currentFieldObject= fieldAsClassArray[currentFieldNo];
                fieldAsClassArray[currentFieldNo].setSectorNo(currentSector);
                if (currentValue != 0) {
                    fieldAsClassArray[currentFieldNo].setSolved(true);
                    fieldAsClassArray[currentFieldNo].setFieldValue(currentValue);
                } else {
                    fieldAsClassArray[currentFieldNo].setSolved(false);
                }
                fieldAsClassArray[currentFieldNo].getPossibleNo();
            }
        }
    }










    private int findOutSector(int row, int col){
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
