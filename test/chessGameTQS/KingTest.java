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
		
		//Pieza del rey
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

	}

}
