package chessGameTQS;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
		Square sq1 = new Square(new Pawn(board.PLAYER_2), 1, 1);

		board.setSquare(sq1);



		/* Se crean varias pieces para limitar los movimientos de sq1 */

		
		//Pieza peon
		Piece p = board.getSquare(1, 1).getPiece();
		List<Square> result = p.getPossibleMoves(board, 1, 1);

		
        //El peon se encuentra en el inicio por lo que puede avanzar una posicion o dos
		
        
            List<Square> expectedResult = new ArrayList<Square>();
            Square expectedSq1 = board.getSquare(1, 2);
            Square expectedSq2 = board.getSquare(1, 3);

            expectedResult.add(expectedSq1);
            expectedResult.add(expectedSq2);

            assertArrayEquals(expectedResult.toArray(), result.toArray());

		//El peon se encuentra en una posicion no inicial(Solo se puede mover una casilla)
            Square sq10 = new Square(new Pawn(board.PLAYER_2), 1, 3);

            board.setSquare(sq10);

            expectedResult = new ArrayList<Square>();

            Square expectedSq7 = board.getSquare(1, 4);

            expectedResult.add(expectedSq7);

            p = board.getSquare(1, 3).getPiece();

            result = p.getPossibleMoves(board, 1, 3);

            assertArrayEquals(expectedResult.toArray(), result.toArray()); 

		// El peon tiene la posibilidad de comerse a una pieza enemiga y avanzar

		    Square sq5 = new Square(new Pawn(board.PLAYER_1), 2, 4);
            board.setSquare(sq5);
            expectedResult = new ArrayList<Square>();

            expectedSq7 = board.getSquare(1, 4);
            Square expectedSq8 = board.getSquare(2, 4);

            expectedResult.add(expectedSq7);
            expectedResult.add(expectedSq8);


            result = p.getPossibleMoves(board, 1, 3);

		    assertArrayEquals(expectedResult.toArray(), result.toArray());

        // El peon tiene una pieza delante e intenta avanzar (ESTE ASSERT DEBE SER FALSE)

            Square sq6 = new Square(new Pawn(board.PLAYER_1), 1, 4);
        
            expectedResult = new ArrayList<Square>();
            

	}

}