package chessGameTQS;

import java.util.List;
import java.util.Scanner;

public class Game {

	protected Board board;

	private Square origin;
	private Square destination;

	public Game() {
		board = new Board();
	}

	public void printInstrucciones() {

		System.out.println("--------------------------------------------------");
		System.out.println("                    Instrucciones                 ");
		System.out.println("--------------------------------------------------");
		System.out.println("Movimiento:");
		System.out.println("w: Arriba");
		System.out.println("a: Izquierda");
		System.out.println("s: Abajo");
		System.out.println("d: Derecha");
		System.out.println("p: Jugar Casilla");
		System.out.println("--------------------------------------------------");
		System.out.println("Cada turno consiste en jugar 2 casillas,");
		System.out.println("una con la casilla origen y otra de destino.");
		System.out.println("--------------------------------------------------");

	}

	public Board getBoard() {
		return board;
	}

	public boolean isJaque() {

		int turnPlayer = board.getPlayerTurn();

		// Posibles movimientos de la pieza destino

		// hay que pasarle el square sDestination

		Square sKing;

		for (int i = 0; i < Board.NUM_ROWS; i++) {
			for (int j = 0; j < Board.NUM_COLS; j++) {

				if (board.getSquare(i, j).getPiece() != null) {

					List<Square> result = board.getSquare(i, j).getPiece().getPossibleMoves(board, i, j);

					for (Square sAux : result) {

						if (sAux.getPiece() != null && sAux.getPiece().getName() == "Rey") {

							return true;
						}
					}

				}

			}
		}

		return false;
	}

	public boolean isFinished() {

		// Metodo que recorre el tablero y busca los dos reyes, en el momento en el que
		// no estes los dos devuelve true

		int numKings = 0;

		for (int i = 0; i < Board.NUM_ROWS; i++) {
			for (int j = 0; j < Board.NUM_COLS; j++) {

				if (board.getSquare(i, j).getPiece() != null) {

					if (board.getSquare(i, j).getPiece().getName() == "Rey")
						numKings++;

				}

			}
		}

		return !(numKings == 2);
	}

	public int getWinner() {

		for (int i = 0; i < Board.NUM_ROWS; i++) {
			for (int j = 0; j < Board.NUM_COLS; j++) {

				if (board.getSquare(i, j).getPiece() != null) {

					if (board.getSquare(i, j).getPiece().getName() == "Rey" && board.getSquare(i, j).getPiece().getPlayer() == Board.PLAYER_1)
						return Board.PLAYER_1;

				}
			}

		}

		return Board.PLAYER_2;
	}

	public void playTurn() {
		origin = null;
		destination = null;

		board.printBoard();
		board.setExtraText("");
		// Get primera casilla
		boolean valid = false;

		while (!valid) {
			// Coger el caracter
			System.out.println("Introduce la casilla de origen...");

			char c = this.getInput();

			switch (c) {
			case 'w':
				board.cursorUp();
				break;
			case 'a':
				board.cursorLeft();
				break;
			case 's':
				board.cursorDown();
				break;
			case 'd':
				board.cursorRight();
				break;

			case 'p':

				if (board.getCursor().getPiece() != null
						&& board.getCursor().getPiece().getPlayer() == board.getPlayerTurn()) {

					origin = board.getCursor();
					valid = true;

				} else
					board.setExtraText("Infor: No puedes mover esa casilla");

				break;

			default:
				board.setExtraText("Info: Entrada no valida");
				this.printInstrucciones();
				return;
			}
			board.printBoard();
			board.setExtraText("");
		}

		// Get segunda casilla

		valid = false;
		while (!valid) {
			System.out.println("Introduce la casilla de Destino ...");

			// Coger el caracter
			char c = this.getInput();
			switch (c) {
			case 'w':
				board.cursorUp();
				break;
			case 'a':
				board.cursorLeft();
				break;
			case 's':
				board.cursorDown();
				break;
			case 'd':
				board.cursorRight();
				break;

			case 'p':

				destination = board.getCursor();
				valid = true;

				break;

			default:
				board.setExtraText("Info: Entrada no valida");
				this.printInstrucciones();
				return;
			}
			board.printBoard();
		}

		// Realizar Movimiento y cambiar turno

		boolean result = board.movePiece(origin, destination);

		if (result) {

			// llamar jaque
			board.swapTurn();
			if (this.isJaque())
				board.setExtraText("Info: Jaque en el tablero!");

		} else
			board.setExtraText("Info: No puedes mover a esa posicion");

	}

	public char getInput() {

		Scanner scan = new Scanner(System.in);

		String key = scan.next();

		if (key.length() > 1)
			return 'e';
		return key.charAt(0);

	}

}
