/**
 * Main Method to start the whole Sudoku program.
 * This Main starts an instance of the Stage Manager, because there is a multi Stage
 * level design. Even if it's not necessary , it gives to the user
 * a warm welcome
 *
 * @author Michael Wettstein
 * @author Joel Iselin
 * @author Roland Jaggi
 * @version 0.1
 * @since 03.05.2020
 */

package main.java.ch.controller;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public final class FxApp extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        StageManager stageManager = StageManager.getInstance(primaryStage);
        stageManager.loadWelcomeStage();
    }
}