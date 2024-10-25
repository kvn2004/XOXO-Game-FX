module edu.ijse.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.desktop;


    opens edu.ijse.tictactoe.Controller to javafx.fxml;
    exports edu.ijse.tictactoe;
}