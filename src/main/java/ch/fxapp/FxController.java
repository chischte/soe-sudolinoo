package main.java.ch.fxapp;

import main.java.ch.fileloader.SudokuParser;
import main.java.ch.controller.SudokuSolver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FxController {

    private int[][] unsolvedSudoku = new int[9][9];
    int sudokuLength = unsolvedSudoku.length;
    private Button[][] sudokuFieldButtons = new Button[sudokuLength][sudokuLength];
    private Component fileChooserComponent;
    @FXML
    GridPane sudokuGrid;

    public FxController() throws Exception {
    }

    public void initialize() {
        generateSudokuGrid();
    }

    @FXML
    protected void clickOnGetSudoku(ActionEvent event) {
        File selectedFile = getJsonFromFileChooser();
        if (selectedFile != null) {
            SudokuParser sudokuParser = new SudokuParser();
            this.unsolvedSudoku = sudokuParser.convertJsonToSudokuarray(selectedFile);
            pastePuzzleNumbersToSudokuGrid();
        } else {
            System.out.println("No file has been selected");
        }
    }

    @FXML
    protected void clickOnSolveSudoku(ActionEvent event) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        int[][] solvedSudoku = sudokuSolver.startSolvingSudoku(this.unsolvedSudoku);
        pasteSolutionToSudokuGrid(solvedSudoku);
    }

    private void generateSudokuGrid() {
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

    private File getJsonFromFileChooser() {
        // Open a file chooser window to select json
        final JFileChooser fileChooser = new JFileChooser("src/main/java/ch/fileloader/sudokustrings");
        int returnVal = fileChooser.showOpenDialog(fileChooserComponent);
        File selectedJsonFile = fileChooser.getSelectedFile();
        return selectedJsonFile;
    }

    private void pastePuzzleNumbersToSudokuGrid() {
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

    private void pasteSolutionToSudokuGrid(int[][] solvedSudoku) {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                sudokuFieldButtons[row][col].setText(solvedSudoku[col][row] + "");
            }
        }
    }
}


