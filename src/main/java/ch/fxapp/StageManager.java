/**
 * The Stage manager provides us the functionality of switching between
 * stages. At the moment we do have only 2 stages, but it comes in handy
 * if we want to extend our game list.
 *
 * @author Michael Wettstein
 * @author Joel Iselin
 * @author Roland Jaggi
 * @version 0.1
 * @since 03.05.2020
 */

package main.java.ch.fxapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StageManager {
    private static StageManager instance;

    private Stage welcomeStage;
    private Stage firstStage;
    private Stage sudokuStage;

    public static StageManager getInstance(Stage primaryStage) throws IOException {
        if(instance == null) {
            instance = new StageManager(primaryStage);
        }

        return instance;
    }

    private StageManager(Stage primaryStage) throws IOException {
        this.welcomeStage = primaryStage;
        setupWelcomeStage();
        setupSudokuStage();
    }

    private void setupWelcomeStage() throws IOException {
        firstStage = new Stage();

        FxWelcomeController controllerFxLayout = new FxWelcomeController(this);
        FXMLLoader loaderFxLayout = new FXMLLoader(getClass().getResource("FxLayout.fxml"));
        loaderFxLayout.setController(controllerFxLayout);
        GridPane fxmlGrid = loaderFxLayout.load();
        firstStage.setTitle("Projektarbeit, TS TSI 1809 A 04 SoE");
        Scene scene = new Scene(fxmlGrid, 600, 400);
        firstStage.setScene(scene);
    }

    private void setupSudokuStage() throws IOException {
        sudokuStage = new Stage();

        FxController controller = new FxController(this);
        FXMLLoader loaderFxLayoutSudokuSolverScene= new FXMLLoader(getClass().getResource("FxLayoutSudokuSolverScene.fxml"));
        loaderFxLayoutSudokuSolverScene.setController(controller);
        GridPane fxmlGrid = loaderFxLayoutSudokuSolverScene.load();
        sudokuStage.setTitle("Sudoku Solver");
        sudokuStage.setX(600);
        sudokuStage.setY(500);
        Scene scene = new Scene(fxmlGrid, 600, 500);
        sudokuStage.setScene(scene);
    }

    public void loadFirstStage() {
        closeActiveStage();
        welcomeStage = firstStage;
        welcomeStage.show();
    }

    public void loadSecondStage() {
        closeActiveStage();
        welcomeStage = sudokuStage;
        welcomeStage.show();
    }

    private void closeActiveStage() {
        welcomeStage.close();
    }
}
