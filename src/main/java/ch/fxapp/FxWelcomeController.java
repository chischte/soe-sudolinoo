/**
 * FxWelcomeController is the class who is welcoming the user with a friendly toutch
 *
 * @author Roland Jaggi
 * @version 0.1
 * @since 03.05.2020
 */

package main.java.ch.fxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FxWelcomeController {

    private StageManager stageManager;

    public FxWelcomeController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @FXML
    protected void switchToSceneSudokuOverview(ActionEvent event) {
        stageManager.loadSecondStage();
    }
}



