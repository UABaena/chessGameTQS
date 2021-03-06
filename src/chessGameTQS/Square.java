package chessGameTQS;

public class Square {

	private Piece piece = null;
	private int row = -1;
	private int col = -1;

	public Square(Piece p, int r, int c) {
		this.piece = p;
		this.row = r;
		this.col = c;
	}

	@Override
	public String toString() {

		return "Pieza: " + piece + " Fila: " + row + " Columna: " + col;
	}

	@Override
	public boolean equals(Object obj) {
		Square s = (Square) obj;

		if (s.getPiece() == null && this.getPiece() == null) {

			return (this.getRow() == s.getRow() && this.getCol() == s.getCol());

		}

		if (s.getPiece() == null && this.getPiece() != null)
			return false;
		if (s.getPiece() != null && this.getPiece() == null)
			return false;

		return ((this.piece.equals(s.piece)) && this.getRow() == s.getRow() && this.getCol() == s.getCol());

	}

	public Piece getPiece() {
		return piece;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

}
