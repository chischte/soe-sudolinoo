package main.java.ch.fxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class FxApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Get fxml and add it to grid
        FxController controller = new FxController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FxLayout.fxml"));
        loader.setController(controller);
        GridPane fxmlGrid = loader.load();

        // Make mainVBox a scene
        Scene scene = new Scene(fxmlGrid, 600, 500);

        // Show scene @ primary stage
        primaryStage.setTitle("Sudoku Solver");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
