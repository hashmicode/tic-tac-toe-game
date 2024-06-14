package org.example;

public class TicTacToeGame {
    private Board board;
    private char currentPlayer;
    private boolean gameEnded;
    private InputHandler inputHandler;

    public TicTacToeGame(InputHandler handler) {
        board = new Board();
        currentPlayer = 'X';
        gameEnded = false;
        this.inputHandler = handler;
    }

    public void startGame() {
        while (!gameEnded) {
            board.printBoard();
            System.out.println("Player " + currentPlayer + "'s turn:");

            int[] move = inputHandler.getNextMove();
            int row = move[0];
            int col = move[1];

            if (board.makeMove(row, col, currentPlayer)) {
                if (hasWinner()) {
                    gameEnded = true;
                    board.printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (isDraw()) {
                    gameEnded = true;
                    board.printBoard();
                    System.out.println("The game is a draw!");
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }


    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean hasWinner() {
        // Check horizontal lines
        for (int i = 0; i < 3; i++) {
            if (board.getSymbolAt(i, 0) != '-' &&
                    board.getSymbolAt(i, 0) == board.getSymbolAt(i, 1) &&
                    board.getSymbolAt(i, 1) == board.getSymbolAt(i, 2)) {
                return true;
            }
        }
        // Check vertical lines
        for (int j = 0; j < 3; j++) {
            if (board.getSymbolAt(0, j) != '-' &&
                    board.getSymbolAt(0, j) == board.getSymbolAt(1, j) &&
                    board.getSymbolAt(1, j) == board.getSymbolAt(2, j)) {
                return true;
            }
        }
        // Check diagonals
        if (board.getSymbolAt(0, 0) != '-' &&
                board.getSymbolAt(0, 0) == board.getSymbolAt(1, 1) &&
                board.getSymbolAt(1, 1) == board.getSymbolAt(2, 2)) {
            return true;
        }
        if (board.getSymbolAt(0, 2) != '-' &&
                board.getSymbolAt(0, 2) == board.getSymbolAt(1, 1) &&
                board.getSymbolAt(1, 1) == board.getSymbolAt(2, 0)) {
            return true;
        }
        return false;
    }
    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbolAt(i, j) == '-') {
                    return false; // If any cell is empty, it's not a draw
                }
            }
        }
        return true; // No cells are empty and no winner, it's a draw
    }

}
