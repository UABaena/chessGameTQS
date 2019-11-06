package chessGameTQS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


public class KnightTest {

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
		
		Square sq1 = new Square(new Knight(board.PLAYER_2), 2, 5);
		board.setSquare(sq1);
		
		//Caballo
		
		
		Piece p = board.getSquare(2, 5).getPiece();
		
		System.out.println(p);
		List<Square> result = p.getPossibleMoves(board, 2, 5);
		
		// Crea una lista de las casillas a la que puede ir la pieza inicial

		List<Square> expectedResult = new ArrayList<Square>();
		Square expectedSq1 = board.getSquare(0, 4);
		Square expectedSq2 = board.getSquare(0, 6);
		Square expectedSq3 = board.getSquare(1, 7);
		Square expectedSq4 = board.getSquare(3, 7);
		Square expectedSq5 = board.getSquare(1, 3);
		Square expectedSq6 = board.getSquare(3, 3);
		Square expectedSq7 = board.getSquare(4, 4);
		Square expectedSq8 = board.getSquare(4, 6);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq3);
		expectedResult.add(expectedSq4);
		expectedResult.add(expectedSq5);
		expectedResult.add(expectedSq6);
		expectedResult.add(expectedSq7);
		expectedResult.add(expectedSq8);
		
		


		
		assertArrayEquals(expectedResult.toArray(), result.toArray());
		
		//Add piezas del mismo jugador e intenta ir a su posición.
		
		
		Square sq2 = new Square(new Pawn(board.PLAYER_2), 3, 7);
		Square sq3 = new Square(new Pawn(board.PLAYER_2), 1, 7);
		
		board.setSquare(sq2);
		board.setSquare(sq3);
		
		expectedResult = new ArrayList<Square>();
		
	
		expectedSq7 = board.getSquare(1, 7);
		expectedSq8 = board.getSquare(3, 7);

		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq3);
		expectedResult.add(expectedSq4);
		expectedResult.add(expectedSq5);
		expectedResult.add(expectedSq6);
		expectedResult.add(expectedSq7);
		expectedResult.add(expectedSq8);
		
		result = p.getPossibleMoves(board, 2, 5);
		
	
		assertFalse(Arrays.equals(expectedResult.toArray(), result.toArray()));
		
		
		//Coloca piezas del jugador contrario en los movimientos posibles del caballo
	
		
		Square sq4 = new Square(new Pawn(board.PLAYER_1), 0, 6);
	
		
		board.setSquare(sq4);
		

		
		Piece p1 = board.getSquare(0, 6).getPiece();
	
		result = p.getPossibleMoves(board, 2, 5);
		
		expectedResult = new ArrayList<Square>();
		expectedSq5 = board.getSquare(0, 6);
		
		expectedSq1 = board.getSquare(0, 4);
		expectedSq2 = board.getSquare(0, 6);
		expectedSq3 = board.getSquare(1, 3);
		expectedSq4 = board.getSquare(3, 3);
		expectedSq5 = board.getSquare(4, 4);
		expectedSq6 = board.getSquare(4, 6);
	
		
		
		expectedResult.add(expectedSq1);
		expectedResult.add(expectedSq2);
		expectedResult.add(expectedSq3);
		expectedResult.add(expectedSq4);
		expectedResult.add(expectedSq5);
		expectedResult.add(expectedSq6);

		
		assertArrayEquals(expectedResult.toArray(), result.toArray()); //Debe ser un assert que sea false

		
		
	
	}
	
	
	}