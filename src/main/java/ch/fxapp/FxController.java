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

    @FXML
    private Label testlabeltarget;

    @FXML
    private TextField name;

    @FXML
    GridPane sudokuGrid;

    public void initialize() {
        generateSudokuGrid();
    }

    @FXML
    protected void clickOnGetSudoku(ActionEvent event) {
        SudokuProvider sudokuProvider = new SudokuProvider();
        int[][] sudoku = sudokuProvider.getNewSudoku();
        testlabeltarget.setText(String.valueOf(sudoku[1][1]));

    }

    public void generateSudokuGrid() {
        for (int row = 0; row < sudokuFields.length; row++) {
            for (int col = 0; col < sudokuFields.length; col++) {
                sudokuFields[row][col] = new Button();
                sudokuFields[row][col].setStyle("-fx-background-color: POWDERBLUE; -fx-font-weight: bold");
                sudokuGrid.getChildren().add(sudokuFields[row][col]);
                GridPane.setConstraints(sudokuFields[row][col], row, col);
            }
        }
    }

}
