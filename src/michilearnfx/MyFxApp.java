package michilearnfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;

// ACHTUNG: LÄUFT NUR AUF SDK 11.05 !!!!!

public class MyFxApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        MyFxController controller = new MyFxController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("myLayout.fxml"));
        loader.setController(controller);
        GridPane grid = loader.load();
        primaryStage.setTitle("Primary Stage");
        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
