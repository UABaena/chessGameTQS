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
	
	@Test
	public void testContructor() {
		
		Piece p = new King(Board.PLAYER_1);
		
		String sResult = p.getName();
		String sExpected = "Rey";
		
		assertEquals(sResult, sExpected);
		
		int iResult = p.getPlayer();
		int iExpected = Board.PLAYER_1;
		
		assertEquals(iResult, iExpected);
		
		
	}
	
	@Test
	public void testPossibleMoves() {
		
		/*** LOOP TESTING **/
		
		Board b = new Board();
		Piece piece = b.getSquare(0, 0).getPiece();
		
		//Rows
		
		List<Square> result = piece.getPossibleMoves(b, -1, 1);
		List<Square> result1 = piece.getPossibleMoves(b, 0, 1);
		List<Square> result2 = piece.getPossibleMoves(b, 1, 1);
		
		List<Square> result3 = piece.getPossibleMoves(b, 4, 1);
		
		List<Square> result4 = piece.getPossibleMoves(b, 6, 1);
		List<Square> result5 = piece.getPossibleMoves(b, 7, 1);
		List<Square> result6 = piece.getPossibleMoves(b, 8, 1);
		
		
		
		
	}

}
