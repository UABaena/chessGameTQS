package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testBoard {

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
		
		//Inicializa el tablero vacío para poder testear el movimiento de las piezas libremente
		
		for (int i = 0; i < board.NUM_ROWS; i++) {
			
			for (int j = 0; j < board.NUM_COLS; j++){
				
				
				board.setSquare(new Square(null,i,j));
				
				
			}			
		}
		
		//Ejecutando con el rey un mivimiento posible
		Square s1 = new Square(new King(board.PLAYER_1), 0, 0);
		Square s2 = new Square(null, 1, 1);
		boolean result = board.movePiece(s1, s2);
		assertTrue(result);
		
		//Comprovar que la posición final contiene el rey
		Square expected = new Square(new King(board.PLAYER_1), 1, 1);
		assertEquals(expected, s2);
		
		//Comprovar que la posición inicial de rey está vacía
		Square expectedNull = new Square(null, 0, 0);
		assertEquals(expectedNull, s1);
		
		
		/* Caballo movimiento imposible */
		
		s1 = new Square(new Knight(board.PLAYER_2), 4, 4);
		s2 = new Square(null, 5, 5);
		result = board.movePiece(s1, s2);
		assertFalse(result);
		
		//Comprovar que la posición inicial contiene aún la reina
		Square expected = new Square(new Knight(board.PLAYER_2), 5, 5);
		assertEquals(expected, s1);
		
		//Comprovar que la posición final sigue vacía
		expectedNull = new Square(null, 5, 5);
		assertEquals(expectedNull, s2);
		
		
		/*Reina movimiento fuera*/
		
		s1 = new Square(new Queen(board.PLAYER_1), 4, 0);
		s2 = new Square(null, 4,8);
		
		result = board.movePiece(s1, s2);
		assertFalse(result);
		
		//Comprovar que la posición inicial contiene aún la reina
		
		expected = new Square(new Queen(board.PLAYER_2), 4, 0);
		assertEquals(expected, s1);
		
		//Comprovar que la posición final sigue vacía
		
		expectedNull = new Square(null, 4, 8);
		assertEquals(expectedNull, s2);
			
		
	}
	
	/* EL OBJETIVO DE ESTE METODO ES COMPROVAR QUE LA FICHA SELECCIONADA SOLO PUEDA REALIZAR LOS MOVIMIENTOS
	   POSIBLES SEGÚN COMO ESTÉ EL TABLERO*/
	@Test
	void testPossiblesMovements() {
		
			for (int i = 0; i < board.NUM_ROWS; i++) {
			
				for (int j = 0; j < board.NUM_COLS; j++){
				
				
				board.setSquare(new Square(null,i,j));
				
				
				}			
			}
			
			//Se van a inicializar una serie de piezas y se realizarán los posibles movimientos en función de las fichas
			
			/* El objeto SQ1 siempre va a ser el que vamos a intentar mover */
			Square sq1 = new Square(new Queen(board.PLAYER_2), 4, 0);
			
			board.setSquare(sq1);
			
			/*Se crean varias pieces para limitar los movimientos de sq1 */
			
			Square sq2 = new Square(new Pawn(board.PLAYER_2), 4, 1);
			Square sq3 = new Square(new Pawn(board.PLAYER_2), 3, 1);
			Square sq4 = new Square(new King(board.PLAYER_2), 3, 0);
			
			board.setSquare(sq2);
			board.setSquare(sq3);
			board.setSquare(sq3);
			
			result = board.getMovements();
			
							//Crea una lista de las casillas a la que puede ir la pieza inicial
			
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
							
							List<Square> result = new ArrayList<Square>();
							result = board.getMovements();
							
							assertArrayEquals(expectedResult, result);
							
							//Añade dos casillas donde NO puede ir la pieza a la lista de movimientos Esperados y se realiza la comprobación
							
							Square expectedSq7 = board.getSquare(3, 1);
							Square expectedSq8 = board.getSquare(4, 1);
							
							expectedResult.add(expectedSq7);
							expectedResult.add(expectedSq8);
							
							assertArrayEquals(expectedResult, result); //Debe dar False
							
			//Añade una ficha del jugador contrario en la posición (6,2)
							
			Square sq5 = new Square(new King(board.PLAYER_1), 6, 2);
			
			board.setSquare(sq3);
			
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
					result = board.getMovements();
					
					assertArrayEquals(expectedResult, result); 
					
			
		
	}
	

}
