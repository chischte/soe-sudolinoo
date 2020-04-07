package main.java.ch.fxapp;

import main.java.ch.fileloader.Loader;
import main.java.ch.controller.SudokuSolver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class FxController {

    Loader createdLoader = new Loader();
    private int[][] loaderSudoku = createdLoader.getPuzzle();
    int sudokuLength = loaderSudoku.length;
    private Button[][] sudokuFieldButtons = new Button[sudokuLength][sudokuLength];

    @FXML
    GridPane sudokuGrid;

    public void initialize() {
        generateSudokuGrid();
    }

    @FXML
    protected void clickOnGetSudoku(ActionEvent event) {
        pastePuzzleNumbersToSudokuGrid();
    }

    @FXML
    protected void clickOnSolveSudoku(ActionEvent event) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        int[][] solverSudoku = sudokuSolver.startSolvingSudoku();
        pasteSolutionToSudokuGrid(solverSudoku);
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
                int currentNumber = loaderSudoku[row][col];
                if (currentNumber != 0) {
                    sudokuFieldButtons[col][row].setText(Integer.toString(currentNumber));
                } else {
                    sudokuFieldButtons[col][row].setText("");
                }
            }
        }
    }

    public void pasteSolutionToSudokuGrid(int[][] solverSudoku) {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                sudokuFieldButtons[row][col].setText(solverSudoku[col][row] + "");
            }
        }
    }
}


