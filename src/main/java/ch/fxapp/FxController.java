/**
 * This controller shows of all of the button clicks.
 * The generated fields where also styled in here
 *
 * @author Michael Wettstein
 * @author Joel Iselin
 * @author Roland Jaggi
 * @version 0.5
 * @since 03.05.2020
 */

package main.java.ch.fxapp;

import main.java.ch.fileloader.SudokuParser;
import main.java.ch.controller.SudokuSolver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import main.java.ch.michisolver.MichiSolver;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FxController {

    private int[][] unsolvedSudoku = new int[9][9];
    int sudokuLength = unsolvedSudoku.length;
    private Button[][] sudokuFieldButtons = new Button[sudokuLength][sudokuLength];
    private Component fileChooserComponent;
    private File selectedJsonFile;
    SudokuParser sudokuParser = new SudokuParser();
    SudokuSolver sudokuSolver = new SudokuSolver();
    MichiSolver michiSolver = new MichiSolver();

    @FXML
    GridPane sudokuGrid;

    private StageManager stageManager;

    public FxController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    public void initialize() {
        generateSudokuGrid();
    }

    @FXML
    protected void clickOnGetSudoku(ActionEvent event) {
        File selectedFile = getJsonFromFileChooser();
        this.selectedJsonFile = selectedFile; // store the file in the class to use it with different solvers
        if (selectedFile != null) {
            this.unsolvedSudoku = sudokuParser.convertJsonToSudokuarray(this.selectedJsonFile);
            pastePuzzleNumbersToSudokuGrid();
        } else {
            System.out.println("No file has been selected");
        }
    }

    @FXML
    protected void clickOnSolveSudoku(ActionEvent event) {
        this.unsolvedSudoku = sudokuParser.convertJsonToSudokuarray(this.selectedJsonFile);
        int[][] solvedSudoku = sudokuSolver.startSolvingSudoku(this.unsolvedSudoku);
        pasteSolutionToSudokuGrid(solvedSudoku);
    }

    @FXML
    protected void clickOnMichiSolver(ActionEvent event) {
        this.unsolvedSudoku = sudokuParser.convertJsonToSudokuarray(this.selectedJsonFile);
        int[][] solvedSudoku = michiSolver.solve(this.unsolvedSudoku);
        pasteSolutionToSudokuGrid(solvedSudoku);
    }

    @FXML
    protected void clickOnClear(ActionEvent event) {
        clearSudokuGrid();
        System.out.println("Cleared the grid");
    }

    private void generateSudokuGrid() {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                sudokuFieldButtons[row][col] = new Button();
                sudokuFieldButtons[row][col].setStyle("-fx-border-width:1; -fx-border-color: grey; -fx-min-width: 34; -fx-min-height: 33; -fx-vgap: 1; -fx-hgap: 1");

                if(col > 0 && col < sudokuLength && (col + 1) %3 == 0){
                    sudokuFieldButtons[row][col].setStyle("-fx-border-width: 1 1 3 1; -fx-border-color: grey; -fx-min-width: 34; -fx-min-height: 33; -fx-vgap: 1; -fx-hgap: 1");
                }
                if(row > 0 && row < sudokuLength && (row + 1) %3 == 0){
                    sudokuFieldButtons[row][col].setStyle("-fx-border-width: 1 3 1 1; -fx-border-color: grey; -fx-min-width: 34; -fx-min-height: 33; -fx-vgap: 1; -fx-hgap: 1");
                }
                if(row > 0 && row < sudokuLength && (row + 1) %3 == 0 && (col + 1) %3 == 0){
                    sudokuFieldButtons[row][col].setStyle("-fx-border-width: 1 3 3 1; -fx-border-color: grey; -fx-min-width: 34; -fx-min-height: 33; -fx-vgap: 1; -fx-hgap: 1");
                }

                sudokuGrid.getChildren().add(sudokuFieldButtons[row][col]);
                GridPane.setConstraints(sudokuFieldButtons[row][col], row, col);
            }
        }
    }

    private File getJsonFromFileChooser() {
        // Open a file chooser window to select json
        final JFileChooser fileChooser = new JFileChooser("src/main/java/ch/fileloader/sudokustrings");
        fileChooser.showOpenDialog(fileChooserComponent);
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
                }
                else {
                    sudokuFieldButtons[col][row].setText("");
                }
            }
        }
    }

    private void pasteSolutionToSudokuGrid(int[][] solvedSudoku) {
        try {
            if(solvedSudoku != null && solvedSudoku.length > 0) {
                for (int row = 0; row < sudokuLength; row++) {
                    for (int col = 0; col < sudokuLength; col++) {
                        sudokuFieldButtons[row][col].setText(solvedSudoku[col][row] + "");
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void clearSudokuGrid() {
        for (int row = 0; row < sudokuLength; row++) {
            for (int col = 0; col < sudokuLength; col++) {
                sudokuFieldButtons[col][row].setText(" ");
            }
        }
    }
}