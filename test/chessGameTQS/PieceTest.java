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
		
		
		Piece piece = b.getSquare(0, 0).getPiece(); //Recuperamos Torre Player 1
		
		//Rows
		
		List<Square> expectedResult1 = new ArrayList<Square>();
		
	
		List<Square> expectedResult2 = new ArrayList<Square>();
		
		
		expectedResult2.add(b.getSquare(2, 1));
		expectedResult2.add(b.getSquare(3, 1));
		expectedResult2.add(b.getSquare(4, 1));
		expectedResult2.add(b.getSquare(5, 1));
		expectedResult2.add(b.getSquare(6, 1));
		
		
		List<Square> expectedResult3 = new ArrayList<Square>();
		
		expectedResult3.add(b.getSquare(3, 1));
		expectedResult3.add(b.getSquare(2, 1));
		expectedResult3.add(b.getSquare(5, 1));
		expectedResult3.add(b.getSquare(6, 1));
		expectedResult3.add(b.getSquare(4, 0));
		expectedResult3.add(b.getSquare(4, 2));
		expectedResult3.add(b.getSquare(4, 3));
		expectedResult3.add(b.getSquare(4, 4));
		expectedResult3.add(b.getSquare(4, 5));
		expectedResult3.add(b.getSquare(4, 6));
		expectedResult3.add(b.getSquare(4, 7));
		
		List<Square> expectedResult4 = new ArrayList<Square>();
		
		expectedResult4.add(b.getSquare(5, 1));
		expectedResult4.add(b.getSquare(4, 1));
		expectedResult4.add(b.getSquare(3, 1));
		expectedResult4.add(b.getSquare(2, 1));
		expectedResult4.add(b.getSquare(7, 1));
		expectedResult4.add(b.getSquare(6, 0));
		expectedResult4.add(b.getSquare(6, 2));

		
		List<Square> expectedResult5 = new ArrayList<Square>();
		
		expectedResult5.add(b.getSquare(6, 1));
		expectedResult5.add(b.getSquare(7, 0));
		expectedResult5.add(b.getSquare(7, 2));
		
	
		List<Square> result = piece.getPossibleMoves(b, -1, 1);
		
		assertNull(result);
		
		List<Square> result1 = piece.getPossibleMoves(b, 0, 1);
		
		assertArrayEquals(expectedResult1.toArray(), result1.toArray());
		
		List<Square> result2 = piece.getPossibleMoves(b, 1, 1);
		
		assertArrayEquals(expectedResult2.toArray(), result2.toArray());
		
		List<Square> result3 = piece.getPossibleMoves(b, 4, 1);
		
		assertArrayEquals(expectedResult3.toArray(), result3.toArray());
		
		List<Square> result4 = piece.getPossibleMoves(b, 6, 1);
		
		assertArrayEquals(expectedResult4.toArray(), result4.toArray());
		
		List<Square> result5 = piece.getPossibleMoves(b, 7, 1);
		
		assertArrayEquals(expectedResult5.toArray(), result5.toArray());
		
		List<Square> result6 = piece.getPossibleMoves(b, 8, 1);
		
		assertNull(result6);
		
		//Cols
		
		Piece piece2 = b.getSquare(0, 6).getPiece(); //Recuperamos Caballo Player 1
		
		expectedResult1 = new ArrayList<Square>();
		
		expectedResult1.add(b.getSquare(2, 2));
		expectedResult1.add(b.getSquare(3, 1));
		
		expectedResult2 = new ArrayList<Square>();
		
		
		expectedResult2.add(b.getSquare(2, 3));
		expectedResult2.add(b.getSquare(3, 0));
		expectedResult2.add(b.getSquare(3, 2));
	
		
		expectedResult3 = new ArrayList<Square>();
		
		expectedResult3.add(b.getSquare(2, 6));
		expectedResult3.add(b.getSquare(2, 2));
		expectedResult3.add(b.getSquare(3, 3));
		expectedResult3.add(b.getSquare(3, 5));

		
		expectedResult4 = new ArrayList<Square>();
		
		expectedResult4.add(b.getSquare(2, 4));
		expectedResult4.add(b.getSquare(3, 5));
		expectedResult4.add(b.getSquare(3, 7));


		
		expectedResult5 = new ArrayList<Square>();
		
		expectedResult5.add(b.getSquare(2, 5));
		expectedResult5.add(b.getSquare(3, 6));
	
		
	
		result = piece2.getPossibleMoves(b, 1, -1);
		
		assertNull(result);
		
		result1 = piece2.getPossibleMoves(b, 1, 0);
		
		assertArrayEquals(expectedResult1.toArray(), result1.toArray());
		
		result2 = piece2.getPossibleMoves(b, 1, 1);
		
		assertArrayEquals(expectedResult2.toArray(), result2.toArray());
		
		result3 = piece2.getPossibleMoves(b, 1, 4);
		
		assertArrayEquals(expectedResult3.toArray(), result3.toArray());
		
		result4 = piece2.getPossibleMoves(b, 1, 6);
		
		assertArrayEquals(expectedResult4.toArray(), result4.toArray());
		
		result5 = piece2.getPossibleMoves(b, 1, 7);
		
		assertArrayEquals(expectedResult5.toArray(), result5.toArray());
		
		result6 = piece2.getPossibleMoves(b, 1, 8);
		
		assertNull(result6);
		

		
		
		
	}

}
