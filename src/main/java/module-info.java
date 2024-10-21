module edu.ijse.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ijse.tictactoe to javafx.fxml;
    exports edu.ijse.tictactoe;
}