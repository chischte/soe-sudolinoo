package main.java.ch.fxapp;

import main.java.ch.fileloader.SudokuLoader;
import main.java.ch.controller.SudokuSolver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class FxController {

    private int[][] unsolvedSudoku =new int[9][9];
    int sudokuLength = unsolvedSudoku.length;
    private Button[][] sudokuFieldButtons = new Button[sudokuLength][sudokuLength];

    @FXML
    GridPane sudokuGrid;

    public FxController() throws Exception {
    }

    public void initialize() {
        generateSudokuGrid();
    }

    @FXML
    protected void clickOnGetSudoku(ActionEvent event) throws Exception {
        SudokuLoader sudokuLoader = new SudokuLoader();
        this.unsolvedSudoku = sudokuLoader.getPuzzle("sudokustring_medium.json");
        pastePuzzleNumbersToSudokuGrid();
    }

    @FXML
    protected void clickOnSolveSudoku(ActionEvent event) throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver();
        int[][] solvedSudoku = sudokuSolver.startSolvingSudoku(this.unsolvedSudoku);
        pasteSolutionToSudokuGrid(solvedSudoku);
    }

    public void generateSudokuGrid() {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                sudokuFieldButtons[row][col] = new Button();
                sudokuFieldButtons[row][col].setStyle("-fx-border-width:1; -fx-border-color: black; -fx-min-width: 33; -fx-min-height: 33;");
                /* how to set style class? */
                sudokuGrid.getChildren().add(sudokuFieldButtons[row][col]);
                GridPane.setConstraints(sudokuFieldButtons[row][col], row, col);
            }
        }
    }

    public void pastePuzzleNumbersToSudokuGrid() {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                // Leave fields with value 0 empty
                int currentNumber = unsolvedSudoku[row][col];
                if (currentNumber != 0) {
                    sudokuFieldButtons[col][row].setText(Integer.toString(currentNumber));
                } else {
                    sudokuFieldButtons[col][row].setText("");
                }
            }
        }
    }

    public void pasteSolutionToSudokuGrid(int[][] solvedSudoku) {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                sudokuFieldButtons[row][col].setText(solvedSudoku[col][row] + "");
            }
        }
    }
}


