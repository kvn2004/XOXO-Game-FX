package edu.ijse.tictactoe.Service;

public class BoardImpl implements Board {
    private Piece[][] pieces = new Piece[3][3];
    BoardUI BoardUI;

    public BoardImpl() {
        initializeBoard();
    }

    public Piece[][] getPieces() {
        return pieces;
    }



    @Override
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pieces[i][i] = Piece.Null;
            }
        }

    }

    @Override
    public Boolean isLegalMove(int col, int row) {
        return pieces[col][row] == Piece.Null;
    }

    @Override
    public void updateMove(int col, int row, Piece piece) {
        pieces[col][row] = piece;
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(pieces[i][j] + " |");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-----------------");
            }
        }
    }

    @Override
    public Winner getWinner() {
        for (int i = 0; i < 3; i++) {
            if (pieces[i][0] == pieces[i][1] && pieces[i][0] == pieces[i][2] && pieces[i][0] != Piece.Null) {
                return new Winner(pieces[i][0], i, 0, i, 1, i, 2);
            }
            if (pieces[0][i] == pieces[1][i] && pieces[0][i] == pieces[2][i] && pieces[0][i] != Piece.Null) {
                return new Winner(pieces[0][i], 0, i, 1, i, 2, i);
            }
        }
        if (pieces[0][0] == pieces[1][1] && pieces[0][0] == pieces[2][2] && pieces[0][0] != Piece.Null) {
            return new Winner(pieces[0][0], 0, 0, 1, 1, 2, 2);
        }
        if (pieces[0][2] == pieces[1][1] && pieces[0][2] == pieces[2][0] && pieces[0][2] != Piece.Null) {
            return new Winner(pieces[0][2], 0, 2, 1, 1, 2, 0);
        }
        return null;
    }


    public boolean isBoardFull() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.Null) {
                    return false;
                }
            }
        }
        return true;
    }
}
