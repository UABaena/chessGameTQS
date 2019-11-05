package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testKing {

	private Board board;

	@BeforeEach
	public void setUp() {
		board = new Board();
	}

	/*
	 * EL OBJETIVO DE ESTE METODO ES COMPROVAR QUE LA FICHA SELECCIONADA SOLO PUEDA
	 * REALIZAR LOS MOVIMIENTOS POSIBLES SEG�N COMO EST� EL TABLERO
	 */
	@Test
	void testPossiblesMovements() {

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		// Se van a inicializar una serie de piezas y se realizar�n los posibles
		// movimientos en funci�n de las fichas

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
		
		//Pieza del alfil
		Piece p = board.getSquare(6, 3).getPiece();
		
		
		List<Square> result = p.getPossibleMoves(board, 6, 3);

		// Crea una lista de las casillas a la que puede ir la pieza inicial

		List<Square> expectedResult = new ArrayList<Square>();
		Square expectedSq1 = board.getSquare(7, 2);
		Square expectedSq2 = board.getSquare(5, 2);
        Square expectedSq4 = board.getSquare(5, 4);
        Square expectedSq5 = board.getSquare(4, 5);


		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq4);
        expectedResult.add(expectedSq5);
		
	

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		// A�ade dos casillas donde NO puede ir la pieza a la lista de movimientos
		// Esperados y se realiza la comprobaci�n

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
		expectedSq2 = board.getSquare(7, 2);
        Square expectedSq3 = board.getSquare(4, 5); // ficha del jugador contrario
	

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
        expectedResult.add(expectedSq3);


		result = new ArrayList<Square>();
		result = p.getPossibleMoves(board, 6, 3);

		assertArrayEquals(expectedResult.toArray(), result.toArray());

	}

}