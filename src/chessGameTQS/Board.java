package chessGameTQS;

public class Board {

	// Variables para determinar quien esta jugando
	public int PLAYER_1 = 0;// Blancas
	public int PLAYER_2 = 1;// Negras
	public int NUM_COLS = 8;
	public int NUM_ROWS = 8;
	// Variable que determina el turno de una persona
	private int playerTurn = PLAYER_1;

	// Tablero de juego
	private Square[][] board = new Square[NUM_ROWS][NUM_COLS];

	public Board() {

	}

	// El tablero se reestablece a la posición original
	public void resetBoard() {

	}

	public void swapTurn() {
		this.playerTurn = (this.playerTurn == this.PLAYER_1) ? this.PLAYER_2 : this.PLAYER_1;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public Square getBoard(int row, int col) {
		return null;
	}

	// Mover una pieza de un cuadrado a otro
	public void movePiece(Square sOrigin, Square sDestination) {

	}

}
