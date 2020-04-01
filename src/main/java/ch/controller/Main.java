package main.java.ch.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;


public final class Main extends Application {
    private static int[][] puzzle = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };


    private TextField[][] fieldsize = new TextField[9][9];

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
        for (int row = 0; row < fieldsize.length; row++) {
            for (int col = 0; col < fieldsize[0].length; col++) {
                fieldsize[row][col] = new TextField();
                gridPane.getChildren().add(fieldsize[row][col]);
                GridPane.setConstraints(fieldsize[row][col], row, col);
            }
        }


        // Fill text fields with numbers
        for (int row = 0; row < fieldsize.length; row++) {
            for (int col = 0; col < fieldsize[0].length; col++) {
                fieldsize[row][col].setText("1");
                fieldsize[row][col].setText(puzzle[col][row] + "");
            }
        }


    }


    //public static void main(String[] args) {
    //    launch(args);
    //}

}


//        final TextField textField = new TextField(SudokuDisplayFields(puzzle) + " Schokoladenkuchen");
//
//        primaryStage.setScene( new javafx.scene.Scene( textField ));
//        primaryStage.show();
//    }

//    private static int SudokuDisplayFields(int[][] puzzle){
//        return puzzle[0][8];
//
//        for(int i = 0; i <9; i++){
//            for(int j = 0; j <9; j++){
//                //Anzeige in feld [i][j]
//            }
//        }
//
//    }
//}

//        Parent root = FXMLLoader.load(getClass().getResource("../javafx/Gui.fxml"));
//        primaryStage.setTitle("Welcome to version " + Integer.toString(SudokuDisplayFields(puzzle)));
//
//        Text t = new Text();
//        t.setText("This is a text sample");
//        Button butt = new Button();
//        butt.setText("Klick mich");
//
//        GridPane grid = new GridPane();
//        grid.setHgap(5);
//        grid.setVgap(5);
//        grid.add(butt, 0, 0);
//        grid.add(t, 0, 1);
//        grid.setGridLinesVisible(false);
//
//
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();


