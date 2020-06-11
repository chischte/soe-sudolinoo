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

package main.java.ch.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.ch.solverbacktracking.SudokuSolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class StageManager {
    private static StageManager instance;
    final Logger logger = LoggerFactory.getLogger(StageManager.class);

    private Stage welcomeStage;
    private Stage firstStage;
    private Stage sudokuStage;

    public static StageManager getInstance(Stage primaryStage) throws IOException {
        if (instance == null) {
            instance = new StageManager(primaryStage);
        }

        return instance;
    }

    private StageManager(Stage primaryStage) throws IOException {
        this.welcomeStage = primaryStage;
        setUpWelcomeStage();
        setUpSudokuStage();
    }

    private void setUpWelcomeStage() throws IOException {
        logger.debug("setUpWelcomeStage");
        firstStage = new Stage();

        FxWelcomeController controllerFxLayout = new FxWelcomeController(this);
        FXMLLoader loaderFxLayout = new FXMLLoader(getClass().getResource("../fxml/FxLayout.fxml"));
        loaderFxLayout.setController(controllerFxLayout);
        GridPane fxmlGrid = loaderFxLayout.load();
        firstStage.setTitle("Projektarbeit, TS TSI 1809 A 04 SoE");
        Scene scene = new Scene(fxmlGrid, 600, 400);
        firstStage.setScene(scene);
    }

    private void setUpSudokuStage() throws IOException {
        logger.debug("setUpSudokuStage");
        sudokuStage = new Stage();

        FxController controller = new FxController(this);
        FXMLLoader loaderFxLayoutSudokuSolverScene = new FXMLLoader(getClass().getResource("../fxml/FxLayoutSudokuSolverScene.fxml"));
        loaderFxLayoutSudokuSolverScene.setController(controller);
        GridPane fxmlGrid = loaderFxLayoutSudokuSolverScene.load();
        sudokuStage.setTitle("Sudoku Solver");
        Scene scene = new Scene(fxmlGrid, 600, 500);
        sudokuStage.setScene(scene);
    }

    public void loadWelcomeStage() {
        logger.debug("loadWelcomeStage");
        closeActiveStage();
        welcomeStage = firstStage;
        welcomeStage.show();
    }

    public void loadSudokuStage() {
        logger.debug("loadSudokuStage");
        closeActiveStage();
        welcomeStage = sudokuStage;
        welcomeStage.show();
    }

    private void closeActiveStage() {
        logger.debug("closeActiveStage");
        welcomeStage.close();
    }
}