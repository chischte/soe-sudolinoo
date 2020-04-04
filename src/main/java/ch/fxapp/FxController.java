package main.java.ch.fxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FxController {
    int index;
    int target = 10;
    private Button[][] sudokuFields = new Button[9][9];
    SudokuProvider sudokuProvider = new SudokuProvider();
    int[][] sudoku = sudokuProvider.getNewSudoku();

    @FXML
    GridPane sudokuGrid;

    public void initialize() {
        generateSudokuGrid();
    }

    @FXML
    protected void clickOnGetSudoku(ActionEvent event) {
        pasteNumbersToSudokuGrid();
    }

    public void generateSudokuGrid() {
        for (int row = 0; row < sudokuFields.length; row++) {
            for (int col = 0; col < sudokuFields.length; col++) {
                sudokuFields[row][col] = new Button();
                sudokuFields[row][col].setStyle("-fx-border-width:1; -fx-border-color: black; -fx-min-width: 33; -fx-min-height: 33");
                /* how to set style class? */
                sudokuGrid.getChildren().add(sudokuFields[row][col]);
                GridPane.setConstraints(sudokuFields[row][col], row, col);
            }
        }
    }

    public void pasteNumbersToSudokuGrid() {
        for (int row = 0; row < sudokuFields.length; row++) {
            for (int col = 0; col < sudokuFields[0].length; col++) {
                // Leave fields with value 0 empty
                if (sudoku[row][col] != 0) {
                    sudokuFields[row][col].setText(sudoku[col][row] + "");
                } else {
                    sudokuFields[row][col].setText(" ");
                }
            }
        }
    }

}
