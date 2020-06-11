package main.java.ch.solverrandomnumber;

import main.java.ch.solverbacktracking.SudokuSolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The MichiSolver solves a Sudoku by determing the possible numbers according to Sudoku rules.
 * If the solver cannot reduce the possible numbers in any field to a single one,
 * it simply guesses by random.
 * In case the solver guessed wrong, and hits a dead end, the solver restarts with the initial Sudoku puzzle.
 *
 * The random functionality is implemented in the method setAPossibleValueByRandom() of class Field.
 *
 * @param puzzle a two-dimensional array representing the unsolved Sudoku
 * @author Michael Wettstein
 * @return solvedSudoku the solved Sudoku array
 */
public class MichiSolver {
    Logger logger = LoggerFactory.getLogger(MichiSolver.class);

    public  int[][] solve(int[][] puzzle) {
        SolverTools solverTools = new SolverTools();

        solverTools.configureAllFields(puzzle);

        int noOfUnsolvedFields = 81; // 81 is the maximum;

        // REPEAT THIS LOOP UNTIL ALL FIELDS ARE SOLVED:
        logger.debug("Michi solver started");
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

        logger.debug("*** SUDOKU SOLVED ***");

        // GENERATE SOLVED SUDOKU ARRAY:
        int[][] solvedSudoku = solverTools.getSolvedSudokuArray();

        return solvedSudoku;
    }
}
