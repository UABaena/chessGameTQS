package chessGameTQS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

	private Game game;

	@BeforeEach
	public void setUp() {

	}

	@Test
	public void testisJaque() {
		
		/** DEVELOP TDD **/

		game = new Game();
		Board b = game.getBoard();

		// Tablero iniciado - No hay jaque
		b.resetBoard();
		boolean result = game.isJaque();
		// assertFalse(result);

		// Preparamos tablero para crear jaque

		// Juega el Jugador 1
		Square sOrigin = b.getSquare(1, 3);
		Square sDestination = b.getSquare(3, 3);

		boolean move = b.movePiece(sOrigin, sDestination);

		assertTrue(move);

		result = game.isJaque();
		// assertFalse(result);

		b.swapTurn();

		// Juega el Jugador 2

		sOrigin = b.getSquare(6, 4);
		sDestination = b.getSquare(4, 4);

		move = b.movePiece(sOrigin, sDestination);

		assertTrue(move);

		result = game.isJaque();
		// assertFalse(result);

		b.swapTurn();

		// Juega el Jugador 1

		sOrigin = b.getSquare(0, 2);
		sDestination = b.getSquare(4, 6);

		move = b.movePiece(sOrigin, sDestination);
		assertTrue(move);

	
		
		/** USING MOCK OBJECT **/
		
		// With Mock Object
		
		b = new MockBoard();
		game.setBoard(b);
		result = game.isJaque();
		assertTrue(result);
		

	}

	@Test
	public void testisFinished() {

		// Preparamos tablero con los dos reyes vivos

		game = new Game();
		Board b = game.getBoard();

		// Tablero iniciado - Los dos reyes est�n vivos
		b.resetBoard();

		boolean result = game.isFinished();
		assertFalse(result);

		// Matamos a un rey (Hardcoded) lo eliminamos del tablero

		Square sq1 = new Square(null, 0, 3); // Posicion del rey
		b.setSquare(sq1);

	

		result = game.isFinished();
		assertTrue(result);

	}

	@Test
	public void testgetWinner() {

		// Esta funcion se ejecuta siempre cuando el juegue este acabado.
		
		/*** DECISION COVERAGE + CONDITION COVERAGE + STATEMENT COVERAGE***/

		game = new Game();
		Board b = game.getBoard();

		// Tablero iniciado - Los dos reyes est�n vivos
		b.resetBoard();

		// Matamos a un rey (Hardcoded) lo eliminamos del tablero

		Square sq1 = new Square(null, 0, 3); // Posicion del rey
		b.setSquare(sq1); // Matamos rey jugador 1

		// Gana el jugador 1

		int winnerExpected = Board.PLAYER_2;
		int winner = game.getWinner();

		assertEquals(winner, winnerExpected);

		// Gana el jugador 2

		b.resetBoard();
		sq1 = new Square(null, 7, 3); // Posicion del rey
		b.setSquare(sq1); // Matamos rey jugador 2

		winnerExpected = Board.PLAYER_1;
		winner = game.getWinner();

		assertEquals(winner, winnerExpected);

	}

	@Test
	public void testPlayerTurn() {

		// Movimiento de caballo
		String[] chars = { "d", "p", "s", "s", "a", "p" };
		game = new MockGame(chars);
		Board b = game.getBoard();

		int expectedTurn = b.PLAYER_1;
		int player = b.getPlayerTurn();
		assertEquals(player, expectedTurn);

		// Se juega el turno con los atributos definidos en el MockObject de Game
		game.playTurn();
		b = game.getBoard();

		// Comprovamos que la casilla se ha movido

		Square expected = new Square(null, 0, 1);
		Square result = b.getSquare(0, 1);
		assertEquals(expected, result);

		expected = new Square(new Knight(Board.PLAYER_1), 2, 0);
		result = b.getSquare(2, 0);
		assertEquals(expected, result);

		// Comprovamos que el turno ha cambiado
		expectedTurn = b.PLAYER_2;
		player = b.getPlayerTurn();
		assertEquals(player, expectedTurn);

		// Movimiento de caballo imposible
		String[] chars2 = { "d", "p", "s", "s", "p" };

		game = new MockGame(chars2);
		game.playTurn();
		b = game.getBoard();
		// El caballo siguen en su sitio
		expected = new Square(new Knight(Board.PLAYER_1), 0, 1);
		result = b.getSquare(0, 1);
		assertEquals(expected, result);

		// El turno no ha cambiado
		expectedTurn = b.PLAYER_1;
		player = b.getPlayerTurn();
		assertEquals(player, expectedTurn);

		/*
		 * Reset game
		 */

		String[] chars3 = { "d", "s", "s", "p", "w", "a", "p", "s", "p", "s", "s", "s", "s", "p", "w", "d", "s", "a",
				"w", "p" };
		game = new MockGame(chars3);
		game.playTurn();
		game.playTurn();
		b = game.getBoard();

		result = b.getSquare(2, 0);
		expected = new Square(new Pawn(Board.PLAYER_1), 2, 0);
		assertEquals(result, expected);

		result = b.getSquare(5, 0);
		expected = new Square(new Pawn(Board.PLAYER_2), 5, 0);
		assertEquals(result, expected);

		/* EQUIVOCARSE DE INPUT */
		String[] chars4 = { "f" };
		game = new MockGame(chars4);
		game.playTurn();
		b = game.getBoard();

		result = b.getCursor();
		expected = b.getSquare(0, 1);
		assertNotEquals(result, expected);

		/*
		 * MOVER LA PIEZA DE OTRO JUGADOR Y ERROR AL INTRODUCIR EL DESTINO
		 */

		String[] chars5 = { "s", "s", "s", "s", "s", "s", "s", "p", "w", "w", "w", "w", "w", "w", "p", "f" };
		game = new MockGame(chars5);
		game.playTurn();
		b = game.getBoard();

		result = b.getCursor();
		expected = b.getSquare(0, 1);
		assertNotEquals(result, expected);

		
		System.out.println("JAQUE");
		
		
		/* FORZANDO UN JAQUE */
		String[] chars6 = { "d", "d", "d", "s", "p", "s", "s", "p", "s", "s", "s", "d", "p", "w", "p", "w", "w",
				"w", "w", "w", "a", "a", "p", "d", "s", "d", "s", "d", "s", "d", "s", "p" };
		game = new MockGame(chars6);
		game.playTurn();
		game.playTurn();
		game.playTurn();
		b = game.getBoard();

		result = b.getCursor();
		expected = b.getSquare(0, 1);
		assertNotEquals(result, expected);

	}

	@Test
	public void testCheckInput() {

		String[] list = { "pe" };

		game = new MockGame(list);

		char expectedResult = 'e';
		char result = game.getInput();
		assertEquals(expectedResult, result);

		String[] list2 = { "w", "r", "p" };

		game = new MockGame(list2);

		expectedResult = 'w';
		result = game.getInput();
		assertEquals(expectedResult, result);

		expectedResult = 'r';
		result = game.getInput();
		assertEquals(expectedResult, result);
		expectedResult = 'p';
		result = game.getInput();
		assertEquals(expectedResult, result);

	}

}
