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
		
		//Posibles movimientos de la pieza destino
		
		//hay que pasarle el square sDestination
		List<Square> result = board.getSquare(this.destination.getRow(), this.destination.getCol()).getPiece().getPossibleMoves(board, this.destination.getRow(), this.destination.getCol());
		
		//Busca el rey del jugador contrario
		
		Square sKing = new Square();
		
		for (int i = 0; i < board.NUM_ROWS; i++) {
			for (int j = 0; j < board.NUM_COLS; j++) {
				
				if (board.getSquare(i, j).getPiece().getName() == "Rey" && board.getSquare(i, j).getPiece().getPlayer() != turnPlayer){
					
					sKing = board.getSquare(i, j);
					
					
				}
			}

		}
		
		for (Square sAux : result) {
			
			
			if (sAux.equals(sKing)) {


				return true;
			}
		}
			
	
		return false;
	}

	public boolean isFinished() {

		//Metodo que recorre el tablero y busca los dos reyes, en el momento en el que no estes los dos devuelve true
		
		int numKings = 0;
		
		for (int i = 0; i < board.NUM_ROWS; i++) {
			for (int j = 0; j < board.NUM_COLS; j++) {
				
				if (board.getSquare(i, j).getPiece().getName() == "Rey") 
					numKings++;
	
			}	
		}
		
		if (numKings == 2)
			return false;
		
		return true;

	}

	public int getWinner() {
		
		int winner = 0;
		
		for (int i = 0; i < board.NUM_ROWS; i++) {
			for (int j = 0; j < board.NUM_COLS; j++) {
				
				if (board.getSquare(i, j).getPiece().getName() == "Rey" && board.getSquare(i, j).getPiece().getPlayer() == board.PLAYER_1) 
					return 0;
	
			}	
		}
		
		return 1;
	
	}

	public void playTurn() {
		origin = null;
		destination = null;

		board.printBoard();

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

				}

				break;

			default:

				return;
			}
			board.printBoard();
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

				return;
			}
			board.printBoard();
		}
		System.out.println(origin+" "+destination);
		// Realizar Movimiento y cambiar turno
		
		boolean result = board.movePiece(origin, destination);
		System.out.println("True?: "+ result);
		
		if (result)
			board.swapTurn();
		
		
		board.printBoard();
	}

	public char getInput() {

		Scanner scan = new Scanner(System.in);
		char key;
		key = scan.next().charAt(0);
		return key;

	}


}
