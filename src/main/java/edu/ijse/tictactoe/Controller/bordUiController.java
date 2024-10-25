package edu.ijse.tictactoe.Controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.tictactoe.Service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class bordUiController implements BoardUI {
    HumanPlayer humanPlayer;
    AiPlayer aiPlayer;
    BoardImpl board;

    public bordUiController() {
        board = new BoardImpl();
        aiPlayer = new AiPlayer(board);
        humanPlayer = new HumanPlayer(board);
    }

    @FXML
    private Pane XScoreCard;

    @FXML
    private JFXButton btn00;

    @FXML
    private JFXButton btn01;

    @FXML
    private JFXButton btn02;

    @FXML
    private JFXButton btn10;

    @FXML
    private JFXButton btn11;

    @FXML
    private JFXButton btn12;

    @FXML
    private JFXButton btn20;

    @FXML
    private JFXButton btn21;

    @FXML
    private JFXButton btn22;

    @FXML
    private GridPane grdMain;

    @FXML
    private ImageView imgLogo;

    @FXML
    private ImageView imgPlayer;

    @FXML
    private Label lblXScore;

    @FXML
    private Label lblYScore;

    @FXML
    private Pane yScoreCard;

    @FXML
    private Label lblname;
    @FXML
    private Label lblWinner;

    public void setPlayerName(String playerName) {
        lblname.setText("X { " + playerName + " }");
    }

    public void gridBtnOnAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        int row = Integer.parseInt(button.getId().split("")[3]);
        int col = Integer.parseInt(button.getId().split("")[4]);

        humanPlayer.move(row, col);
        aiPlayer.findBestMove();
        board.printBoard();
        updateUi();
        if (board.getWinner() != null) {
            notifyWinner(board.getWinner().getWinningPiece());
        } else if (board.isBoardFull()) {
            lblWinner.setText("TIE");
        }
    }

    private void updateUi() {
        for (int i = 0; i < board.getPieces().length; i++) {
            for (int j = 0; j < board.getPieces()[i].length; j++) {
                update(i, j, board.getPieces()[i][j]);
            }
        }
    }


    @Override
    public void update(int row, int col, Piece piece) {
        String buttonId = "btn" + row + col;
        for (Node node : grdMain.getChildren()) {
            if (node instanceof Button button && buttonId.equals(node.getId())) {
                if (piece == Piece.X) {
                    button.setText("X");
                } else if (piece == Piece.O) {
                    button.setText("O");
                } else {
                    button.setText("");
                }
                break;
            }
        }
    }

    @Override
    public void notifyWinner(Piece winner) {
        if (winner == Piece.X) {
            lblWinner.setText(lblname.getText() + " YOU WON");
        }
        if (winner == Piece.O) {
            lblWinner.setText(lblname.getText() + " YOU LOOSE");
        }
//        WantToPlayAgain();
    }

//    private void WantToPlayAgain() {
//    }
}
