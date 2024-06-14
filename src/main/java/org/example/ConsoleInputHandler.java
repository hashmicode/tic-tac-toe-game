package org.example;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
    private Scanner scanner;

    public ConsoleInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int[] getNextMove() {
        System.out.print("Enter row and column: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }
}
