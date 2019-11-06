package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RookTest {

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
		Square sq1 = new Square(new Rook(board.PLAYER_2), 4, 0);

		board.setSquare(sq1);

		/* Se crean varias pieces para limitar los movimientos de sq1 */

		Square sq2 = new Square(new Pawn(board.PLAYER_2), 4, 2);
		Square sq3 = new Square(new Pawn(board.PLAYER_2), 7, 0);


		board.setSquare(sq2);
		board.setSquare(sq3);
	
		
		//Torre
		Piece p = board.getSquare(4, 0).getPiece();
		
		
		List<Square> result = p.getPossibleMoves(board, 4, 0);
		
		

		// Crea una lista de las casillas a la que puede ir la pieza inicial

		List<Square> expectedResult = new ArrayList<Square>();
		Square expectedSq1 = board.getSquare(3, 0);
		Square expectedSq2 = board.getSquare(2, 0);
		Square expectedSq3 = board.getSquare(1, 0);
		Square expectedSq4 = board.getSquare(0, 0);
		Square expectedSq5 = board.getSquare(5, 0);
		Square expectedSq6 = board.getSquare(6, 0);
		Square expectedSq7 = board.getSquare(4, 1);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq3);
		expectedResult.add(expectedSq4);
		expectedResult.add(expectedSq5);
		expectedResult.add(expectedSq6);
		expectedResult.add(expectedSq7);
		
		

		
		

		assertArrayEquals(expectedResult.toArray(), result.toArray());
		
		

		// Add una casilla donde NO puede ir la pieza a la lista de movimientos
		// Esperados y se realiza la comprobacion

		Square expectedSq8 = board.getSquare(3, 1);
		

		expectedResult.add(expectedSq8);

		assertFalse(Arrays.equals(expectedResult.toArray(), result.toArray()));

		// Add una ficha del jugador contrario en la posicion (5,0)

	
		Square sq5 = new Square(new Pawn(board.PLAYER_1), 4, 4);
		Square sq6 = new Square(null, 4, 2); //limpiamos la casilla 4,2 y la ponemos a null

		board.setSquare(sq5);
		board.setSquare(sq6);

		expectedResult = new ArrayList<Square>();
		
		expectedSq1 = board.getSquare(3, 0);
		expectedSq2 = board.getSquare(2, 0);
		expectedSq3 = board.getSquare(1, 0);
		expectedSq4 = board.getSquare(0, 0);
		expectedSq5 = board.getSquare(5, 0);
		expectedSq6 = board.getSquare(6, 0);
		expectedSq7 = board.getSquare(4, 1);
		Square expectedSq9 = board.getSquare(4, 2);
		Square expectedSq10 = board.getSquare(4, 3);
		Square expectedSq11 = board.getSquare(4, 4); // Ficha del jugador contrario

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq3);
		expectedResult.add(expectedSq4);
		expectedResult.add(expectedSq5);
		expectedResult.add(expectedSq6);
		expectedResult.add(expectedSq7);
		expectedResult.add(expectedSq9);
		expectedResult.add(expectedSq10);
		expectedResult.add(expectedSq11);


		result = new ArrayList<Square>();
		result = p.getPossibleMoves(board, 4, 0);
		
		System.out.println(result);
		System.out.println(expectedResult);

		assertArrayEquals(expectedResult.toArray(), result.toArray());
		
	
	
	}

}
