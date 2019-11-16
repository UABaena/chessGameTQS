package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BishopTest {

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

		// Se van a inicializar una serie de piezas y se realizaron los posibles
		// movimientos en funcion de las fichas

		/* El objeto SQ1 siempre va a ser el que vamos a intentar mover */
		Square sq1 = new Square(new Bishop(board.PLAYER_2), 6, 3);

		board.setSquare(sq1);

		/* Se crean varias pieces para limitar los movimientos de sq1 */

		Square sq2 = new Square(new Pawn(board.PLAYER_2), 4, 1);
		Square sq3 = new Square(new Pawn(board.PLAYER_2), 3, 6);
		Square sq4 = new Square(new Rook(board.PLAYER_2), 7, 4);

		board.setSquare(sq2);
		board.setSquare(sq3);
		board.setSquare(sq4);

		// Pieza del alfil
		Piece p = board.getSquare(6, 3).getPiece();

		List<Square> result = p.getPossibleMoves(board, 6, 3);

		// Crea una lista de las casillas a la que puede ir la pieza inicial

		List<Square> expectedResult = new ArrayList<Square>();
		Square expectedSq1 = board.getSquare(5, 2);
		Square expectedSq2 = board.getSquare(5, 4);
		Square expectedSq4 = board.getSquare(4, 5);
		Square expectedSq5 = board.getSquare(7, 2);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq4);
		expectedResult.add(expectedSq5);

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		// Anade dos casillas donde NO puede ir la pieza a la lista de movimientos
		// Esperados y se realiza la comprobacion

		Square expectedSq7 = board.getSquare(7, 4);
		Square expectedSq8 = board.getSquare(4, 1);

		expectedResult.add(expectedSq7);
		expectedResult.add(expectedSq8);

		assertFalse(Arrays.equals(expectedResult.toArray(), result.toArray()));

		// A�ade una ficha del jugador contrario en la posici�n (6,2)

		Square sq5 = new Square(new King(board.PLAYER_1), 4, 5);

		board.setSquare(sq5);

		expectedResult = new ArrayList<Square>();
		expectedSq1 = board.getSquare(5, 2);
		expectedSq2 = board.getSquare(5, 4);
		Square expectedSq3 = board.getSquare(4, 5); // ficha del jugador contrario
		expectedSq4 = board.getSquare(7, 2);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq3);
		expectedResult.add(expectedSq4);

		result = new ArrayList<Square>();
		result = p.getPossibleMoves(board, 6, 3);
		System.out.println(result);
		System.out.println(expectedResult);

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		/*
		 * RESET del tablero, caso sin piezas
		 */

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		sq1 = new Square(new Bishop(board.PLAYER_2), 6, 3);

		board.setSquare(sq1);

		result = board.getSquare(6, 3).getPiece().getPossibleMoves(board, 6, 3);
		expectedResult = new ArrayList<Square>();
		expectedResult.add(board.getSquare(5, 2));
		expectedResult.add(board.getSquare(4, 1));
		expectedResult.add(board.getSquare(3, 0));
		expectedResult.add(board.getSquare(5, 4));
		expectedResult.add(board.getSquare(4, 5));
		expectedResult.add(board.getSquare(3, 6));
		expectedResult.add(board.getSquare(2, 7));
		expectedResult.add(board.getSquare(7, 2));
		expectedResult.add(board.getSquare(7, 4));

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		/*
		 * RESET del tablero caso con piezas enemigas alrededor
		 */

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		board.setSquare(new Square(new Bishop(board.PLAYER_2), 6, 3));
		board.setSquare(new Square(new Pawn(board.PLAYER_1), 5, 2));
		board.setSquare(new Square(new Pawn(board.PLAYER_1), 5, 4));
		board.setSquare(new Square(new Pawn(board.PLAYER_1), 7, 2));
		board.setSquare(new Square(new Pawn(board.PLAYER_1), 7, 4));

		result = board.getSquare(6, 3).getPiece().getPossibleMoves(board, 6, 3);
		expectedResult = new ArrayList<Square>();
		expectedResult.add(board.getSquare(5, 2));
		expectedResult.add(board.getSquare(5, 4));
		expectedResult.add(board.getSquare(7, 2));
		expectedResult.add(board.getSquare(7, 4));

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		/*
		 * RESET del tablero caso con piezas aliadas alrededor
		 */

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		board.setSquare(new Square(new Bishop(board.PLAYER_2), 6, 3));
		board.setSquare(new Square(new Pawn(board.PLAYER_2), 5, 2));
		board.setSquare(new Square(new Pawn(board.PLAYER_2), 5, 4));
		board.setSquare(new Square(new Pawn(board.PLAYER_2), 7, 2));
		board.setSquare(new Square(new Pawn(board.PLAYER_2), 7, 4));

		result = board.getSquare(6, 3).getPiece().getPossibleMoves(board, 6, 3);
		expectedResult = new ArrayList<Square>();

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		/*
		 * RESET del tablero caso con el alfin en la esquina superior izquierda.
		 */

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		board.setSquare(new Square(new Bishop(board.PLAYER_2), 0, 0));

		result = board.getSquare(0, 0).getPiece().getPossibleMoves(board, 0, 0);
		expectedResult = new ArrayList<Square>();
		expectedResult.add(board.getSquare(1, 1));
		expectedResult.add(board.getSquare(2, 2));
		expectedResult.add(board.getSquare(3, 3));
		expectedResult.add(board.getSquare(4, 4));
		expectedResult.add(board.getSquare(5, 5));
		expectedResult.add(board.getSquare(6, 6));
		expectedResult.add(board.getSquare(7, 7));

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		/*
		 * RESET del tablero caso con el alfin en la esquina inferior derecha.
		 */

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		board.setSquare(new Square(new Bishop(board.PLAYER_2), 7, 7));

		result = board.getSquare(7, 7).getPiece().getPossibleMoves(board, 7, 7);
		expectedResult = new ArrayList<Square>();

		expectedResult.add(board.getSquare(6, 6));
		expectedResult.add(board.getSquare(5, 5));
		expectedResult.add(board.getSquare(4, 4));
		expectedResult.add(board.getSquare(3, 3));
		expectedResult.add(board.getSquare(2, 2));
		expectedResult.add(board.getSquare(1, 1));
		expectedResult.add(board.getSquare(0, 0));

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		/*
		 * RESET del tablero caso con el alfin en la esquina inferior izquierda.
		 */

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		board.setSquare(new Square(new Bishop(board.PLAYER_2), 7, 0));

		result = board.getSquare(7, 0).getPiece().getPossibleMoves(board, 7, 0);
		expectedResult = new ArrayList<Square>();

		expectedResult.add(board.getSquare(6, 1));
		expectedResult.add(board.getSquare(5, 2));
		expectedResult.add(board.getSquare(4, 3));
		expectedResult.add(board.getSquare(3, 4));
		expectedResult.add(board.getSquare(2, 5));
		expectedResult.add(board.getSquare(1, 6));
		expectedResult.add(board.getSquare(0, 7));

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		/*
		 * RESET del tablero caso con el alfin en la esquina superior derecha.
		 */

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		board.setSquare(new Square(new Bishop(board.PLAYER_2), 0, 7));

		result = board.getSquare(0, 7).getPiece().getPossibleMoves(board, 0, 7);

		expectedResult = new ArrayList<Square>();

		expectedResult.add(board.getSquare(1, 6));
		expectedResult.add(board.getSquare(2, 5));
		expectedResult.add(board.getSquare(3, 4));
		expectedResult.add(board.getSquare(4, 3));
		expectedResult.add(board.getSquare(5, 2));
		expectedResult.add(board.getSquare(6, 1));
		expectedResult.add(board.getSquare(7, 0));

		assertArrayEquals(expectedResult.toArray(), result.toArray());

	}

	@Test
	void testToString() {
		
		Piece p = new Bishop(Board.PLAYER_1);
		String expected = "B";
		String result = p.toString();
		assertEquals(expected, result);
		
		p = new Bishop(Board.PLAYER_2);
		expected = "b";
		result = p.toString();
		assertEquals(expected, result);
		
		
		
		
	}
}