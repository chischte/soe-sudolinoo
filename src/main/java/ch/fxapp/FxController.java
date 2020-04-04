package main.java.ch.fxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FxController {
    int index ;
    int target = 10;

    @FXML
    private Label testlabeltarget;

    @FXML
    private TextField name;

    @FXML
    GridPane button_grid;

    public void initialize() {
        for (index = 2; index < target ; index++) {
            addButton();
        }
    }

    public void test(){
        System.out.println("Testing");
    }

    public void addButton(){
        Button sound_button = new Button("Button_" + index);
        button_grid.add(sound_button, index,2);
    }

    @FXML
    protected void clickOnGetSudoku(ActionEvent event) {
        SudokuProvider sudokuProvider = new SudokuProvider();
        int[][] sudoku = sudokuProvider.getNewSudoku();
        testlabeltarget.setText(String.valueOf(sudoku[1][1]));

    }


}
