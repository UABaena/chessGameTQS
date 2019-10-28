package chessGameTQS;

import java.util.List;

public abstract class Piece {

	protected int player;
	protected String name;
	
	public abstract List<Square> getPossibleMoves(Board b);
	
	@Override
	public String toString() {
	
		return name + " from " + player;
	}
	
	@Override
	public boolean equals(Object obj) {
		Piece p = (Piece) obj;
		return (this.player == p.player) && this.name.equals(p.name);
	}
	
}
