package main.java.ch.michisolver;

public class MichiSolver {

    public static int[][] solve(int[][] puzzle) {
        SolverTools solverTools = new SolverTools();

        // CONFIGURE ALL FIELDS
        solverTools.configureAllFields(puzzle);

        int noOfUnsolvedFields = 81; // 81 is the maximum;

        // REPEAT THIS LOOP UNTIL ALL FIELDS ARE SOLVED:
        while (noOfUnsolvedFields > 0) {

            // ITERATE THROUGH ALL SOLVED FIELDS AND
            // REMOVE THEIR NUMBERS FROM ALL RELATED FIELDS:
            solverTools.removeSolvedNumbersFromOtherFields();

            // FIND FIELD WITH THE LEAST POSSIBILITIES AND
            // SELECT A POSSIBLE NUMBER *BY RANDOM*:
            solverTools.selectNextSolvedField();

            // COUNT SOLVED FIELDS:
            noOfUnsolvedFields = solverTools.countNoOfUnsolvedFields();
        }

        // GENERATE SOLVED SUDOKU ARRAY:
        int[][] solvedSudoku = solverTools.getSolvedSudokuArray();

        return solvedSudoku;
    }
}
