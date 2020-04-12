package main.java.ch.michisolver;

public class MichiSolver {

    public static int[][] solve(int[][] puzzle) {
        SolverTools solverTools = new SolverTools();

        // CONFIGURE ALL FIELDS
        printStarline("CONFIGURE ALL FIELDS");
        solverTools.configureAllFields(puzzle);

        int noOfUnsolvedFields = 81; // 81 is the maximum;

        while (noOfUnsolvedFields > 0) {

            // ITERATE THROUGH ALL SOLVED FIELDS ...
            // ...AND REMOVE THEIR NUMBERS FROM ALL FIELDS...
            // ...IN SAME ROW, COLUMN, OR SECTOR;
            printStarline("REMOVE SOLVED NUMBERS");
            solverTools.removeSolvedNumbersFromOtherFields();

            // FIND FIELD WITH THE LEAST POSSIBILITIES
            // ...SELECT A NUMBER
            // ...AND MARK IT "SOLVED"
            printStarline("SELECT NEXT SOLVED FIELD");
            solverTools.selectNextSolvedField();

            // CHECK IF ALL FIELDS ARE SOLVED
            // ...AND REPEAT UNTIL ALL FIELDS ARE SOLVED
            printStarline("COUNT NUMBER OF UNSOLVED FIELDS");
            noOfUnsolvedFields = solverTools.countNoOfUnsolvedFields();
        }

        // WRITE ARRAY OF OBJECTS TO SOLVED SUDOKU ARRAY
        int[][] solvedSudoku = solverTools.getSolvedSudokuArray();

        // RETURN THE SOLVED SUDOK ARRAY
        return solvedSudoku;
    }

    public static void printStarline(String chapter) {
        for (int i = 0; i < 3; i++) {
            System.out.print("*****" + chapter + "******");
        }
        System.out.println("");

    }
}
