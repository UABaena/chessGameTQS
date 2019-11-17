package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KingTest {

	private Board board;

	@BeforeEach
	public void setUp() {
		board = new Board();
	}

	/*
	 * EL OBJETIVO DE ESTE METODO ES COMPROVAR QUE LA FICHA SELECCIONADA SOLO PUEDA
	 * REALIZAR LOS MOVIMIENTOS POSIBLES SEGUN COMO ESTE EL TABLERO
	 */

	@Test
	void testPossiblesMovements() {

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		// Se van a inicializar una serie de piezas y se realizaran los posibles
		// movimientos en funcion de las fichas

		/* El objeto SQ1 siempre va a ser el que vamos a intentar mover */
		Square sq1 = new Square(new King(board.PLAYER_2), 4, 0);

		board.setSquare(sq1);

		/* Se crean varias pieces para limitar los movimientos de sq1 */

		Square sq2 = new Square(new Pawn(board.PLAYER_2), 4, 1);
		Square sq3 = new Square(new Pawn(board.PLAYER_2), 3, 1);
		Square sq4 = new Square(new Rook(board.PLAYER_2), 3, 0);

		board.setSquare(sq2);
		board.setSquare(sq3);
		board.setSquare(sq4);

		// Pieza del rey
		Piece p = board.getSquare(4, 0).getPiece();

		List<Square> result = p.getPossibleMoves(board, 4, 0);

		// Crea una lista de las casillas a la que puede ir la pieza inicial

		List<Square> expectedResult = new ArrayList<Square>();
		Square expectedSq1 = board.getSquare(5, 0);
		Square expectedSq2 = board.getSquare(5, 1);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		// Add dos casillas donde NO puede ir la pieza a la lista de movimientos
		// Esperados y se realiza la comprobaci�n

		Square expectedSq7 = board.getSquare(3, 1);
		Square expectedSq8 = board.getSquare(4, 1);

		expectedResult.add(expectedSq7);
		expectedResult.add(expectedSq8);

		assertFalse(Arrays.equals(expectedResult.toArray(), result.toArray()));

		// Add una ficha del jugador contrario en la posicion (5,0)

		Square sq5 = new Square(new King(board.PLAYER_1), 5, 0);

		board.setSquare(sq5);

		expectedResult = new ArrayList<Square>();
		expectedSq1 = board.getSquare(5, 0); // ficha del jugador contrario
		expectedSq2 = board.getSquare(5, 1);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);

		result = new ArrayList<Square>();
		result = p.getPossibleMoves(board, 4, 0);

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		/** COMPLETANDO STATEMENT COVERAGE **/

		// Se prueba que el rey esta rodeado de fichas enemigas y que podria moverse a
		// cada una de ellas

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}
		
		result = p.getPossibleMoves(board, -1, 0);
		
		assertNull(result);
		
		sq1 = new Square(new King(board.PLAYER_2), 1, 4);
		board.setSquare(sq1);

		sq2 = new Square(new Pawn(board.PLAYER_1), 0, 3);
		sq3 = new Square(new Pawn(board.PLAYER_1), 0, 4);
		sq4 = new Square(new Rook(board.PLAYER_1), 0, 5);
		sq5 = new Square(new Pawn(board.PLAYER_1), 0, 3);
		Square sq6 = new Square(new Pawn(board.PLAYER_1), 1, 3);
		Square sq7 = new Square(new Rook(board.PLAYER_1), 1, 5);
		Square sq8 = new Square(new Pawn(board.PLAYER_1), 2, 3);
		Square sq9 = new Square(new Pawn(board.PLAYER_1), 2, 4);
		Square sq10 = new Square(new Rook(board.PLAYER_1), 2, 5);

		board.setSquare(sq2);
		board.setSquare(sq3);
		board.setSquare(sq4);
		board.setSquare(sq5);
		board.setSquare(sq6);
		board.setSquare(sq7);
		board.setSquare(sq8);
		board.setSquare(sq9);
		board.setSquare(sq10);

		result = p.getPossibleMoves(board, 1, 4);
		expectedResult = new ArrayList<Square>();

		expectedSq1 = board.getSquare(0, 4);
		Square expectedSq5 = board.getSquare(0, 3);

		Square expectedSq6 = board.getSquare(0, 5);
		Square expectedSq3 = board.getSquare(1, 3);
		Square expectedSq4 = board.getSquare(1, 5);
		expectedSq7 = board.getSquare(2, 3);
		expectedSq2 = board.getSquare(2, 4);
		expectedSq8 = board.getSquare(2, 5);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq3);
		expectedResult.add(expectedSq4);
		expectedResult.add(expectedSq5);
		expectedResult.add(expectedSq6);
		expectedResult.add(expectedSq7);
		expectedResult.add(expectedSq8);

		System.out.println(result);
		System.out.println(expectedResult);

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		// Se prueba que el rey esta rodeado de fichas enemigas y que podria moverse a
		// cada una de ellas

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		sq1 = new Square(new King(board.PLAYER_2), 1, 4);
		board.setSquare(sq1);

		result = p.getPossibleMoves(board, 1, 4);
		expectedResult = new ArrayList<Square>();

		expectedSq1 = board.getSquare(0, 4);
		expectedSq5 = board.getSquare(0, 3);

		expectedSq6 = board.getSquare(0, 5);
		expectedSq3 = board.getSquare(1, 3);
		expectedSq4 = board.getSquare(1, 5);
		expectedSq7 = board.getSquare(2, 3);
		expectedSq2 = board.getSquare(2, 4);
		expectedSq8 = board.getSquare(2, 5);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq3);
		expectedResult.add(expectedSq4);
		expectedResult.add(expectedSq5);
		expectedResult.add(expectedSq6);
		expectedResult.add(expectedSq7);
		expectedResult.add(expectedSq8);

		System.out.println(result);
		System.out.println(expectedResult);

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		// Rey esquina izquierda-Arriba

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		sq1 = new Square(new King(board.PLAYER_2), 0, 0);
		board.setSquare(sq1);

		sq2 = new Square(new Pawn(board.PLAYER_2), 1, 1);
		sq3 = new Square(new Pawn(board.PLAYER_2), 0, 1);
		sq4 = new Square(new Rook(board.PLAYER_2), 1, 0);

		board.setSquare(sq2);
		board.setSquare(sq3);
		board.setSquare(sq4);

		result = board.getSquare(0, 0).getPiece().getPossibleMoves(board, 0, 0);
		System.out.println(result);

		expectedResult = new ArrayList<Square>();
		System.out.println(expectedResult);

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		// Rey esquina izquierda-Abajo

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		sq1 = new Square(new King(board.PLAYER_2), 7, 0);
		board.setSquare(sq1);

		sq2 = new Square(new Pawn(board.PLAYER_2), 7, 1);
		sq3 = new Square(new Pawn(board.PLAYER_2), 6, 0);
		sq4 = new Square(new Rook(board.PLAYER_2), 6, 1);

		board.setSquare(sq2);
		board.setSquare(sq3);
		board.setSquare(sq4);

		result = board.getSquare(7, 0).getPiece().getPossibleMoves(board, 7, 0);

		expectedResult = new ArrayList<Square>();
	
		assertArrayEquals(expectedResult.toArray(), result.toArray());

		// Rey esquina derecha-arriba

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		sq1 = new Square(new King(board.PLAYER_2), 0, 7);
		board.setSquare(sq1);

		sq2 = new Square(new Pawn(board.PLAYER_2), 1, 7);
		sq3 = new Square(new Pawn(board.PLAYER_2), 0, 6);
		sq4 = new Square(new Rook(board.PLAYER_2), 1, 6);

		board.setSquare(sq2);
		board.setSquare(sq3);
		board.setSquare(sq4);

		result = board.getSquare(0, 7).getPiece().getPossibleMoves(board, 0, 7);

		expectedResult = new ArrayList<Square>();
	

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		// Rey esquina derecha abajo

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		sq1 = new Square(new King(board.PLAYER_2), 7, 7);
		board.setSquare(sq1);

		sq2 = new Square(new Pawn(board.PLAYER_2), 6, 7);
		sq3 = new Square(new Pawn(board.PLAYER_2), 7, 6);
		sq4 = new Square(new Rook(board.PLAYER_2), 6, 6);

		board.setSquare(sq2);
		board.setSquare(sq3);
		board.setSquare(sq4);

		result = board.getSquare(7, 7).getPiece().getPossibleMoves(board, 7, 7);

		expectedResult = new ArrayList<Square>();
	

		assertArrayEquals(expectedResult.toArray(), result.toArray());

	}

	@Test
	void testToString() {

		Piece p = new King(Board.PLAYER_1);
		String expected = "K";
		String result = p.toString();
		assertEquals(expected, result);

		p = new King(Board.PLAYER_2);
		expected = "k";
		result = p.toString();
		assertEquals(expected, result);

	}

}
