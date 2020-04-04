package main.java.ch.controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;


public final class Main extends Application {
    public static int[][] puzzle = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 0, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 0, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };


    private Button[][] sudokuFields = new Button[9][9];



    @Override
    public void start(Stage primaryStage) throws Exception {

        // Button to get a new Sudoku
        Button getGameButton = new Button("Get Sudoku");

        // Button to solve the Sudoku
        Button solveButton = new Button("Solve Sudoku");

        // Add a created by comment
        Label createdByMsg = new Label("Created by Roland Jaggi, Michael Wettstein, Joel Iselin");

        // Define grid pane
        Stage window = primaryStage;
        window.setTitle("Solve This Sudoku");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(8);
        gridPane.setVgap(8);

        // Define boxes
        VBox outerVBox = new VBox(0);
        VBox buttonVBox = new VBox();
        createdByMsg.setPadding(new Insets(10, 0, 0, 0));
        buttonVBox.setAlignment(Pos.CENTER);
        buttonVBox.getChildren().addAll(getGameButton, solveButton, createdByMsg);
        outerVBox.getChildren().addAll(gridPane, buttonVBox);

        // Define window size
        window.setScene(new Scene(outerVBox, 350, 450));
        window.show();


        // Create text fields
        for (int row = 0; row < sudokuFields.length; row++) {
            for (int col = 0; col < sudokuFields[0].length; col++) {
                sudokuFields[row][col] = new Button();
                sudokuFields[row][col].setStyle("-fx-background-color: POWDERBLUE; -fx-font-weight: bold");
                gridPane.getChildren().add(sudokuFields[row][col]);
                GridPane.setConstraints(sudokuFields[row][col], row, col);
            }
        }

               // Fill text fields with numbers
        for (int row = 0; row < sudokuFields.length; row++) {
            for (int col = 0; col < sudokuFields[0].length; col++) {
                // Leave fields with value 0 empty
                if (puzzle[row][col] != 0) {
                    sudokuFields[row][col].setText(puzzle[col][row] + "");
                } else {
                    sudokuFields[row][col].setText("  ");
                }
            }
        }

    }

}