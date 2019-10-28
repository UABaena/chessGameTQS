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
		resetBoard();
		playerTurn = PLAYER_1;
	}

	// El tablero se reestablece a la posición original
	public void resetBoard() {
		board = new Square[NUM_ROWS][NUM_COLS];
		// Blancas
		int rowPiece = 0;
		board[rowPiece][0] = new Square(new Rook(this.PLAYER_1), rowPiece, 0);
		board[rowPiece][1] = new Square(new Knight(this.PLAYER_1), rowPiece, 1);
		board[rowPiece][2] = new Square(new Bishop(this.PLAYER_1), rowPiece, 2);
		board[rowPiece][3] = new Square(new King(this.PLAYER_1), rowPiece, 3);
		board[rowPiece][4] = new Square(new Queen(this.PLAYER_1), rowPiece, 4);
		board[rowPiece][5] = new Square(new Bishop(this.PLAYER_1), rowPiece, 5);
		board[rowPiece][6] = new Square(new Knight(this.PLAYER_1), rowPiece, 6);
		board[rowPiece][7] = new Square(new Rook(this.PLAYER_1), rowPiece, 7);

		rowPiece++;
		// Peones blancos
		for (int i = 0; i < this.NUM_COLS; i++) {
			board[rowPiece][i] = new Square(new Pawn(this.PLAYER_1), rowPiece, i);
		}

		// Peones negros
		rowPiece = this.NUM_ROWS - 2;
		for (int i = 0; i < this.NUM_COLS; i++) {
			board[rowPiece][i] = new Square(new Pawn(this.PLAYER_2), rowPiece, i);
		}
		rowPiece++;
		// Negras
		board[rowPiece][0] = new Square(new Rook(this.PLAYER_2), rowPiece, 0);
		board[rowPiece][1] = new Square(new Knight(this.PLAYER_2), rowPiece, 1);
		board[rowPiece][2] = new Square(new Bishop(this.PLAYER_2), rowPiece, 2);
		board[rowPiece][3] = new Square(new King(this.PLAYER_2), rowPiece, 3);
		board[rowPiece][4] = new Square(new Queen(this.PLAYER_2), rowPiece, 4);
		board[rowPiece][5] = new Square(new Bishop(this.PLAYER_2), rowPiece, 5);
		board[rowPiece][6] = new Square(new Knight(this.PLAYER_2), rowPiece, 6);
		board[rowPiece][7] = new Square(new Rook(this.PLAYER_2), rowPiece, 7);

		// Filas restantes vacias
		for (int row = 2; row < this.NUM_ROWS - 2; row++)
			for (int col = 0; col < this.NUM_COLS; col++)
				board[row][col] = new Square(null, row, col);

	}

	public void swapTurn() {
		this.playerTurn = (this.playerTurn == this.PLAYER_1) ? this.PLAYER_2 : this.PLAYER_1;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public Square getBoard(int row, int col) {
		return board[row][col];
	}

	// Mover una pieza de un cuadrado a otro
	public void movePiece(Square sOrigin, Square sDestination) {

	}

}
