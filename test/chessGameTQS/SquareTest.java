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
		
		
		/**  **/
		
		
		
		
	}

}
