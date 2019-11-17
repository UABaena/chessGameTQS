package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SquareTest {

	@Test
	public void testEquals() {
		
		/** STATETEMENT COVERAGE + DECISION CONDITIONAL **/
		
		/* Misma pieza  mismo lugar*/
		Square p1 = new Square(new King(Board.PLAYER_1), 0, 0);
		Square p2 = new Square(new King(Board.PLAYER_1), 0, 0);
		assertEquals(p1, p2);
		
		/* Sin pieza, mismo lugar */
		p1 = new Square(null, 5, 5);
		p2 = new Square(null, 5, 5);
		assertEquals(p1, p2);
		
		
		/* Sin pieza, distinto lugar*/
		p1 = new Square(null, 5, 5);
		p2 = new Square(null, 6, 5);
		assertNotEquals(p1, p2);
		
		
		/* Alternando con y sin pieza */
		p1 = new Square(new King(Board.PLAYER_1), 5, 5);
		p2 = new Square(null, 5, 5);
		assertNotEquals(p1, p2);
		assertNotEquals(p2, p1);
		
		
		/*Misma pieza, distinto lugar */
		p1 = new Square(new Queen(Board.PLAYER_1), 5, 5);
		p2 = new Square(new Queen(Board.PLAYER_1), 5, 6);
		assertNotEquals(p1, p2);
		
		/* Misma piexa, mismo lugar, distonto jugador */
		p1 = new Square(new King(Board.PLAYER_1), 0, 0);
		p2 = new Square(new King(Board.PLAYER_2), 0, 0);
		assertNotEquals(p1, p2);
		
		
		/**  CAIXA NEGRA**/
	
	}
	
	@Test
	public void getSquare() {
		
		/**** TEST CAIXA NEGRA  + STATEMENT COVERAGE  *****/
		
		Board b = new Board();
		
		assertNull(b.getSquare(-1, 0));
		assertNull(b.getSquare(0, -1));	
		assertEquals(b.getSquare(0, 0), new Square(new Rook(Board.PLAYER_1), 0, 0));
		assertEquals(b.getSquare(1, 0), new Square(new Pawn(Board.PLAYER_1), 1, 0));
		assertEquals(b.getSquare(0, 1), new Square(new Knight(Board.PLAYER_1), 0, 1));
		
		
		assertNull(b.getSquare(-1, 7));
		assertNull(b.getSquare(0, 8));
		assertEquals(b.getSquare(0, 7), new Square(new Rook(Board.PLAYER_1), 0, 7));
		assertEquals(b.getSquare(1, 7), new Square(new Pawn(Board.PLAYER_1), 1, 7));
		assertEquals(b.getSquare(0, 6), new Square(new Knight(Board.PLAYER_1), 0, 6));
		
		assertNull(b.getSquare(8, 0));
		assertNull(b.getSquare(7, -1));
		assertEquals(b.getSquare(7, 0), new Square(new Rook(Board.PLAYER_2), 7, 0));
		assertEquals(b.getSquare(6, 0), new Square(new Pawn(Board.PLAYER_2), 6, 0));
		assertEquals(b.getSquare(7, 1), new Square(new Knight(Board.PLAYER_2), 7, 1));

		
		assertNull(b.getSquare(8, 7));
		assertNull(b.getSquare(7, 8));
		assertEquals(b.getSquare(7, 7), new Square(new Rook(Board.PLAYER_2), 7, 7));
		assertEquals(b.getSquare(7, 6), new Square(new Knight(Board.PLAYER_2), 7, 6));
		assertEquals(b.getSquare(6, 7), new Square(new Pawn(Board.PLAYER_2), 6, 7));
		

		
		
		
		
		
	}

}
