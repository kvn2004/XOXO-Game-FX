package edu.ijse.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/View/logingUi.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.resizableProperty().setValue(Boolean.FALSE);
        Image image = new Image(getClass().getResourceAsStream("/Assets/images (1).png"));
        stage.getIcons().add(image);
        stage.show();
    }
}
