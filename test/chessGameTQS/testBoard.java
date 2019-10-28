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
	void testTurnSwap() {
		
		int expected = board.PLAYER_1;
		int result = board.getPlayerTurn();
		assertTrue( expected == result );
		
		board.swapTurn();
		
		expected = board.PLAYER_2;
		result = board.getPlayerTurn();
		assertTrue( expected == result );
		
	}

}
