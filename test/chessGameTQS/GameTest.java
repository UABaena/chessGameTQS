package chessGameTQS;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class GameTest {

	private Game game;

	@BeforeEach
	public void setUp() {
		game = new MockGame();
	}

	@Test
	public void testisJaque() {

		Board b = game.getBoard();

		// Tablero iniciado - No hay jaque
		boolean result = game.isJaque();
		assertFalse(result);

		// Preparamos tablero para crear jaque

		result = game.isJaque();
		assertTrue(result);

	}

	@Test
	public void testisFinished() {

		// Preparamos tablero con los dos reyes vivos

		boolean result = game.isFinished();
		assertFalse(result);

		// Matamos a un rey

		result = game.isFinished();
		assertTrue(result);

	}

	@Test
	public void testgetWinner() {
		
		// Esta funcion se ejecuta siempre cuando el juegue este acabado. 
		
		
		//Gana el jugador 1
		
		int winnerExpected = Board.PLAYER_1;
		int winner = game.getWinner();
		
		assertEquals(winner,winnerExpected);
		
		//Gana el jugador 2
		
		winnerExpected = Board.PLAYER_2;
		winner = game.getWinner();
		
		assertEquals(winner,winnerExpected);

	}

	@Test
	public void testselectSquareToMove() {
		
		

	}

	@Test
	public void testplayerTurn() {

	}

}
