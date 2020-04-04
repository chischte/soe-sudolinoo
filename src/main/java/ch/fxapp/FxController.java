package main.java.ch.fxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FxController {
    @FXML
    private Label testlabeltarget;

    @FXML
    private TextField name;

    @FXML
    protected void onSubmit(ActionEvent event) {
        testlabeltarget.setText("HAUDI");

    }
}
