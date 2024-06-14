import org.example.Board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    void testInitialBoardIsEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', board.getSymbolAt(i, j), "Board should be initialized with '-'");
            }
        }
    }

    @Test
    void testMakeMove() {
        assertTrue(board.makeMove(0, 0, 'X'), "Move should be successful");
        assertEquals('X', board.getSymbolAt(0, 0), "Cell should contain 'X'");
    }

    @Test
    void testMakeMoveOnOccupiedCell() {
        board.makeMove(0, 0, 'X');
        assertFalse(board.makeMove(0, 0, 'O'), "Move should fail as cell is occupied");
    }

    @Test
    void testMoveOutOfBounds() {
        assertFalse(board.makeMove(-1, 0, 'X'), "Move should fail as it is out of bounds");
        assertFalse(board.makeMove(3, 3, 'X'), "Move should fail as it is out of bounds");
    }
}
