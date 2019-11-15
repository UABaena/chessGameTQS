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

		board.resetBoard(); // Inicializamos fichas

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

		// Inicializa el tablero vac�o para poder testear el movimiento de las piezas
		// libremente

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		// Ejecutando con el rey un mivimiento posible
		Square s1 = new Square(new King(board.PLAYER_1), 0, 0);
		Square s2 = new Square(null, 1, 1);

		
		board.setSquare(s1);
		board.setSquare(s2);

		/* ---------------------- */
		boolean result = board.movePiece(s1, s2);

		assertTrue(result);

		// Comprovar que la posicion final contiene el rey
		Square expected = new Square(new King(board.PLAYER_1), 1, 1);
		Square sResult = board.getSquare(1, 1);
		assertEquals(expected, sResult);

		// Comprovar que la posicion inicial de rey esta vacia
		Square expectedNull = new Square(null, 0, 0);
		sResult = board.getSquare(0, 0);
		assertEquals(expectedNull, sResult);

		// Caballo movimiento imposible

		s1 = new Square(new Knight(board.PLAYER_2), 4, 4);
		s2 = new Square(null, 5, 5);

		board.setSquare(s1);
		board.setSquare(s2);
		result = board.movePiece(s1, s2);
		
		assertFalse(result);

		// Comprovar que la posicion inicial contiene aun el caballo
		sResult = board.getSquare(4, 4);
		expected = new Square(new Knight(board.PLAYER_2), 4, 4);
		assertEquals(expected, sResult);

		// Comprovar que la posici�n final sigue vac�a
		expectedNull = new Square(null, 5, 5);
		sResult = board.getSquare(5, 5);
		assertEquals(expectedNull, sResult);

		
		/*
		 * CASO DONDE UNA PIEZA NO PUDE MOVERSE bloqueada por otras piezas
		 * */
		
		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}
		
		board.setSquare(new Square(new Queen(board.PLAYER_1), 3,3));
		
		board.setSquare(new Square(new Pawn(board.PLAYER_1), 4,3));
		board.setSquare(new Square(new Pawn(board.PLAYER_1), 2,3));
		board.setSquare(new Square(new Pawn(board.PLAYER_1), 3,4));
		board.setSquare(new Square(new Pawn(board.PLAYER_1), 3,2));
		
		Square sOrigin = board.getSquare(3, 3);
		Square sDest = board.getSquare(3, 7);
		
		result = board.movePiece(sOrigin, sDest);
		
		assertFalse(result);
		
		expected = new Square(new Queen(board.PLAYER_1), 3,3);
		sResult = board.getSquare(3, 3);
		
		assertEquals(expected, sResult);
		
		expected = new Square(new Queen(board.PLAYER_1), 3,7);
		sResult = board.getSquare(3, 7);
		
		assertNotEquals(expected, sResult);
		
		
	}

	@Test
	void testCursor() {

		Square s = board.getCursor();

		// Posicion inicial del cursor
		int expected = 0;
		int result = s.getRow();
		assertTrue(expected == result);
		result = s.getCol();
		assertTrue(expected == result);

		// No se deberia poder mover arriba
		board.cursorUp();

		s = board.getCursor();

		expected = -1;
		result = s.getRow();
		assertFalse(expected == result);

		// Movimiento a la derecha
		board.cursorRight();

		expected = 1;
		result = board.getCursor().getCol();
		assertTrue(expected == result);

		// Movimiento abajo
		board.cursorDown();

		expected = 1;
		result = board.getCursor().getRow();
		assertTrue(expected == result);

		// Movimiento a la izquierda
		board.cursorLeft();

		expected = 0;
		result = board.getCursor().getCol();
		assertTrue(expected == result);

		// Moviminto arriba
		board.cursorUp();

		expected = 0;
		result = board.getCursor().getRow();
		assertTrue(expected == result);

		// No poder moverse a la Izquierda
		board.cursorLeft();
		expected = 0;
		int resultRow = board.getCursor().getRow();
		int resultCol = board.getCursor().getCol();

		assertTrue(expected == resultRow);
		assertTrue(expected == resultCol);

		// Esquina abajo a la Izquierda

		board.cursorDown();
		board.cursorDown();
		board.cursorDown();
		board.cursorDown();
		board.cursorDown();
		board.cursorDown();
		board.cursorDown();

		int expectedRow = 7, expectedCol = 0;

		Square sResult = board.getCursor();
		Square sExpected = board.getSquare(7, 0);

		assertEquals(sResult, sExpected);

		// No poder moverse abajo e izquierda en la esquina.
		board.cursorLeft();

		sResult = board.getCursor();
		sExpected = board.getSquare(7, 0);
		assertEquals(sResult, sExpected);

		board.cursorDown();

		sResult = board.getCursor();
		sExpected = board.getSquare(7, 0);
		assertEquals(sResult, sExpected);

		// En el medio del tablero
		board.cursorRight();
		board.cursorUp();
		board.cursorRight();
		board.cursorUp();
		board.cursorRight();
		board.cursorUp();

		sResult = board.getCursor();
		sExpected = board.getSquare(4, 3);
		assertEquals(sResult, sExpected);

		// Esquina arriba a la derecha
		board.cursorRight();
		board.cursorUp();
		board.cursorRight();
		board.cursorUp();
		board.cursorRight();
		board.cursorUp();
		board.cursorRight();
		board.cursorUp();

		sResult = board.getCursor();
		sExpected = board.getSquare(0, 7);
		assertEquals(sResult, sExpected);

		// No se puede mover derecha ni arriba
		board.cursorRight();

		sResult = board.getCursor();
		sExpected = board.getSquare(0, 7);
		assertEquals(sResult, sExpected);

		board.cursorUp();

		sResult = board.getCursor();
		sExpected = board.getSquare(0, 7);
		assertEquals(sResult, sExpected);

		// Esquina abajo a la derecha
		board.cursorDown();
		board.cursorDown();
		board.cursorDown();
		board.cursorDown();
		board.cursorDown();
		board.cursorDown();
		board.cursorDown();

		sResult = board.getCursor();
		sExpected = board.getSquare(7, 7);
		assertEquals(sResult, sExpected);

		board.cursorDown();

		sResult = board.getCursor();
		sExpected = board.getSquare(7, 7);
		assertEquals(sResult, sExpected);

		board.cursorRight();

		sResult = board.getCursor();
		sExpected = board.getSquare(7, 7);
		assertEquals(sResult, sExpected);

	}

}
