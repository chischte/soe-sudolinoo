package main.java.ch.fxapp;

import main.java.ch.fileloader.Loader;
import main.java.ch.controller.SudokuSolver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class FxController {
    int sudokuLength = 9;

    private Button[][] sudokuFields = new Button[9][9];

    Loader createdLoader1 = new Loader();
    private int[][] LoaderSudoku1 = createdLoader1.loadSudokuArray();

    SudokuSolver Solver1 = new SudokuSolver();
    private int[][] SolverSudoku1 = Solver1.startsolver();

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
        pasteSolutionToSudokuGrid();
    }

    public void generateSudokuGrid() {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                sudokuFields[row][col] = new Button();
                sudokuFields[row][col].setStyle("-fx-border-width:1; -fx-border-color: black; -fx-min-width: 33; -fx-min-height: 33;");
                /* how to set style class? */
                sudokuGrid.getChildren().add(sudokuFields[row][col]);
                GridPane.setConstraints(sudokuFields[row][col], row, col);
            }
        }
    }

    public void pastePuzzleNumbersToSudokuGrid() {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                // Leave fields with value 0 empty
                int currentNumber = LoaderSudoku1[row][col];
                if (currentNumber != 0) {
                    sudokuFields[col][row].setText(Integer.toString(currentNumber));
                } else {
                    sudokuFields[col][row].setText("");
                }
            }
        }
    }


    public void pasteSolutionToSudokuGrid() {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                sudokuFields[row][col].setText(SolverSudoku1[col][row] + "");
            }
        }
    }
}


