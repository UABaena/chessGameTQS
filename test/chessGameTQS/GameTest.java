package chessGameTQS;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		b.resetBoard();
		boolean result = game.isJaque();
		assertFalse(result);

		// Preparamos tablero para crear jaque

		
		//
		Square s1 = b.getSquare(0, 4);
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

		// Gana el jugador 1

		int winnerExpected = Board.PLAYER_1;
		int winner = game.getWinner();

		assertEquals(winner, winnerExpected);

		// Gana el jugador 2

		winnerExpected = Board.PLAYER_2;
		winner = game.getWinner();

		assertEquals(winner, winnerExpected);

	}

	@Test
	public void testPlayerTurn() {
		
		//Movimiento de caballo
		
		game.playTurn();
		Board b = game.getBoard();
		
		//Comprovamos que la casilla se ha movido
		
		Square expected = new Square(null, 0, 1);
		Square result = b.getSquare(0, 1);
		assertEquals(expected, result);
		
		expected = new Square(new Knight(Board.PLAYER_1), 2, 0);
		result = b.getSquare(2, 0);
		assertEquals(expected, result);
		
		//Comprovamos que el turno ha cambiado
		int player = b.PLAYER_2;
		int expectedTurn = b.getPlayerTurn();
		assertEquals(player, expectedTurn);
		
		

	}
	@Test
	public void testGame() {
		
		//En este metodo se comprueva que el bucle del juego funciona correctamente
		
		
		
		
		
	}

	


}
