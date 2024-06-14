package org.example;

import java.util.Scanner;

public class TicTacToeGame {
    private Board board;
    private char currentPlayer;
    private boolean gameEnded;

    public TicTacToeGame() {
        board = new Board();
        currentPlayer = 'X';
        gameEnded = false;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameEnded) {
            board.printBoard();
            System.out.println("Player " + currentPlayer + "'s turn:");
            System.out.print("Enter row and column numbers (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.makeMove(row, col, currentPlayer)) {
                switchPlayer();
            } else {
                System.out.println("Invalid move, try again.");
            }

            // Additional methods to check for win or draw can be added here
        }
        scanner.close();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
