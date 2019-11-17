package chessGameTQS;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PawnTest {

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
		
		
		/** DESARROLLO CON TDD **/

		for (int i = 0; i < board.NUM_ROWS; i++) {

			for (int j = 0; j < board.NUM_COLS; j++) {

				board.setSquare(new Square(null, i, j));

			}
		}

		// Se van a inicializar una serie de piezas y se realizar�n los posibles
		// movimientos en funci�n de las fichas

		/* El objeto SQ1 siempre va a ser el que vamos a intentar mover */
		Square sq1 = new Square(new Pawn(board.PLAYER_1), 1, 1);

		board.setSquare(sq1);



		/* Se crean varias pieces para limitar los movimientos de sq1 */

		
		//Pieza peon
		Piece p = board.getSquare(1, 1).getPiece();
		List<Square> result = p.getPossibleMoves(board, 1, 1);

		
        //El peon se encuentra en el inicio por lo que puede avanzar una posicion o dos
		
        
            List<Square> expectedResult = new ArrayList<Square>();
            Square expectedSq1 = board.getSquare(2, 1);
            Square expectedSq2 = board.getSquare(3, 1);

            expectedResult.add(expectedSq1);
            expectedResult.add(expectedSq2);
            
        	


            assertArrayEquals(expectedResult.toArray(), result.toArray());

		//El peon se encuentra en una posicion no inicial(Solo se puede mover una casilla)
            
            Square sq10 = new Square(new Pawn(board.PLAYER_1),3, 1);

            board.setSquare(sq10);

            expectedResult = new ArrayList<Square>();

            Square expectedSq3 = board.getSquare(4, 1);

            expectedResult.add(expectedSq3);

            p = board.getSquare(3, 1).getPiece();

            result = p.getPossibleMoves(board, 3, 1);
            
           

            assertArrayEquals(expectedResult.toArray(), result.toArray()); 

		// El peon tiene la posibilidad de comerse a una pieza enemiga y avanzar

		    Square sq5 = new Square(new Pawn(board.PLAYER_2), 4, 2); //pieza enemiga
            board.setSquare(sq5);
            
            expectedResult = new ArrayList<Square>();

            Square expectedSq4 = board.getSquare(4, 1);
            Square expectedSq5 = board.getSquare(4, 2);

            expectedResult.add(expectedSq4);
            expectedResult.add(expectedSq5);

            
            result = p.getPossibleMoves(board, 3, 1);
            
          

		    assertArrayEquals(expectedResult.toArray(), result.toArray());

        // El peon tiene una pieza delante e intenta avanzar (ESTE ASSERT DEBE SER FALSE)

            Square sq6 = new Square(new Pawn(board.PLAYER_1), 4, 1);
            board.setSquare(sq6);
            
            expectedResult = new ArrayList<Square>();
            
            Square expectedSq6 = board.getSquare( 4,  1);
            result = p.getPossibleMoves(board, 3, 1);
            
            assertFalse(Arrays.equals(expectedResult.toArray(), result.toArray()));
            
            
            /** COMPLETANDO STATEMENT COVERAGE **/
			
					
					//PLAYER1
            
					for (int i = 0; i < board.NUM_ROWS; i++) {
			
						for (int j = 0; j < board.NUM_COLS; j++) {
			
							board.setSquare(new Square(null, i, j));
			
						}
					}
					
					//Probamos movimientos fuera del tablero
					
					result = p.getPossibleMoves(board, -1, 0);
					
					assertNull(result);
					
					sq1 = new Square(new Pawn(board.PLAYER_1), 1, 4);
					board.setSquare(sq1);
					
					p = board.getSquare(1, 4).getPiece();
					
					// Ponemos peones enemigos en diagonal
					
					Square sq2 = new Square(new Pawn(board.PLAYER_2), 2, 3);
					Square sq3 = new Square(new Pawn(board.PLAYER_2), 2, 5);
					
					board.setSquare(sq2);
					board.setSquare(sq3);
					
					result = p.getPossibleMoves(board, 1, 4);
					
					expectedResult = new ArrayList<Square>();
					
					expectedSq1 = board.getSquare(2, 3);
					expectedSq5 = board.getSquare(2, 5);
					
					expectedSq6 = board.getSquare(2, 4); 
					expectedSq3 = board.getSquare(3, 4);
					
					expectedResult.add(expectedSq6);
					expectedResult.add(expectedSq3);
					expectedResult.add(expectedSq5);
					expectedResult.add(expectedSq1);
					
					 System.out.println(result);
			    	 System.out.println(expectedResult);
					
					assertArrayEquals(expectedResult.toArray(), result.toArray());
					
					//PLAYER2
		            
					for (int i = 0; i < board.NUM_ROWS; i++) {
			
						for (int j = 0; j < board.NUM_COLS; j++) {
			
							board.setSquare(new Square(null, i, j));
			
						}
					}
					
					sq1 = new Square(new Pawn(board.PLAYER_2), 6, 4);
					board.setSquare(sq1);
					
					p = board.getSquare(6, 4).getPiece();
					
					// Ponemos peones enemigos en diagonal
					
					sq2 = new Square(new Pawn(board.PLAYER_1), 5, 3);
					sq3 = new Square(new Pawn(board.PLAYER_1), 5, 5);
					
					board.setSquare(sq2);
					board.setSquare(sq3);
					
					result = p.getPossibleMoves(board, 6, 4);
					
					expectedResult = new ArrayList<Square>();
					
					expectedSq1 = board.getSquare(5, 3);
					expectedSq5 = board.getSquare(5, 4);
					
					expectedSq6 = board.getSquare(5, 5); 
					expectedSq3 = board.getSquare(4, 4);
					
					expectedResult.add(expectedSq5);
					expectedResult.add(expectedSq3);
					expectedResult.add(expectedSq6);
					expectedResult.add(expectedSq1);
					
					 System.out.println(result);
			    	 System.out.println(expectedResult);
			    	 
			    	
					
					assertArrayEquals(expectedResult.toArray(), result.toArray());
					
					//Mover el peon sacandolo de la posici�n inicial
					
					sq2 = new Square(new Pawn(board.PLAYER_2), 5, 4);
					sq3 = new Square(null, 6, 4);
					
					board.setSquare(sq2);
					board.setSquare(sq3);
					
					p = board.getSquare(5, 4).getPiece();
					
					
					expectedResult = new ArrayList<Square>();
					
					expectedSq1 = board.getSquare(4, 4);
					
					expectedResult.add(expectedSq1);
					
					result = p.getPossibleMoves(board, 5, 4);
					
					
					assertArrayEquals(expectedResult.toArray(), result.toArray());
					
					
					
		            

	}

}