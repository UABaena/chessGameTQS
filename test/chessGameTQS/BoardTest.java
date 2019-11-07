package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

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
		
		board.resetBoard(); //Inicializamos fichas

		// Primera linea Blancas
		Square expected = new Square(new Rook(board.PLAYER_1), 0, 0);
		Square result = board.getSquare(0, 0);
		


		assertEquals(expected, result);

		expected = new Square(new Knight(board.PLAYER_1), 0, 1);
		result = board.getSquare(0, 1);

		assertEquals(expected, result);

		expected = new Square(new Bishop(board.PLAYER_1), 0, 2);
		result = board.getSquare(0, 2);

		assertEquals(expected, result);

		expected = new Square(new King(board.PLAYER_1), 0, 3);
		result = board.getSquare(0, 3);

		assertEquals(expected, result);

		expected = new Square(new Queen(board.PLAYER_1), 0, 4);
		result = board.getSquare(0, 4);

		assertEquals(expected, result);

		expected = new Square(new Bishop(board.PLAYER_1), 0, 5);
		result = board.getSquare(0, 5);

		assertEquals(expected, result);

		expected = new Square(new Knight(board.PLAYER_1), 0, 6);
		result = board.getSquare(0, 6);

		assertEquals(expected, result);

		expected = new Square(new Rook(board.PLAYER_1), 0, 7);
		result = board.getSquare(0, 7);

		assertEquals(expected, result);

		// Segunda linea blancas

		for (int i = 0; i < board.NUM_COLS; i++) {
			expected = new Square(new Pawn(board.PLAYER_1), 1, i);
			result = board.getSquare(1, i);

			assertEquals(expected, result);
		}

		// Segunda linea negras

		for (int i = 0; i < board.NUM_COLS; i++) {
			expected = new Square(new Pawn(board.PLAYER_2), board.NUM_ROWS - 2, i);
			result = board.getSquare(board.NUM_ROWS - 2, i);

			assertEquals(expected, result);
		}

		// Primera linea negras
		expected = new Square(new Rook(board.PLAYER_2), board.NUM_ROWS - 1, 0);
		result = board.getSquare(board.NUM_ROWS - 1, 0);

		assertEquals(expected, result);

		expected = new Square(new Knight(board.PLAYER_2), board.NUM_ROWS - 1, 1);
		result = board.getSquare(board.NUM_ROWS - 1, 1);

		assertEquals(expected, result);

		expected = new Square(new Bishop(board.PLAYER_2), board.NUM_ROWS - 1, 2);
		result = board.getSquare(board.NUM_ROWS - 1, 2);

		assertEquals(expected, result);

		expected = new Square(new King(board.PLAYER_2), board.NUM_ROWS - 1, 3);
		result = board.getSquare(board.NUM_ROWS - 1, 3);

		assertEquals(expected, result);

		expected = new Square(new Queen(board.PLAYER_2), board.NUM_ROWS - 1, 4);
		result = board.getSquare(board.NUM_ROWS - 1, 4);

		assertEquals(expected, result);

		expected = new Square(new Bishop(board.PLAYER_2), board.NUM_ROWS - 1, 5);
		result = board.getSquare(board.NUM_ROWS - 1, 5);

		assertEquals(expected, result);

		expected = new Square(new Knight(board.PLAYER_2), board.NUM_ROWS - 1, 6);
		result = board.getSquare(board.NUM_ROWS - 1, 6);

		assertEquals(expected, result);

		expected = new Square(new Rook(board.PLAYER_2), board.NUM_ROWS - 1, 7);
		result = board.getSquare(board.NUM_ROWS - 1, 7);

		assertEquals(expected, result);

	}
	
	
	@Test
	void testMovePiece() {
		
		//Inicializa el tablero vac�o para poder testear el movimiento de las piezas libremente
		
		for (int i = 0; i < board.NUM_ROWS; i++) {
			
			for (int j = 0; j < board.NUM_COLS; j++){
				
				
				board.setSquare(new Square(null,i,j));
				
				
			}			
		}
		
		//Ejecutando con el rey un mivimiento posible
		Square s1 = new Square(new King(board.PLAYER_1), 0, 0);
		Square s2 = new Square(null, 1, 1);
		
		/* added in develop branch */
		board.setSquare(s1); 
		board.setSquare(s2);
		
		/* ---------------------- */
		boolean result = board.movePiece(s1, s2);
		


		assertTrue(result);

		System.out.println(board.getSquare(1, 1));
		//Comprovar que la posici�n final contiene el rey
		Square expected = new Square(new King(board.PLAYER_1), 1, 1);
		Square sResult = board.getSquare(1, 1);
		assertEquals(expected, sResult);
		
		//Comprovar que la posici�n inicial de rey est� vac�a
		Square expectedNull = new Square(null, 0, 0);
		sResult = board.getSquare(0, 0);
		assertEquals(expectedNull, sResult);
		

		//Caballo movimiento imposible
	
		
		s1 = new Square(new Knight(board.PLAYER_2), 4, 4);
		s2 = new Square(null, 5, 5);
		
		board.setSquare(s1);
		board.setSquare(s2);
		result = board.movePiece(s1, s2);
		assertFalse(result);
		
		//Comprovar que la posicion inicial contiene aun el caballo
		sResult = board.getSquare(4, 4);
		expected = new Square(new Knight(board.PLAYER_2), 4, 4);
		assertEquals(expected, sResult);
		
		
		//Comprovar que la posici�n final sigue vac�a
		expectedNull = new Square(null, 5, 5);
		sResult = board.getSquare(5, 5);
		assertEquals(expectedNull, sResult);
		
		
		
		
		
		/*Reina movimiento fuera*/
		
		s1 = new Square(new Queen(board.PLAYER_1), 4, 0);
		s2 = new Square(null, 4,8);
		
		board.setSquare(s1); 
		board.setSquare(s2);
		
		result = board.movePiece(s1, s2);
		
		assertFalse(result);
		
		//Comprovar que la posici�n inicial contiene a�n la reina
		
		expected = new Square(new Queen(board.PLAYER_1), 4, 0);
		sResult = board.getSquare(4, 0);
		assertEquals(expected, sResult);
		
		//Comprovar que la posici�n final sigue vac�a
		
		expectedNull = new Square(null, 4, 8);
		sResult = board.getSquare(4, 8);

		assertEquals(expectedNull, sResult);
			
		
		
	}
	
}
