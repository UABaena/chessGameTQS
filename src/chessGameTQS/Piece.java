package chessGameTQS;

import java.util.List;

public abstract class Piece {

	protected int player;
	protected String name;
	
	public abstract List<Square> getPossibleMoves(Board b, int row, int column);
	
	@Override
	public abstract String toString() ;
	
	@Override
	public boolean equals(Object obj) {
		Piece p = (Piece) obj;
		return ((this.player == p.player) && (this.name == name));
	}
	
	public int getPlayer() {
		return player;
	}
	
}
