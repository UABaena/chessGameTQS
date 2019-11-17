package chessGameTQS;

public class MockBoard extends Board {

	public MockBoard() {

		this.resetBoard();
	}

	public void resetBoard() {
		board = new Square[NUM_ROWS][NUM_COLS];

		for (int row = 0; row < this.NUM_ROWS; row++)
			for (int col = 0; col < this.NUM_COLS; col++)
				board[row][col] = new Square(null, row, col);

		board[1][2] = new Square(new King(Board.PLAYER_1), 1, 2);
		board[3][6] = new Square(new Pawn(Board.PLAYER_1), 3, 6);
		board[5][0] = new Square(new Rook(Board.PLAYER_1), 5, 0);
		board[2][7] = new Square(new Rook(Board.PLAYER_2), 2, 7);
		board[3][3] = new Square(new Knight(Board.PLAYER_2), 3, 3);
		board[4][1] = new Square(new Bishop(Board.PLAYER_2), 4, 1);
		board[5][5] = new Square(new King(Board.PLAYER_2), 5, 5);

		cursor = board[0][0];
	}
}
