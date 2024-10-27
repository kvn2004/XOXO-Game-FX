package edu.ijse.tictactoe.Controller;

import edu.ijse.tictactoe.Controller.bordUiController.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class logingUiController {

    @FXML
    private JFXButton btnPlay;

    @FXML
    private JFXCheckBox cBAi;

    @FXML
    private JFXCheckBox cbHuman;

    @FXML
    private JFXTextField txtPlayerName;

    @FXML
    void CheckBoxOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlayOnAction(ActionEvent event) throws IOException {
        String playerName = txtPlayerName.getText();
        txtPlayerName.setPromptText("Please enter your name");
        if (!txtPlayerName.getText().equals("")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/bordUi.fxml"));
            Parent root = loader.load();
            bordUiController controller = loader.getController();
            controller.setPlayerName(playerName);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Image image = new Image(getClass().getResourceAsStream("/Assets/images (1).png"));
            stage.getIcons().add(image);
            Stage window = (Stage) btnPlay.getScene().getWindow();
            window.close();
        }
    }

    public void CheckBoxAiOnAction(ActionEvent actionEvent) {
        bordUiController.setAiOrHuman(1);
    }

    public void CheckBoxHumanOnAction(ActionEvent actionEvent) {
        bordUiController.setAiOrHuman(0);
    }
}
