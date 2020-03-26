package main.java.ch.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../javafx/Gui.fxml"));
        primaryStage.setTitle(Integer.toString(SudokuDisplayFields(puzzle)));
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    private static int SudokuDisplayFields(int[][] puzzle){
        return puzzle[0][8];

//        for(int i = 0; i <9; i++){
//            for(int j = 0; j <9; j++){
//                //Anzeige in feld [i][j]
//            }
//        }
    }
}