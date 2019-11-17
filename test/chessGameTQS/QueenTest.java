package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueenTest {

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
		Square sq1 = new Square(new Queen(board.PLAYER_2), 4, 0);

		board.setSquare(sq1);

		/* Se crean varias pieces para limitar los movimientos de sq1 */

		Square sq2 = new Square(new Pawn(board.PLAYER_2), 4, 1);
		Square sq3 = new Square(new Pawn(board.PLAYER_2), 3, 1);
		Square sq4 = new Square(new King(board.PLAYER_2), 3, 0);

		board.setSquare(sq2);
		board.setSquare(sq3);
		board.setSquare(sq4);
		
		//Pieza de la reina
		Piece p = board.getSquare(4, 0).getPiece();
		List<Square> result = p.getPossibleMoves(board, 4, 0);

		// Crea una lista de las casillas a la que puede ir la pieza inicial

		List<Square> expectedResult = new ArrayList<Square>();
		Square expectedSq1 = board.getSquare(5, 0);
		Square expectedSq2 = board.getSquare(6, 0);
		Square expectedSq3 = board.getSquare(7, 0);
		Square expectedSq4 = board.getSquare(5, 1);
		Square expectedSq5 = board.getSquare(6, 2);
		Square expectedSq6 = board.getSquare(7, 3);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq3);
		expectedResult.add(expectedSq4);
		expectedResult.add(expectedSq5);
		expectedResult.add(expectedSq6);
		
		System.out.println(result);
		System.out.println(expectedResult);
		

		assertArrayEquals(expectedResult.toArray(), result.toArray());

		// Add dos casillas donde NO puede ir la pieza a la lista de movimientos
		// Esperados y se realiza la comprobaci�n

		Square expectedSq7 = board.getSquare(3, 1);
		Square expectedSq8 = board.getSquare(4, 1);

		expectedResult.add(expectedSq7);
		expectedResult.add(expectedSq8);
		assertFalse(Arrays.equals(expectedResult.toArray(), result.toArray()));
		
		// Add una ficha del jugador contrario en la posici�n (6,2)

		Square sq5 = new Square(new King(board.PLAYER_1), 6, 2);

		board.setSquare(sq5);

		expectedResult = new ArrayList<Square>();
		expectedSq1 = board.getSquare(5, 0);
		expectedSq2 = board.getSquare(6, 0);
		expectedSq3 = board.getSquare(7, 0);
		expectedSq4 = board.getSquare(5, 1);
		expectedSq5 = board.getSquare(6, 2);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq3);
		expectedResult.add(expectedSq4);
		expectedResult.add(expectedSq5);

		result = new ArrayList<Square>();
		result = p.getPossibleMoves(board, 4, 0);

		assertArrayEquals(expectedResult.toArray(), result.toArray());
		
		/** COMPLETANDO STATEMENT COVERAGE **/
				
				//Se prueba que el rey esta rodeado de fichas enemigas y que podria moverse a cada una de ellas
			
				for (int i = 0; i < board.NUM_ROWS; i++) {
		
					for (int j = 0; j < board.NUM_COLS; j++) {
		
						board.setSquare(new Square(null, i, j));
		
					}
				}
				
				result = p.getPossibleMoves(board, -1, 0);
				
				assertNull(result);
				
				sq1 = new Square(new Queen(board.PLAYER_2), 1, 4);
				board.setSquare(sq1);
				
				sq2 = new Square(new Pawn(board.PLAYER_1),0, 3);
				sq3 = new Square(new Pawn(board.PLAYER_1), 0, 4);
				sq4 = new Square(new Rook(board.PLAYER_1), 0, 5);
				sq5 = new Square(new Pawn(board.PLAYER_1),0, 3);
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
				
				
				//Se prueba que el rey esta rodeado de fichas enemigas y que podria moverse a cada una de ellas
			
			
				for (int i = 0; i < board.NUM_ROWS; i++) {
					
					for (int j = 0; j < board.NUM_COLS; j++) {
		
						board.setSquare(new Square(null, i, j));
		
					}
				}
				
				sq1 = new Square(new Queen(board.PLAYER_2), 1, 4);
				board.setSquare(sq1);
				
			
				//Colocamos piezas aliadas para limitar los movimientos
				
				sq2 = new Square(new Pawn(board.PLAYER_2), 1, 2);
				sq3 = new Square(new Pawn(board.PLAYER_2), 1, 6);
				sq4 = new Square(new Pawn(board.PLAYER_2), 3, 2);
				sq5 = new Square(new Pawn(board.PLAYER_2), 3, 6);
				sq6 = new Square(new Pawn(board.PLAYER_2), 3, 4);
				
				board.setSquare(sq2);
				board.setSquare(sq3);
				board.setSquare(sq4);
				board.setSquare(sq5);
				board.setSquare(sq6);
				
				
		
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
				

				for (int i = 0; i < board.NUM_ROWS; i++) {
					
					for (int j = 0; j < board.NUM_COLS; j++) {

						board.setSquare(new Square(null, i, j));

					}
				}
				int row = 0;
				int col = 0;
				sq1 = new Square(new Queen(board.PLAYER_2), row, col);
				board.setSquare(sq1);
				
				int expectedN = 21;
				result = board.getSquare(row, col).getPiece().getPossibleMoves(board, row, col);
				
				assertEquals(result.size(),expectedN);
			
				
	            
				
				for (int i = 0; i < board.NUM_ROWS; i++) {
					
					for (int j = 0; j < board.NUM_COLS; j++) {

						board.setSquare(new Square(null, i, j));

					}
				}
				row = 0;
				col = 7;
				sq1 = new Square(new Queen(board.PLAYER_1), row, col);
				board.setSquare(sq1);
				
				expectedN = 21;
				result = board.getSquare(row, col).getPiece().getPossibleMoves(board, row, col);
				
				assertEquals(result.size(),expectedN);
			

				

				for (int i = 0; i < board.NUM_ROWS; i++) {
					
					for (int j = 0; j < board.NUM_COLS; j++) {

						board.setSquare(new Square(null, i, j));

					}
				}
				row = 7;
				col = 0;
				sq1 = new Square(new Queen(board.PLAYER_2), row, col);
				board.setSquare(sq1);
				
				expectedN = 21;
				result = board.getSquare(row, col).getPiece().getPossibleMoves(board, row, col);
				
				assertEquals(result.size(),expectedN);
			
				
	            
				
				for (int i = 0; i < board.NUM_ROWS; i++) {
					
					for (int j = 0; j < board.NUM_COLS; j++) {

						board.setSquare(new Square(null, i, j));

					}
				}
				row = 7;
				col = 7;
				sq1 = new Square(new Queen(board.PLAYER_1), row, col);
				board.setSquare(sq1);
				
				expectedN = 21;
				result = board.getSquare(row, col).getPiece().getPossibleMoves(board, row, col);
				
				assertEquals(result.size(),expectedN);
			
	}
	
	@Test
	void testToString() {
		
		Piece p = new Queen(Board.PLAYER_1);
		String expected = "Q";
		String result = p.toString();
		assertEquals(expected, result);
		
		p = new Queen(Board.PLAYER_2);
		expected = "q";
		result = p.toString();
		assertEquals(expected, result);
		
		
		
		
	}
	
	

}
