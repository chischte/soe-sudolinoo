package michilearnfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MyFxController {

    @FXML
    private Label actiontarget;
    @FXML
    private TextField name;

    @FXML
    protected void onSubmit(ActionEvent event) {
        String inputName = name.getText();
        actiontarget.setText("Sign in button pressed, name is " + inputName);
    }
}