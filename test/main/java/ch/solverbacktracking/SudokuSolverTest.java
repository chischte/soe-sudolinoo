package main.java.ch.solverbacktracking;

import main.java.ch.fileloader.SudokuParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {
    private SudokuParser sudokuParser;
    private String filePath;
    private String filePathAndName;
    private File jsonFile;
    private int [][] sudokuArrayToSolve;

    @BeforeEach
    void initialize(){
    sudokuParser = new SudokuParser();
    filePath = new File("").getAbsolutePath();
    filePathAndName = filePath + "\\out\\production\\Sudolinoo\\sudokustrings\\sudokustring_03_advanced.json";
    jsonFile = new File(filePathAndName);
    sudokuArrayToSolve = sudokuParser.convertJsonToSudokuArray(jsonFile);
}

    @Test
    void shouldStartSolvingSudoku() {
        SudokuSolver sudokuSolver = new SudokuSolver();
        int[][] solvedSudokuString = sudokuSolver.startSolvingSudoku(sudokuArrayToSolve);
        assert(solvedSudokuString != null);
    }

    @Test
    void shouldSolver() {
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.startSolvingSudoku(sudokuArrayToSolve);
        Boolean isSolver = sudokuSolver.solver();
        assert(isSolver);
    }
}