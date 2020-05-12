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
            // REMOVE NUMBER IN SOLVED FIELDS FROM RELATED FIELDS:
            solverTools.processSolvedFields();

            // FIND FIELD WITH THE LEAST POSSIBILITIES AND
            // SELECT A POSSIBLE NUMBER *BY RANDOM*:
            solverTools.selectNextSolvedField();

            // COUNT UNSOLVED FIELDS:
            noOfUnsolvedFields = solverTools.countNoOfUnsolvedFields();
        }

        // GENERATE SOLVED SUDOKU ARRAY:
        int[][] solvedSudoku = solverTools.getSolvedSudokuArray();

        return solvedSudoku;
    }
}
