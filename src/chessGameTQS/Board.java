package chessGameTQS;

import java.util.ArrayList;
import java.util.List;

public class Board {

	// Variables para determinar quien esta jugando
	public static int PLAYER_1 = 0;// Blancas
	public static int PLAYER_2 = 1;// Negras
	public static int NUM_COLS = 8;
	public static int NUM_ROWS = 8;
	// Variable que determina el turno de una persona
	protected int playerTurn = PLAYER_1;

	// Tablero de juego
	protected Square[][] board = new Square[NUM_ROWS][NUM_COLS];
	protected Square cursor;
	//
	String extraText = "";

	public void setExtraText(String extraText) {
		this.extraText = extraText;
	}

	public Board() {
		resetBoard();
		playerTurn = PLAYER_1;
		cursor = board[0][0];
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

		cursor = board[0][0];
	}

	public void swapTurn() {
		this.playerTurn = (this.playerTurn == this.PLAYER_1) ? this.PLAYER_2 : this.PLAYER_1;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public Square getSquare(int row, int col) {
		
		if (row < 0 || row >= NUM_ROWS || col < 0 || col >= NUM_COLS ) {
			
			return null;
		}
		return board[row][col];
	}

	// Mover una pieza de un cuadrado a otro
	public boolean movePiece(Square sOrigin, Square sDestination) {

		int rowOrigin = sOrigin.getRow();
		int colOrigin = sOrigin.getCol();

		List<Square> result = this.board[rowOrigin][colOrigin].getPiece().getPossibleMoves(this, rowOrigin, colOrigin);

		for (Square sAux : result) {



			if (sAux.equals(sDestination)) {

				Square oldSquare = new Square(null, rowOrigin, colOrigin);

				Square newSquare = new Square(sOrigin.getPiece(), sDestination.getRow(), sDestination.getCol());

				this.setSquare(oldSquare);
				this.setSquare(newSquare);

				return true;
			}

		}

		return false;
	}

	public void setSquare(Square sq) {
		
		int row = sq.getRow();
		int col = sq.getCol();
		
		if (row < 0 || row >= NUM_ROWS || col < 0 || col >= NUM_COLS ) {
			
		}
		else {
			this.board[row][col] = sq;
		}
		

	}

	public void printBoard() {
		System.out.print("\n\n\n\n\n\n\n");
		System.out
				.println("Player: " + (this.playerTurn == Board.PLAYER_1 ? "Player 1" : "Player 2") + " " + extraText);
		System.out.println("________________________________________");

		for (int i = 0; i < this.NUM_ROWS; i++) {
			for (int j = 0; j < this.NUM_COLS; j++) {
				Piece p = board[i][j].getPiece();

				if (p != null)
					System.out.print("| " + p + " |");
				else
					System.out.print("|   |");
			}
			System.out.print("\n");
			// If cursor, pinta cursor, else, pinta vacio
			for (int j = 0; j < this.NUM_COLS; j++) {
				if (cursor.getRow() == i && cursor.getCol() == j) {
					System.out.print("| * |");
				} else {
					System.out.print("|   |");
				}

			}
			System.out.print("\n");
			System.out.println("________________________________________");

		}
		System.out.println("________________________________________");

	}
	


	// Cursor Functions
	public Square getCursor() {
		return cursor;
	}

	public void cursorDown() {
		if (cursor.getRow() < NUM_ROWS - 1)
			cursor = board[cursor.getRow() + 1][cursor.getCol()];
	}

	public void cursorRight() {
		if (cursor.getCol() < NUM_COLS - 1)
			cursor = board[cursor.getRow()][cursor.getCol() + 1];
	}

	public void cursorLeft() {
		if (cursor.getCol() > 0)
			cursor = board[cursor.getRow()][cursor.getCol() - 1];
	}

	public void cursorUp() {
		if (cursor.getRow() > 0)
			cursor = board[cursor.getRow() - 1][cursor.getCol()];
	}
}
