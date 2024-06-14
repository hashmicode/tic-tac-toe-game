package org.example;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler(); // Initialize the input handler
        TicTacToeGame game = new TicTacToeGame(inputHandler); // Pass the input handler to the game
        game.startGame(); // Start the game loop
    }
}
