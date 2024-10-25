package edu.ijse.tictactoe.Service;

public interface BoardUI {
    void update(int row, int col,Piece piece);
    void notifyWinner(Piece winner);
}
