package chessGameTQS;

public class Square {

	private Piece piece = null;
	private int row = -1;
	private int col = -1;

	
	public Square() {
		
	}
	
	public Square(Piece p) {
		this.piece = p;
	}
	
	public Square(Piece p, int r, int c) {
		this.piece = p;
		this.row = r;
		this.col = c;
	}
	
	@Override
	public String toString() {
		
		return "Pieza: "+ piece + " Fila: " + row + " Columna: "+col;
	}
	
	@Override
	public boolean equals(Object obj) {
		Square s = (Square)obj;
		return (this.piece.equals(s.piece)) && this.row == s.row && this.col == s.col;
	}
	
	public int getCol() {
		return col;
	}
	public int getRow() {
		return row;
	}
	
	
}
