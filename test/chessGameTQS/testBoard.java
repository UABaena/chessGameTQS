package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testBoard {

	private Board board;

	@BeforeEach
	public void setUp() {
		board = new Board();
	}

	@Test
	void testTurnSwap() { // Swap

		int expected = board.PLAYER_1;
		int result = board.getPlayerTurn();
		assertTrue(expected == result);

		board.swapTurn();

		expected = board.PLAYER_2;
		result = board.getPlayerTurn();
		assertTrue(expected == result);

		board.swapTurn();

		expected = board.PLAYER_1;
		result = board.getPlayerTurn();
		assertTrue(expected == result);

	}

	@Test
	void testInitialPosition() {

		// Primera linea Blancas
		Square expected = new Square(new Rook(board.PLAYER_1));
		Square result = board.getBoard(0, 0);

		assertEquals(expected, result);

		expected = new Square(new Knight(board.PLAYER_1));
		result = board.getBoard(0, 1);

		assertEquals(expected, result);

		expected = new Square(new Bishop(board.PLAYER_1));
		result = board.getBoard(0, 2);

		assertEquals(expected, result);

		expected = new Square(new King(board.PLAYER_1));
		result = board.getBoard(0, 3);

		assertEquals(expected, result);

		expected = new Square(new Queen(board.PLAYER_1));
		result = board.getBoard(0, 4);

		assertEquals(expected, result);

		expected = new Square(new Bishop(board.PLAYER_1));
		result = board.getBoard(0, 5);

		assertEquals(expected, result);

		expected = new Square(new Knight(board.PLAYER_1));
		result = board.getBoard(0, 6);

		assertEquals(expected, result);

		expected = new Square(new Rook(board.PLAYER_1));
		result = board.getBoard(0, 7);

		assertEquals(expected, result);

		// Segunda linea blancas
		expected = new Square(new Pawn(board.PLAYER_1));
		for (int i = 0; i < board.NUM_COLS; i++) {
			result = board.getBoard(1, i);
			
			assertEquals(expected, result);
		}
		
		// Segunda linea negras
		
		expected = new Square(new Pawn(board.PLAYER_2));
		for (int i = 0; i < board.NUM_COLS; i++) {
			result = board.getBoard(board.NUM_ROWS-2, i);
			
			assertEquals(expected, result);
		}
		
		//Primera linea negras
		Square expected = new Square(new Rook(board.PLAYER_2));
		Square result = board.getBoard(board.NUM_ROWS-1, 0);

		assertEquals(expected, result);

		expected = new Square(new Knight(board.PLAYER_2));
		result = board.getBoard(board.NUM_ROWS-1, 1);

		assertEquals(expected, result);

		expected = new Square(new Bishop(board.PLAYER_2));
		result = board.getBoard(board.NUM_ROWS-1, 2);

		assertEquals(expected, result);

		expected = new Square(new King(board.PLAYER_2));
		result = board.getBoard(board.NUM_ROWS-1, 3);

		assertEquals(expected, result);

		expected = new Square(new Queen(board.PLAYER_2));
		result = board.getBoard(board.NUM_ROWS-1, 4);

		assertEquals(expected, result);

		expected = new Square(new Bishop(board.PLAYER_2));
		result = board.getBoard(board.NUM_ROWS-1, 5);

		assertEquals(expected, result);

		expected = new Square(new Knight(board.PLAYER_2));
		result = board.getBoard(board.NUM_ROWS-1, 6);

		assertEquals(expected, result);

		expected = new Square(new Rook(board.PLAYER_2));
		result = board.getBoard(board.NUM_ROWS-1, 7);

		assertEquals(expected, result);


	}

}
