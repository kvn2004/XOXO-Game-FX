package edu.ijse.tictactoe.Service;

public interface Board {
    void initializeBoard();

    Boolean isLegalMove(int col, int row);

    void updateMove(int col, int row, Piece piece);

    void printBoard();

    Winner getWinner();
}
