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
	void testTurnSwap() { //Swap
		
		int expected = board.PLAYER_1;
		int result = board.getPlayerTurn();
		assertTrue( expected == result );
		
		board.swapTurn();
		
		expected = board.PLAYER_2;
		result = board.getPlayerTurn();
		assertTrue( expected == result );
		
		
		board.swapTurn();
		
		expected = board.PLAYER_1;
		result = board.getPlayerTurn();
		assertTrue( expected == result );
		
		
	}
	
	@Test
	void testInitialPosition() {
		
		// Primera linea Blancas
		Square expected = new Square(new Rook(board.PLAYER_1));
		Square result = board.getBoard(0, 0);
		
		assertEquals(expected,result);
		
		expected = new Square(new Knight(board.PLAYER_1));
		result = board.getBoard(0, 1);
		
		
		assertEquals(expected,result);
		
		expected = new Square(new Bishop(board.PLAYER_1));
		result = board.getBoard(0, 2);
		
		assertEquals(expected,result);
		
		expected = new Square(new King(board.PLAYER_1));
		result = board.getBoard(0, 3);
		
		assertEquals(expected,result);
		
		expected = new Square(new Queen(board.PLAYER_1));
		result = board.getBoard(0, 4);
		
		assertEquals(expected,result);
		
		expected = new Square(new Bishop(board.PLAYER_1));
		result = board.getBoard(0, 5);
		
		assertEquals(expected,result);
		
		expected = new Square(new Knight(board.PLAYER_1));
		result = board.getBoard(0, 6);
		
		assertEquals(expected,result);
		
		expected = new Square(new Rook(board.PLAYER_1));
		result = board.getBoard(0, 7);
		
		assertEquals(expected,result);
		
		
		
		
		
	}

}
