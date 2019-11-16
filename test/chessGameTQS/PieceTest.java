package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PieceTest {

	@Test
	public void testEquals() {

		
		Piece p1 = new King(Board.PLAYER_1);
		Piece p2 = new King(Board.PLAYER_2);
		
		assertNotEquals(p1, p2);
		
		p1 = new Queen(Board.PLAYER_1);
		p2 = new Bishop(Board.PLAYER_1);
		assertNotEquals(p1, p2);
		
		
		p1 = new Queen(Board.PLAYER_1);
		p2 = new Bishop(Board.PLAYER_2);
		assertNotEquals(p1, p2);
		
		
		p1 = new King(Board.PLAYER_1);
		p2 = new King(Board.PLAYER_1);
		assertEquals(p1, p2);
		
		
	}

}
