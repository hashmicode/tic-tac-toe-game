import org.example.InputHandler;

public class MockInputHandler implements InputHandler {
    private int[][] moves;
    private int currentMove = 0;

    public MockInputHandler(int[][] moves) {
        this.moves = moves;
    }

    @Override
    public int[] getNextMove() {
        if (currentMove < moves.length) {
            return moves[currentMove++];
        } else {
            return new int[] {-1, -1}; // Invalid move to stop the game
        }
    }
}
